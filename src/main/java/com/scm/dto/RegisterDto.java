package com.scm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be between 2 to 20 characters")
    private String name;
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @Size(min = 2, max = 20, message = "Password must be between 2 to 20 characters")
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;
    private String about;
}
