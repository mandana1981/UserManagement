package ca.sematec.springproject.service;

import ca.sematec.springproject.dto.PermissionDTO;
import ca.sematec.springproject.entity.Permission;
import ca.sematec.springproject.mapper.PermissionMapper;
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
    @Autowired
    PermissionMapper permissionMapper;


    public List<PermissionDTO> getAllPermissions() {

        return permissionMapper.permissionsToPermissionDTOs(permissionRepository.findAll());
    }
    public PermissionDTO getPermissionById(Long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        if (permission.isPresent()) {
            return permissionMapper.permissionToPermissionDTO(permission.get());
        }else {
            throw new EntityNotFoundException("Permission not found");
        }
    }

    public PermissionDTO addPermission(PermissionDTO permissionDTO) {
        Permission permission=permissionMapper.permissionDTOToPermission(permissionDTO);
        permissionRepository.save(permission);
        return permissionDTO;
    }
    public void deletePermission(Long id) {
        Permission permission=permissionMapper.permissionDTOToPermission(getPermissionById(id));
        permissionRepository.delete(permission);
    }


    public PermissionDTO updatePermission(PermissionDTO permissionDTO) {
        PermissionDTO permissionDTOToUpdate = getPermissionById(permissionDTO.getId());
        permissionDTOToUpdate.setName(permissionDTO.getName());
        Permission updatedPermission=permissionMapper.permissionDTOToPermission(permissionDTOToUpdate);
         permissionRepository.save(updatedPermission);
         return permissionDTOToUpdate;
    }


}
