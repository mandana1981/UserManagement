package ca.sematec.springproject.controller;

import ca.sematec.springproject.dto.RoleDTO;
import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.Role;
import ca.sematec.springproject.entity.User;
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
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roleDTOS=roleService.getAllRoles();
        return ResponseEntity.ok(roleDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        RoleDTO roleDTO=roleService.getRoleById(id);
        return ResponseEntity.ok(roleDTO);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.addRole(roleDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {
       return ResponseEntity.ok(roleService.updateRole(roleDTO));
    }

}
