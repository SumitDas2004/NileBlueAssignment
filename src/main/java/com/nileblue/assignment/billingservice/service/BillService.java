package com.nileblue.assignment.billingservice.service;

import com.nileblue.assignment.billingservice.dao.BillDao;
import com.nileblue.assignment.billingservice.dto.CreateBillDTO;
import com.nileblue.assignment.billingservice.dto.GetBillDetailsDTO;
import com.nileblue.assignment.billingservice.entity.Bill;
import com.nileblue.assignment.billingservice.exception.BillDoesNotExistException;
import com.nileblue.assignment.customerservice.dao.CustomerDao;
import com.nileblue.assignment.customerservice.entity.Customer;
import com.nileblue.assignment.customerservice.exception.CustomerDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillDao billDao;

    @Autowired
    CustomerDao customerDao;

    public void createBill(CreateBillDTO request){
        Optional<Customer> optionalCustomer = customerDao.findById(request.getCustomerId());
        if(optionalCustomer.isEmpty())throw new CustomerDoesNotExistException();
        Customer customer = optionalCustomer.get();

        Bill bill = Bill.builder()
                .amount(request.getAmount())
                .billStatus(request.getBillStatus())
                .dueDate(request.getDueDate())
                .dueAmount(request.getDueAmount())
                .customer(customer)
                .build();

        customer.getBills().add(bill);
        customerDao.save(customer);
    }

    public GetBillDetailsDTO getBillDetails(long id){
        Optional<Bill> optionalBill = billDao.findById(id);
        if(optionalBill.isEmpty())throw new BillDoesNotExistException();
        Bill bill = optionalBill.get();

        return GetBillDetailsDTO.builder()
                .amount(bill.getAmount())
                .billStatus(bill.getBillStatus())
                .customerEmail(bill.getCustomer().getEmail())
                .id(bill.getId())
                .createdAt(bill.getCreatedAt())
                .updatedAt(bill.getCreatedAt())
                .curstomerId(bill.getCustomer().getId())
                .customerName(bill.getCustomer().getName())
                .dueDate(bill.getDueDate())
                .dueAmount(bill.getDueAmount())
                .build();
    }
}
