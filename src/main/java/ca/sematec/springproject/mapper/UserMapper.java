package ca.sematec.springproject.mapper;



import ca.sematec.springproject.dto.UserRequest;
import ca.sematec.springproject.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    UserRequest userToUserDTO(User user);
    List<UserRequest> usersToUserDTOs(List<User> users);
    @InheritInverseConfiguration
    User userDTOToUser(UserRequest userDTO);
}
