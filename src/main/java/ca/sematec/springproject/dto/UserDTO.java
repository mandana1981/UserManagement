package ca.sematec.springproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank(message = "username can not be blank")
    @Size(min = 3,max = 16,message = "should not contain numbers")
    private String username;
    @NotNull
    @Size(min = 4,max = 10,message = "should not contain special characters")
    private String password;


}
