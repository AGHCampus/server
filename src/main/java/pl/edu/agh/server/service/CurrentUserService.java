package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.Role;
import pl.edu.agh.server.repostiory.RoleRepository;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrentUserService {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public boolean hasAdminPermissions() {
        return getRoles().stream().anyMatch(role -> role.getAuthority().equals("ADMIN"));
    }

    public Set<Long> getLocationIds() {
        return getRoles().stream()
                .flatMap(role -> role.getAssociatedLocationIds().stream())
                .collect(Collectors.toSet());
    }

    public boolean isUnauthorizedForLocation(long id) {
        if (hasAdminPermissions()) return false;
        return getRoles().stream()
                .flatMap(role -> role.getAssociatedLocationIds().stream())
                .noneMatch(locationId -> locationId == id);
    }

    public void addLocationToRole(Location location) {
        getRoles().stream()
                .filter(role -> !role.getAuthority().equals("ADMIN") && !role.getAuthority().equals("USER"))
                .forEach(role -> {
                    role.addLocation(location);
                    roleRepository.save(role);
                });
    }

    private Collection<Role> getRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        String username = authentication.getName();
        UserDetails user = userService.loadUserByUsername(username);
        return  (Collection<Role>) user.getAuthorities();
    }
}
