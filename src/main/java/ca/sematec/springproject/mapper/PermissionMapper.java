package ca.sematec.springproject.mapper;
import ca.sematec.springproject.dto.PermissionDTO;
import ca.sematec.springproject.entity.Permission;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionMapper INSTANCE= Mappers.getMapper(PermissionMapper.class);
    PermissionDTO permissionToPermissionDTO(Permission permission);
    List<PermissionDTO> permissionsToPermissionDTOs(List<Permission> permissions);
    @InheritInverseConfiguration
    Permission permissionDTOToPermission(PermissionDTO permissionDTO);
}
