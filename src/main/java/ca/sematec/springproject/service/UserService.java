package ca.sematec.springproject.service;

import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.mapper.UserMapper;
import ca.sematec.springproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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
        User user = getUser(id);
        //Optional.of(user).map(user->userMapper.userToUserDTO(user));

       return userMapper.userToUserDTO(user);

//        return userRepository.findById(id).map(user -> userMapper.userToUserDTO(user))
//                .orElseThrow(() -> new EntityNotFoundException("User not found!"));

//        if (user.isPresent()) {
//
//
//             return userMapper.userToUserDTO(user.get());
//
//
//        } else {
//            throw new EntityNotFoundException("User not found!");
//
//        }
    }

    public User addUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        userRepository.delete(user);


    }

    private User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserDTO userDTOToUpdate = getUserById(userDTO.getId());
        userDTOToUpdate.setUsername(userDTO.getUsername());
        User updatedUser = userMapper.userDTOToUser(userDTOToUpdate);
        userRepository.save(updatedUser);
        return userDTOToUpdate;

    }


}


