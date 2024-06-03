package com.nileblue.assignment.customerservice.dto;


import com.nileblue.assignment.customerservice.entity.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCustomerDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;

    public Customer toCustomer(){
        return Customer.builder()
                .name(this.name)
                .email(this.email)
                .phone(this.phone)
                .build();
    }

}
