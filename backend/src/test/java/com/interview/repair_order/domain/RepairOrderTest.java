package com.interview.repair_order.domain;

import com.interview.repair_order_line.domain.RepairOrderLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepairOrderTest {

    @Mock
    private RepairOrderLine repairOrderLine1;
    @Mock
    private RepairOrderLine repairOrderLine2;

    @Test
    void getTotalAmount() {
        RepairOrder repairOrder = new RepairOrder();
        repairOrder.setRepairOrderLines(List.of(repairOrderLine1, repairOrderLine2));
        when(repairOrderLine1.getAmount()).thenReturn(BigDecimal.TEN);
        when(repairOrderLine2.getAmount()).thenReturn(BigDecimal.ONE);

        BigDecimal result = repairOrder.getTotalAmount();

        assertEquals(BigDecimal.valueOf(11), result);
    }
}
