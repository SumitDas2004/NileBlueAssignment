package com.nileblue.assignment.payrollservice.dao;

import com.nileblue.assignment.payrollservice.entity.PayRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRollDao extends JpaRepository<PayRoll, Long> {
}
