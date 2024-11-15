package ca.sematec.springproject.service;

import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.mapper.UserMapper;
import ca.sematec.springproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {


             return userMapper.userToUserDTO(user.get());


        } else {
            throw new EntityNotFoundException("User not found!");

        }
    }

    public User addUser(User user) {

        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        User user=getUserById(id);
        userRepository.delete(user);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserDTO userDTOToUpdate=getUserById(userDTO.getId());
        userDTOToUpdate.setUsername(userDTO.getUsername());
        User updatedUser=userMapper.userDTOToUser(userDTOToUpdate);
        userRepository.save(updatedUser);
        return userDTOToUpdate;

    }


}


