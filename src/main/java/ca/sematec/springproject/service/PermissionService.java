package ca.sematec.springproject.service;

import ca.sematec.springproject.entity.Permission;
import ca.sematec.springproject.repository.PermissionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(Long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        if (permission.isPresent()) {
            return permission.get();
        }else {
            throw new EntityNotFoundException("Permission not found");
        }
    }
    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermission(Long id) {
        Permission permission=getPermissionById(id);
        permissionRepository.delete(permission);
    }

    public Permission updatePermission(Permission permission) {
        Permission permissionToUpdate = getPermissionById(permission.getId());
        permissionToUpdate.setName(permission.getName());
        return permissionRepository.save(permissionToUpdate);
    }


}
