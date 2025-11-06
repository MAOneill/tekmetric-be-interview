package com.interview.repair_order.repository;

import com.interview.repair_order.domain.RepairOrder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, String> {

    //create function that fetches the lines eagerly

    @Query("Select ro from RepairOrder ro JOIN FETCH ro.repairOrderLines")
    List<RepairOrder> findAllWithLines();
}
