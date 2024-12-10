package ca.sematec.springproject.controller;

import ca.sematec.springproject.api.UserAPI;
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
public class UserController implements UserAPI {

    private final UserService userService;

    // todo change it to UserResponse
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<UserRequest> userDTOS = userService.getAllUsers();
        return ResponseEntity.ok(userDTOS);
    }

    @Override
    public ResponseEntity<UserRequest> getUserById(Long id) {

        UserRequest userDTO = userService.getUserById(id);

        return ResponseEntity.ok(userDTO);
    }

    // todo user validate or valid , tell me mandana
    @Override
    public ResponseEntity<UserRequest> addUser(@RequestBody @Valid UserRequest userDTO) {
        UserRequest userDtoCreated = userService.addUser(userDTO);
        return new ResponseEntity<>(userDtoCreated, HttpStatus.CREATED);
    }


    @Override
    public void updateUser(@NotNull Long id, @Valid UserRequest userDTO) {
        userService.updateUser(id, userDTO);
    }

    @Override
    public void deleteUser(@NotNull Long id) {
        userService.deleteUser(id);
    }
}
