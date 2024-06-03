package com.nileblue.assignment.customerservice.controller;

import com.nileblue.assignment.customerservice.dto.CreateCustomerDTO;
import com.nileblue.assignment.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PreAuthorize("hasAuthority('SALES')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CreateCustomerDTO request){
        customerService.createUser(request);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Customer creation successful.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SALES')")
    @GetMapping("/{customerId}")
    public ResponseEntity<?> customerDetails(@PathVariable("customerId") long id){
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Success.");
        map.put("data", customerService.getCustomerDetails(id));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
