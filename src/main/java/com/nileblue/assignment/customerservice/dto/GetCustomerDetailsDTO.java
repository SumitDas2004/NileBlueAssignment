package com.nileblue.assignment.customerservice.dto;


import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCustomerDetailsDTO {
    private long id;

    private String name;

    private String email;

    private String phone;

    private Date createdAt;

    private Date updatedAt;

    private List<Long> bills;
}
