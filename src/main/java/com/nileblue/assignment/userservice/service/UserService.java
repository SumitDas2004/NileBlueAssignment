package com.nileblue.assignment.userservice.service;

import com.nileblue.assignment.userservice.exceptions.UserDoesNotExistException;
import com.nileblue.assignment.userservice.constants.Roles;
import com.nileblue.assignment.userservice.dao.UserDao;
import com.nileblue.assignment.userservice.dto.GetUserDTO;
import com.nileblue.assignment.userservice.dto.RegisterUserDTO;
import com.nileblue.assignment.userservice.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder encoder;


    public void register(RegisterUserDTO request){
        //Converting the request to an User object
        User user = request.toUser();
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public GetUserDTO getUser(long id){
        Optional<User> optionalUser = userDao.findById(id);
        if(optionalUser.isEmpty())throw new UserDoesNotExistException();
        User user = optionalUser.get();
        return GetUserDTO.toGetUserDTO(user);
    }

    @PostConstruct
    private void createAdmin(){
        User user = User.builder()
                .email("admin@gmail.com")
                .password(encoder.encode("admin"))
                .name("Administrator")
                .roles(List.of(Roles.ADMIN))
                .build();
        userDao.save(user);
    }
}
