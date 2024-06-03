package com.nileblue.assignment.userservice.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(){
        super("User does not exist.");
    }
}
