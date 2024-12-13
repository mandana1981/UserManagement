package ca.sematec.springproject.controller;

import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOSs = userService.getAllUsers();
        return ResponseEntity.ok(userDTOSs);
    }


    public ResponseEntity<UserDTO> getUserById( Long id) {

        UserDTO userDTO = userService.getUserById(id);

        return ResponseEntity.ok(userDTO);
    }


    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDTO) {
        UserDTO userDTOCreated=userService.addUser(userDTO);
        return new ResponseEntity<>(userDTOCreated, HttpStatus.CREATED);
    }



    public void updateUser(Long id,UserDTO userDTO) {
        userService.updateUser(userDTO);
    }


    public void deleteUser(Long id) {
       // userService.deleteUser();

    }


}
