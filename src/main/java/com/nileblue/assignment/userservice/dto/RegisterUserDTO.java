package com.nileblue.assignment.userservice.dto;

import com.nileblue.assignment.userservice.constants.Roles;
import com.nileblue.assignment.userservice.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserDTO {
    @NotBlank(message = "Email can't be blank.")
    String email;
    @NotBlank(message = "Password can't be blank.")
    String password;
    @NotBlank(message = "Name can't be blank.")
    String name;
    @NotNull(message = "Roles can't be blank.")
    Roles roles;

    public User toUser(){
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .roles(List.of(this.roles))
                .build();
    }
}
