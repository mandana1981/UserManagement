package ca.sematec.springproject.service;

import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.mapper.UserMapper;
import ca.sematec.springproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public List<UserDTO> getAllUsers() {
       return userRepository.findAll().stream().map(userMapper::userToUserDTO).toList();
    }

    public UserDTO getUserById(Long id) {
        User user = getUser(id);


        //Optional.of(user).map(user->userMapper.userToUserDTO(user));

        return userMapper.userToUserDTO(user);

        // return userRepository.findById(id).map(user -> userMapper.userToUserDTO(user))
//                .orElseThrow(() -> new EntityNotFoundException("User not found!"));


        // Optional<User> user=userRepository.findById(id);
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

    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
        return userDTO;
        //if we wanted to do some changes on user and then save it,like while selling a ticket ,add a status
        // to it like pending and send it to the front end:
        //User userCreated = userRepository.save(user);
        //return userMapper.userToUserDTO(userCreated);
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


