package com.nileblue.assignment.customerservice.dao;

import com.nileblue.assignment.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
