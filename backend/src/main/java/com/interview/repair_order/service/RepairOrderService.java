package com.interview.repair_order.service;

import com.interview.repair_order.api.model.RepairOrderRequest;
import com.interview.repair_order.api.model.RepairOrderResponse;
import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.repository.RepairOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class RepairOrderService {

    private RepairOrderRepository repairOrderRepository;

//    public List<RepairOrderResponse> getAll() {
//
//        return repairOrderRepository.findAllWithLines().stream().map(RepairOrderResponse::new)
//                .collect(Collectors.toList());
//
//    }

    public Page<RepairOrderResponse> getAllPaginated(Pageable pageable) {

        return repairOrderRepository.findAllWithLinesPageable(pageable).map(RepairOrderResponse::new);
    }

    @Transactional
    public RepairOrderResponse createRepairOrder(RepairOrderRequest request) {

        //if full tables exist - we would validate the shopId exists

        RepairOrder newRepairOrder = new RepairOrder(request);
        newRepairOrder = repairOrderRepository.save(newRepairOrder);

        return new RepairOrderResponse(newRepairOrder);
    }
}
