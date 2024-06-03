package com.nileblue.assignment.payrollservice.service;

import com.nileblue.assignment.payrollservice.dao.PayRollDao;
import com.nileblue.assignment.payrollservice.dto.CreatePayRollDTO;
import com.nileblue.assignment.payrollservice.dto.GetPayRollDTO;
import com.nileblue.assignment.payrollservice.entity.PayRoll;
import com.nileblue.assignment.payrollservice.exception.PayRollDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayRollService {
    @Autowired
    PayRollDao payRollDao;

    public void createPayRoll(CreatePayRollDTO request){
        PayRoll payRoll = request.toPayRoll();

        payRollDao.save(payRoll);
    }

    public GetPayRollDTO getPayRollData(long id){
        Optional<PayRoll> optionalPayRoll = payRollDao.findById(id);
        if(optionalPayRoll.isEmpty())throw new PayRollDoesNotExistException();
        PayRoll payRoll = optionalPayRoll.get();
        return GetPayRollDTO.builder()
                .grossPay(payRoll.getGrossPay())
                .netPay(payRoll.getNetPay())
                .deduction(payRoll.getDeduction())
                .id(payRoll.getId())
                .employeeId(payRoll.getEmployeeId())
                .createdAt(payRoll.getCreatedAt())
                .updatedAt(payRoll.getUpdatedAt())
                .build();
    }
}
