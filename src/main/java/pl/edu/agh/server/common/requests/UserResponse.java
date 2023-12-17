package pl.edu.agh.server.common.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.edu.agh.server.model.Role;
import pl.edu.agh.server.model.User;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserResponse {
    private long id;
    private String email;
    private String username;
    private Set<Role> roles;
    private boolean enabled;

    public static UserResponse create(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getUsername())
                .username(user.getNickname())
                .roles(user.getAuthorities())
                .enabled(user.isEnabled())
                .build();
    }
}
