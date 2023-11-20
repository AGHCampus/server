package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.LoginResponse;
import pl.edu.agh.server.model.User;
import pl.edu.agh.server.service.AuthenticationService;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authenticationService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody User user) {
        return authenticationService.loginUser(user);
    }
}
