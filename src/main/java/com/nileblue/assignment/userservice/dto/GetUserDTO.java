package com.nileblue.assignment.userservice.dto;

import com.nileblue.assignment.userservice.constants.Roles;
import com.nileblue.assignment.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserDTO {
    private long id;
    private String name;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private List<Roles> roles;

    public static GetUserDTO toGetUserDTO(User user){
       return GetUserDTO.builder()
               .id(user.getId())
               .name(user.getName())
               .email(user.getEmail())
               .createdAt(user.getCreatedAt())
               .updatedAt(user.getUpdatedAt())
               .roles(user.getRoles())
               .build();
    }
}
