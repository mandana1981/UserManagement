package ca.sematec.springproject.mapper;



import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    UserDTO userToUserDTO(User user);
    List<UserDTO> usersToUserDTOs(List<User> users);
    @InheritInverseConfiguration
    User userDTOToUser(UserDTO userDTO);
}
