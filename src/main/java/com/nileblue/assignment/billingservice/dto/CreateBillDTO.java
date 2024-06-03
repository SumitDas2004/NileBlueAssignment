package com.nileblue.assignment.billingservice.dto;

import com.nileblue.assignment.billingservice.constants.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBillDTO {
    private Date dueDate;

    private BillStatus billStatus;

    private long customerId;

    private long amount;

    private long dueAmount;
}
