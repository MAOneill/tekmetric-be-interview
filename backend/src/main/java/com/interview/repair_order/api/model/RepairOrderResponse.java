package com.interview.repair_order.api.model;

import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.domain.Status;

import java.math.BigDecimal;
import java.time.Instant;

public class RepairOrderResponse {

    public String id ;

    public String shopId;

    public String externalRO;

    public Status status;

    public Instant createdAt;

    public Integer odometerIn;

    public Integer odometerOut;

    public String notes;

    public BigDecimal amount;

    public RepairOrderResponse(RepairOrder repairOrder) {
        this.id = repairOrder.getId();
        this.shopId = repairOrder.getShopId();
        this.externalRO = repairOrder.getExternalRO();
        this.status = repairOrder.getStatus();
        this.createdAt = repairOrder.getCreatedAt();
        this.odometerIn = repairOrder.getOdometerIn();
        this.odometerOut = repairOrder.getOdometerOut();
        this.notes = repairOrder.getNotes();
        this.amount = repairOrder.getTotalAmount();
    }
}
