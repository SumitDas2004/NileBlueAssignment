package com.nileblue.assignment.payrollservice.controller;

import com.nileblue.assignment.payrollservice.dto.CreatePayRollDTO;
import com.nileblue.assignment.payrollservice.service.PayRollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payroll")
public class PayRollController {
    @Autowired
    PayRollService payRollService;

    @PreAuthorize("hasAuthority('HR')")
    @PostMapping("/create")
    public ResponseEntity<?> createPayRoll(@Valid @RequestBody CreatePayRollDTO request){
        payRollService.createPayRoll(request);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Payroll creation successful.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('HR') or hasAuthority('ACCOUNTANT')")
    @GetMapping("/{payrollId}")
    public ResponseEntity<?> getPayROll(@PathVariable("payrollId") long id){
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Payroll creation successful.");
        map.put("data", payRollService.getPayRollData(id));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
