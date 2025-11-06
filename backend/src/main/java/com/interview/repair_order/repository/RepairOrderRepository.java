package com.interview.repair_order.repository;

import com.interview.repair_order.domain.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, String> {

    //create function that fetches the lines eagerly
}
