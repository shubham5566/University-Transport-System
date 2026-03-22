package com.transport.university.universitytransportsystem.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    @Email(message = "Provide a valid email")
    @NotBlank(message = "Email is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}
