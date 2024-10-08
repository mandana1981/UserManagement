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

        return userRepository.save(user);
    }

//    public void deleteUser(Long id) {
//        User user = getUserById(id);
//        userRepository.delete(user);
//    }

//    public User updateUser(User user) {
//        User userToUpdate = getUserById(user.getId());
//        userToUpdate.setUsername(user.getUsername());
//        return userRepository.save(userToUpdate);
//
//    }


}


