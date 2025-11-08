package com.interview.repair_order.api.model;

import com.interview.repair_order.domain.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RepairOrderRequest {

    @NotNull
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
            message = "must be a valid UUID")
    public String shopId;

    @NotNull
    @Size(max = 50, message = "must be less than 50 characters")
    public String externalRO;

    @NotNull
    public Status status;

    public Integer odometerIn;

    public Integer odometerOut;

    public String notes;
}
