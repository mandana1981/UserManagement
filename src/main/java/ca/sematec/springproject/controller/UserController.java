package ca.sematec.springproject.controller;

import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import ca.sematec.springproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "USERS", description = "User Api")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @Operation(summary = "Return List of all users ")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = List.class))})})
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {

        UserDTO userDTO = userService.getUserById(id);

        return ResponseEntity.ok(userDTO);
    }



    @Operation(summary = "Create new User")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "201", description = "Created !",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input")
            , @ApiResponse(responseCode = "409", description = "This user already exists")})
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return  new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);

    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//
//
//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        return ResponseEntity.ok( userService.updateUser(user));
//    }


}
