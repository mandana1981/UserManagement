package ca.sematec.springproject.controller;

import ca.sematec.springproject.entity.Permission;
import ca.sematec.springproject.service.PermissionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @PostMapping
    public ResponseEntity<Permission> addPermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.addPermission(permission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Permission> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Permission> updatePermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.updatePermission(permission));
    }


}
