package ca.sematec.springproject.mapper;
import ca.sematec.springproject.dto.RoleDTO;
import ca.sematec.springproject.entity.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE= Mappers.getMapper(RoleMapper.class);
    RoleDTO roleToRoleDTO(Role role);
    List<RoleDTO> rolesToRoleDTOs(List<Role> roles);
    @InheritInverseConfiguration
    Role roleDTOToRole(RoleDTO roleDTO);
}
