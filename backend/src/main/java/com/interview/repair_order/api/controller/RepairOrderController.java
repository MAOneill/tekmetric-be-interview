package com.interview.repair_order.api.controller;

import com.interview.repair_order.api.model.RepairOrderResponse;
import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.service.RepairOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v0/repair-orders")
public class RepairOrderController {

    private RepairOrderService repairOrderService;

    @GetMapping
    public Page<RepairOrderResponse> getAll(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "20") int size  ) {
        Pageable pageable = PageRequest.of(page, size);

        return repairOrderService.getAllPaginated(pageable);
    }
}
