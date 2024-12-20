package ca.sematec.springproject.controller;

import ca.sematec.springproject.dto.UserRequest;
import ca.sematec.springproject.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<UserRequest> userDTOSs = userService.getAllUsers();
        return ResponseEntity.ok(userDTOSs);
    }


    public ResponseEntity<UserRequest> getUserById(Long id) {

        UserRequest userDTO = userService.getUserById(id);

        return ResponseEntity.ok(userDTO);
    }


    public ResponseEntity<UserRequest> addUser(@RequestBody @Valid UserRequest userDTO) {
        UserRequest userDTOCreated=userService.addUser(userDTO);
        return new ResponseEntity<>(userDTOCreated, HttpStatus.CREATED);
    }



    public void updateUser(@NotNull Long id,@Valid UserRequest userDTO) {

        userService.updateUser(id,userDTO);
    }


    public void deleteUser(@NotNull Long id) {
        userService.deleteUser(id);

    }


}
