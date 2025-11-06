package com.interview.repair_order.api.controller;

import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.service.RepairOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v0/repair-orders")
public class RepairOrderController {

    private RepairOrderService repairOrderService;

    @GetMapping
    //make dto
    public List<RepairOrder> getAll() {
        return repairOrderService.getAll();
    }
}
