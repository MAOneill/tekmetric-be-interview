package com.interview.repair_order.repository;

import com.interview.repair_order.domain.RepairOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, String> {

//    @Query("Select ro from RepairOrder ro JOIN FETCH ro.repairOrderLines")
//    List<RepairOrder> findAllWithLines();
//
//    @Query(value = "Select ro from RepairOrder ro JOIN FETCH ro.repairOrderLines",
//            countQuery = "select count(ro) from RepairOrder ro")
//    Page<RepairOrder> findAllWithLinesPageable2(Pageable pageable);

    @EntityGraph(attributePaths = "repairOrderLines")
    @Query("Select ro from RepairOrder ro")
    Page<RepairOrder> findAllWithLinesPageable(Pageable pageable);
}
