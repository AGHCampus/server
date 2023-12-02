package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.TranslatedEmailMessages;
import pl.edu.agh.server.common.LoginResponse;
import pl.edu.agh.server.common.requests.ChangePasswordRequest;
import pl.edu.agh.server.model.User;
import pl.edu.agh.server.service.AuthenticationService;

import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user, @RequestParam Optional<String> lang) {
        return authenticationService.registerUser(user, lang);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String token, @RequestParam String lang) {
        authenticationService.verifyUser(token);
        return new ResponseEntity<>(TranslatedEmailMessages.verified(lang), HttpStatus.OK);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody User user) {
        return authenticationService.loginUser(user);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        authenticationService.changePassword(request);
        return new ResponseEntity<>("Password updated", HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody User user, @RequestParam Optional<String> lang) {
        authenticationService.resetPassword(user, lang);
        return new ResponseEntity<>("Reset password email sent", HttpStatus.OK);
    }

    @GetMapping("/reset")
    public ResponseEntity<String> validatePasswordReset(@RequestParam String token, @RequestParam String lang) {
        String temporaryPassword = authenticationService.validatePasswordReset(token);
        return new ResponseEntity<>(format(TranslatedEmailMessages.reset(lang), temporaryPassword), HttpStatus.OK);
    }
}
