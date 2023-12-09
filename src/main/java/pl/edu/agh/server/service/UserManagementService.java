package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.requests.UserResponse;
import pl.edu.agh.server.model.User;
import pl.edu.agh.server.repostiory.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private static final String NOT_FOUND_MESSAGE = "User not found with id: ";
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public List<UserResponse> getUsersList() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse::create)
                .toList();
    }

    public UserResponse getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        return UserResponse.create(user);
    }

    public void sendActivationEmail(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        authenticationService.sendVerificationEmail(user, Optional.empty());
    }

    public void disableUser(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        user.setEnabled(false);

        userRepository.save(user);
    }

    public void resetPassword(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        authenticationService.resetPassword(user, Optional.empty());
    }
}
