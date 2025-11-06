package com.interview.repair_order.service;

import com.interview.repair_order.api.model.RepairOrderResponse;
import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.repository.RepairOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RepairOrderService {

    private RepairOrderRepository repairOrderRepository;

    //make a dto
    public List<RepairOrderResponse> getAll() {
        return repairOrderRepository.findAll().stream().map(RepairOrderResponse::new)
                .collect(Collectors.toList());
        //PAGINATE THIS
    }
}
