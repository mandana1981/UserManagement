package ca.sematec.springproject.service;

import ca.sematec.springproject.entity.Role;
import ca.sematec.springproject.entity.User;
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

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            return role.get();
        } else {
            throw new EntityNotFoundException("Role not found!");

        }
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        Role role = getRoleById(id);
       roleRepository.delete(role);
    }

    public Role updateRole(Role role) {
        Role roleToUpdate = getRoleById(role.getId());
        roleToUpdate.setName(role.getName());
        return roleRepository.save(roleToUpdate);
    }

}
