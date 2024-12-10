package ca.sematec.springproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public sealed class UserRequest permits UserResponse {

    @NotNull
    @NotBlank(message = "username can not be blank")
    @Size(min = 4, max = 16, message = "")
    private String username;
    @NotNull
    @Size(min = 4, max = 16, message = "mandna khodet message bezar")
    private String password;

}
