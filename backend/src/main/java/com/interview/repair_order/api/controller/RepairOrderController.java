package com.interview.repair_order.api.controller;

import com.interview.repair_order.api.model.RepairOrderRequest;
import com.interview.repair_order.api.model.RepairOrderResponse;
import com.interview.repair_order.service.RepairOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping()
public class RepairOrderController {

    private static final String BASE_V0 = "/api/v0/repair-orders";
    private static final int PAGE_SIZE = 20;

    private RepairOrderService repairOrderService;

    @PostMapping(BASE_V0)
    public ResponseEntity<RepairOrderResponse> create(@Valid @RequestBody RepairOrderRequest request) {

        RepairOrderResponse response = repairOrderService.createRepairOrder(request);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path(BASE_V0 + "/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping(BASE_V0)
    public Page<RepairOrderResponse> getAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        return repairOrderService.getAllPaginated(pageable);

    }
}
