package com.nileblue.assignment.billingservice.dao;

import com.nileblue.assignment.billingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDao extends JpaRepository<Bill, Long> {
}
