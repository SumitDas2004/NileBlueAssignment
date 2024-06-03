package com.nileblue.assignment;

import com.nileblue.assignment.billingservice.entity.Bill;
import com.nileblue.assignment.billingservice.exception.BillDoesNotExistException;
import com.nileblue.assignment.customerservice.exception.CustomerDoesNotExistException;
import com.nileblue.assignment.payrollservice.exception.PayRollDoesNotExistException;
import com.nileblue.assignment.userservice.exceptions.UserDoesNotExistException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {






    /*
     * Error handlers
     */

    //Called when methods are called invalid properties. For example when email is blank.
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationException(MethodArgumentNotValidException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", "Some fields are missing.");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityException(DataIntegrityViolationException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", "User already exists.");
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }

    //Called when user is not authorized to access an endpoint
    @org.springframework.web.bind.annotation.ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<?> authorizationDenied(AuthorizationDeniedException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<?> userDoesNotExist(UserDoesNotExistException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerDoesNotExistException.class)
    public ResponseEntity<?> customerDoesNotExistException(CustomerDoesNotExistException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PayRollDoesNotExistException.class)
    public ResponseEntity<?> payRollDoesNotExistException(PayRollDoesNotExistException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BillDoesNotExistException.class)
    public ResponseEntity<?> billDoesNotExistException(BillDoesNotExistException e){
        System.out.println(e);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<?> internalServerError(Exception e){
        e.printStackTrace();
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 0);
        map.put("error", "Something went wrong:(");
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
