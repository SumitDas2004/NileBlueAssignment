package com.nileblue.assignment.billingservice.dto;

import com.nileblue.assignment.billingservice.constants.BillStatus;
import com.nileblue.assignment.customerservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetBillDetailsDTO {
    private long id;

    private Date dueDate;

    private BillStatus billStatus;

    private Date createdAt;

    private Date updatedAt;

    private long amount;

    private long dueAmount;

    private String customerName;

    private long curstomerId;

    private String customerEmail;
}
