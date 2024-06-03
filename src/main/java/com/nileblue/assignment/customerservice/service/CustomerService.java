package com.nileblue.assignment.customerservice.service;

import com.nileblue.assignment.billingservice.entity.Bill;
import com.nileblue.assignment.customerservice.dao.CustomerDao;
import com.nileblue.assignment.customerservice.dto.CreateCustomerDTO;
import com.nileblue.assignment.customerservice.dto.GetCustomerDetailsDTO;
import com.nileblue.assignment.customerservice.entity.Customer;
import com.nileblue.assignment.customerservice.exception.CustomerDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public void createUser(CreateCustomerDTO request)
    {
        Customer customer = request.toCustomer();
        customerDao.save(customer);
    }

    public GetCustomerDetailsDTO getCustomerDetails(long id){
        Optional<Customer> optionalCustomer = customerDao.findById(id);
        if(optionalCustomer.isEmpty())throw new CustomerDoesNotExistException();

        Customer customer = optionalCustomer.get();

        return GetCustomerDetailsDTO.builder()
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .name(customer.getName())
                .updatedAt(customer.getUpdatedAt())
                .createdAt(customer.getCreatedAt())
                .id(customer.getId())
                .bills(customer.getBills().stream().map(Bill::getId).collect(Collectors.toList()))
                .build();
    }
}
