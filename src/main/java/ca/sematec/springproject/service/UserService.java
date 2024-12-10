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
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // intermediate , terminal
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDTO).toList();
    }

    public UserDTO getUserById(Long id) {
        User user = getUser(id);
        return userMapper.userToUserDTO(user);
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


