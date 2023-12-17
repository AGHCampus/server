package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.requests.UserResponse;
import pl.edu.agh.server.service.UserManagementService;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserManagementService userManagementService;

    @GetMapping(value = "", produces = "application/json")
    public List<UserResponse> getUsersList() {
        return userManagementService.getUsersList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public UserResponse getUsersList(@PathVariable long id) {
        return userManagementService.getUser(id);
    }

    @PutMapping(value = "/{id}/enable", produces = "application/json")
    public ResponseEntity<String> sendActivationEmail(@PathVariable long id) {
        userManagementService.sendActivationEmail(id);
        return ResponseEntity.ok("Activation email sent");
    }

    @PutMapping(value = "/{id}/disable", produces = "application/json")
    public ResponseEntity<String> disableAccount(@PathVariable long id) {
        userManagementService.disableUser(id);
        return ResponseEntity.ok("Account disabled");
    }

    @PutMapping(value = "/{id}/reset-password", produces = "application/json")
    public ResponseEntity<String> resetPassword(@PathVariable long id) {
        userManagementService.resetPassword(id);
        return ResponseEntity.ok("Reset password email sent");
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public UserResponse updateUser(@PathVariable long id, @RequestBody UserResponse user) {
        return null;
    }

    @PostMapping(value = "", produces = "application/json")
    public UserResponse createUser(@RequestBody UserResponse user) {
        return null;
    }
}
