package ca.sematec.springproject.api;

import ca.sematec.springproject.dto.UserDTO;
import ca.sematec.springproject.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "USERS", description = "User Api")
@RequestMapping("/users")
public interface UserAPI {
    @Operation(summary = "Get all users!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content =
                    {@Content(mediaType = "application/json", array = @ArraySchema(
                            schema = @Schema(implementation = User.class)))}),
    })
    @GetMapping()
    ResponseEntity<List<User>> getAllUsers();

    //////////

    @Operation(summary = "Find user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content
                    (mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@Validated @PathVariable("id") Long id);

    //////////
@Operation(summary = "create new User")
@ApiResponses(value = {
        @ApiResponse(responseCode = "201",description = "Created",
        content = {@Content(mediaType = "application/json",
        schema = @Schema(implementation = User.class))}),
        @ApiResponse(responseCode = "400",description = "Invalid input"),
        @ApiResponse(responseCode = "409",description = "This user already exists")})

    @PostMapping
    ResponseEntity<User> addUser(@Validated @RequestBody User user);

    //////////
    @Operation(summary = "Update a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "OK",
            content = @Content),
            @ApiResponse(responseCode = "404",description = "Not found",content = @Content)})
    @PostMapping("/{id}")
    void updateUser(@PathVariable("id") Long id, @Validated @RequestBody UserDTO userDTO);

    //////////



}
