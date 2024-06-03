package com.nileblue.assignment.payrollservice.dto;

import com.nileblue.assignment.payrollservice.entity.PayRoll;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreatePayRollDTO {
    @NotNull(message = "EmployeeId can't be empty.")
    private Long employeeId;

    @NotNull(message = "Gross pay can't be empty.")
    private Long grossPay;

    @NotNull(message = "Deduction can't be empty.")
    private Long deduction;

    @NotNull(message = "Net pay can't be empty.")
    private Long netPay;

    public PayRoll toPayRoll(){
        return PayRoll.builder()
                .employeeId(this.employeeId)
                .grossPay(this.grossPay)
                .deduction(this.deduction)
                .netPay(this.netPay)
                .build();
    }
}
