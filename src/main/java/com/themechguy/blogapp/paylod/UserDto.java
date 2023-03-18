package com.themechguy.blogapp.paylod;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    @NotEmpty
    @Size(min=3,message="Name should have atleast three character")
    private String name;
    @Email(message = "email should be of format xyz@domain.com")
    private String email;
    @NotEmpty
    @Size(min=6, max = 12, message = "Password should have atleast 6 character and atmost 12 character")
    private String password;
    @Size(max = 200, message="About allows only 200 characters in the field")
    private String about;
    
}
