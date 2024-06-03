package com.nileblue.assignment.userservice.controller;

import com.nileblue.assignment.userservice.dto.GetUserDTO;
import com.nileblue.assignment.userservice.dto.RegisterUserDTO;
import com.nileblue.assignment.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDTO request){
        userService.register(request);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Created user successfully.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getUserDetails(@PathVariable("userid") long id){
        GetUserDTO userDTO = userService.getUser(id);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Success");
        map.put("data", userDTO);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
