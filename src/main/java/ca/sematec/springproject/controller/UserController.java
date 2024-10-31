package ca.sematec.springproject.controller;

import ca.sematec.springproject.api.UserAPI;
import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
public class UserController implements UserAPI {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //*********************************************************************************

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    //*********************************************************************************

    @Override
    public ResponseEntity<UserDTO> getUserById(long userId) {

        UserDTO userDTO = userService.getUserById(userId);

        return ResponseEntity.ok(userDTO);
    }

    //*********************************************************************************


    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);

    }

    //*********************************************************************************

    @Override
    public void updateUser(Long id, UserDTO userDTO) {

    }


}
