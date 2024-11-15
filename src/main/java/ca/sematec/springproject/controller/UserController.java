package ca.sematec.springproject.controller;

import ca.sematec.springproject.api.UserAPI;
import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController implements UserAPI {
    @Autowired
    private UserService userService;


    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById( Long id) {

        UserDTO userDTO = userService.getUserById(id);

        return ResponseEntity.ok(userDTO);
    }

    @Override
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }


    @Override
    public void updateUser(Long id,UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser();

    }


}
