package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.agh.server.common.LoginResponse;
import pl.edu.agh.server.common.requests.ChangePasswordRequest;
import pl.edu.agh.server.model.Role;
import pl.edu.agh.server.model.Token;
import pl.edu.agh.server.model.User;
import pl.edu.agh.server.repostiory.RoleRepository;
import pl.edu.agh.server.repostiory.TokenRepository;
import pl.edu.agh.server.repostiory.UserRepository;

import java.util.*;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private static final String VERIFICATION_TYPE = "VERIFICATION";
    private static final String RESET_TYPE = "RESET";
    private static final String USER_ROLE = "USER";
    private static final String USER_DOMAIN = "agh.edu.pl";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final MailService mailService;

    public User registerUser(User requestUser, Optional<String> lang) {
        if (!requestUser.getUsername().endsWith(USER_DOMAIN)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Set<Role> authorities = createAuthorities(USER_ROLE);
        User newUser = User.builder()
                .username(requestUser.getUsername())
                .password(passwordEncoder.encode(requestUser.getPassword()))
                .nickname(requestUser.getNickname())
                .authorities(authorities)
                .build();
        User createdUser = userRepository.save(newUser);

        Token verificationToken = Token.builder()
                .value(UUID.randomUUID().toString())
                .type(VERIFICATION_TYPE)
                .userId(createdUser.getId())
                .build();
        Token createdToken = tokenRepository.save(verificationToken);

        createVerificationEmail(createdToken, createdUser, lang);

        return createdUser;
    }

    public void verifyUser(String tokenValue) {
        Token token = tokenRepository.findTokenByValueAndTypeAndUsedFalse(tokenValue, VERIFICATION_TYPE).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        User user = token.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        token.setUsed(true);
        tokenRepository.save(token);
    }

    public LoginResponse loginUser(User requestUser) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestUser.getUsername(), requestUser.getPassword())
            );

            String token = jwtTokenService.generateJwt(authentication);
            User user = userRepository.findUserByUsername(requestUser.getUsername()).orElseThrow(
                    () -> new UsernameNotFoundException(null)
            );

            return new LoginResponse(user, token);
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    public void changePassword(ChangePasswordRequest request) {
        User user = userRepository.findUserByUsername(request.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException(null)
        );

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    public void resetPassword(User userRequest, Optional<String> lang) {
        User user = userRepository.findUserByUsername(userRequest.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException(null)
        );

        Token verificationToken = Token.builder()
                .value(UUID.randomUUID().toString())
                .type(RESET_TYPE)
                .userId(user.getId())
                .build();
        Token createdToken = tokenRepository.save(verificationToken);

        createResetPasswordEmail(createdToken, user, lang);
    }

    public String validatePasswordReset(String tokenValue) {
        Token token = tokenRepository.findTokenByValueAndTypeAndUsedFalse(tokenValue, RESET_TYPE).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        String temporaryPassword = RandomStringUtils.randomAlphanumeric(12);

        User user = token.getUser();
        user.setPassword(passwordEncoder.encode(temporaryPassword));
        userRepository.save(user);
        token.setUsed(true);
        tokenRepository.save(token);

        return temporaryPassword;
    }

    private Set<Role> createAuthorities(String authorityName) {
        Optional<Role> role = roleRepository.findByAuthority(authorityName);
        if (role.isEmpty()) return Collections.emptySet();

        Set<Role> authorities = new HashSet<>();
        authorities.add(role.get());

        return authorities;
    }

    private void createVerificationEmail(Token token, User user, Optional<String> lang) {
        String homeURL = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String userLang = lang.orElse("PL").toUpperCase();
        String verificationUrl = format("%s/auth/verify?token=%s&lang=%s", homeURL, token.getValue(), userLang);
        mailService.sendVerificationEmail(userLang, user.getUsername(), verificationUrl);
    }

    private void createResetPasswordEmail(Token token, User user, Optional<String> lang) {
        String homeURL = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String userLang = lang.orElse("PL").toUpperCase();
        String verificationUrl = format("%s/auth/reset?token=%s&lang=%s", homeURL, token.getValue(), userLang);
        mailService.sendResetPasswordEmail(userLang, user.getUsername(), verificationUrl);
    }
}
