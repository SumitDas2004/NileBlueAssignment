package com.nileblue.assignment.payrollservice.exception;

public class PayRollDoesNotExistException extends RuntimeException{
    public PayRollDoesNotExistException(){
        super("Payroll does not exist.");
    }
}
