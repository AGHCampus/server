package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Role;
import pl.edu.agh.server.repostiory.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getRolesList() {
        return roleRepository.findAll();
    }
}
