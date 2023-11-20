package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.LoginResponse;
import pl.edu.agh.server.model.Role;
import pl.edu.agh.server.model.User;
import pl.edu.agh.server.repostiory.RoleRepository;
import pl.edu.agh.server.repostiory.UserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private static final String USER_ROLE = "USER";
    private static final String USER_DOMAIN = "agh.edu.pl";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public User registerUser(User requestUser) {
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

        return userRepository.save(newUser);
    }

    public LoginResponse loginUser(User requestUser) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestUser.getUsername(), requestUser.getPassword())
            );

            String token = tokenService.generateJwt(authentication);
            User user = userRepository.findUserByUsername(requestUser.getUsername()).orElseThrow(
                    () -> new UsernameNotFoundException("")
            );

            return new LoginResponse(user, token);
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    private Set<Role> createAuthorities(String authorityName) {
        Optional<Role> role = roleRepository.findByAuthority(authorityName);
        if (role.isEmpty()) return Collections.emptySet();

        Set<Role> authorities = new HashSet<>();
        authorities.add(role.get());
        return authorities;
    }
}
