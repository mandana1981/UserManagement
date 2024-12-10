package ca.sematec.springproject.service;

import ca.sematec.springproject.dto.RoleDTO;
import ca.sematec.springproject.entity.Role;
import ca.sematec.springproject.mapper.RoleMapper;
import ca.sematec.springproject.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    public List<RoleDTO> getAllRoles() {
        return roleMapper.rolesToRoleDTOs(roleRepository.findAll());
    }

    public RoleDTO getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {

            return roleMapper.roleToRoleDTO(role.get());

        } else {
            throw new EntityNotFoundException("Role not found!");

        }
    }

    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role=roleMapper.roleDTOToRole(roleDTO);
        roleRepository.save(role);
        return (roleDTO);
    }

    public void deleteRole(Long id) {
        Role role = roleMapper.roleDTOToRole(getRoleById(id));
       roleRepository.delete(role);
    }

    public RoleDTO updateRole(RoleDTO roleDTO) {
        RoleDTO roleDTOToUpdate = getRoleById(roleDTO.getId());
        roleDTOToUpdate.setName(roleDTO.getName());
        Role updatedRole=roleMapper.roleDTOToRole(roleDTOToUpdate);
        return roleDTOToUpdate;
    }

}
