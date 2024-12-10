package ca.sematec.springproject.controller;

import ca.sematec.springproject.dto.PermissionDTO;
import ca.sematec.springproject.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<PermissionDTO>> getAllPermissions() {
        List<PermissionDTO> permissionDTOS=permissionService.getAllPermissions();
        return ResponseEntity.ok(permissionDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> getPermissionById(@PathVariable Long id) {
        PermissionDTO permissionDTO=permissionService.getPermissionById(id);
        return ResponseEntity.ok(permissionDTO);
    }

    @PostMapping
    public ResponseEntity<PermissionDTO> addPermission(@RequestBody PermissionDTO permissionDTO) {
        return ResponseEntity.ok(permissionService.addPermission(permissionDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<PermissionDTO> updatePermission(@RequestBody PermissionDTO permissionDTO) {
        return ResponseEntity.ok(permissionService.updatePermission(permissionDTO));
    }


}
