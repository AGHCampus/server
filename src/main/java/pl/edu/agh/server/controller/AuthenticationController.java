package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.LoginResponse;
import pl.edu.agh.server.model.User;
import pl.edu.agh.server.service.AuthenticationService;

import java.util.Optional;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user, @RequestParam Optional<String> lang) {
        return authenticationService.registerUser(user, lang);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String token) {
        authenticationService.verifyUser(token);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody User user) {
        return authenticationService.loginUser(user);
    }
}
