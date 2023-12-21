package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.model.Role;
import pl.edu.agh.server.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping(value = "", produces = "application/json")
    public List<Role> getRolesList() {
        return roleService.getRolesList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Role getRole(@PathVariable long id) {
        return null;
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Role updateRole(@PathVariable long id, @RequestBody Role role) {
        return null;
    }

    @PostMapping(value = "", produces = "application/json")
    public Role createRole(@RequestBody Role role) {
        return null;
    }
}
