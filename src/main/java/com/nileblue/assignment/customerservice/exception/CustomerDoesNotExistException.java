package com.nileblue.assignment.customerservice.exception;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(){
        super("Customer does not exist.");
    }
}
