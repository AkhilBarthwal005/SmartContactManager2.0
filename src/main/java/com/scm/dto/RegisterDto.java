package com.scm.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDto {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String about;
}
