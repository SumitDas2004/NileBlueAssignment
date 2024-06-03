package com.nileblue.assignment.billingservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nileblue.assignment.billingservice.constants.BillStatus;
import com.nileblue.assignment.customerservice.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="customer")
    @JsonIgnore
    private Customer customer;

    private long amount;

    private long dueAmount;
}
