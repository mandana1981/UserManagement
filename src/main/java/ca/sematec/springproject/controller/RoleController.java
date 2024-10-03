package ca.sematec.springproject.controller;

import ca.sematec.springproject.entity.Role;
import ca.sematec.springproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRole(@RequestBody Role role) {
        roleService.deleteRole(role.getId());
       return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
       return ResponseEntity.ok(roleService.updateRole(role));
    }


}
