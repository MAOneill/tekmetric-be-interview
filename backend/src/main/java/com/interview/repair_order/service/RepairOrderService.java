package com.interview.repair_order.service;

import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.repository.RepairOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RepairOrderService {

    private RepairOrderRepository repairOrderRepository;

    //make a dto
    public List<RepairOrder> getAll() {
        return repairOrderRepository.findAll();
    }
}
