package com.nileblue.assignment.billingservice.exception;

public class BillDoesNotExistException extends RuntimeException{
    public BillDoesNotExistException(){
        super("Bill Does not exist.");
    }
}
