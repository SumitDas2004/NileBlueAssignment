package com.nileblue.assignment.payrollservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPayRollDTO {
    long id;

    long employeeId;

    long grossPay;

    long deduction;

    long netPay;

    Date createdAt;
    Date updatedAt;
}
