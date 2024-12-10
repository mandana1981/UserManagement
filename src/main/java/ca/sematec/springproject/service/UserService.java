package ca.sematec.springproject.service;

import ca.sematec.springproject.dto.UserRequest;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.mapper.UserMapper;
import ca.sematec.springproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // intermediate , terminal
    public List<UserRequest> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDTO).toList();
    }

    public UserRequest getUserById(Long id) {
        User user = getUser(id);
        return userMapper.userToUserDTO(user);
    }

    public UserRequest addUser(UserRequest userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
        return userDTO;
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        userRepository.delete(user);
    }


    public void updateUser(Long id, UserRequest userDTO) {
        User user = getUser(id);
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }
}


