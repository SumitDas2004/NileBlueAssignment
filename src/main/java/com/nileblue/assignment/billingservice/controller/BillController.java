package com.nileblue.assignment.billingservice.controller;

import com.nileblue.assignment.billingservice.dto.CreateBillDTO;
import com.nileblue.assignment.billingservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/bill")
@RestController
public class BillController {
    @Autowired
    BillService billService;

    @PreAuthorize("hasAuthority('SALES')")
    @PostMapping("/create")
    public ResponseEntity<?> createBill(@RequestBody CreateBillDTO request){
        billService.createBill(request);
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Bill creation successful.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SALES') or hasAuthority('ACCOUNTANT')")
    @GetMapping("/{billId}")
    public ResponseEntity<?> getBillDetails(@PathVariable("billId") long billId){
        Map<String, Object> map  = new HashMap<>();
        map.put("status", 1);
        map.put("message", "Success.");
        map.put("data", billService.getBillDetails(billId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
