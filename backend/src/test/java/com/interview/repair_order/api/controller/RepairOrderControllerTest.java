package com.interview.repair_order.api.controller;

import com.interview.repair_order.api.model.RepairOrderResponse;
import com.interview.repair_order.service.RepairOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepairOrderControllerTest {

    private static final int PAGE_COUNT = 0;
    private static final int PAGE_SIZE = 20;

    @Mock
    private RepairOrderService repairOrderService;

    @Mock
    private Page<RepairOrderResponse> repairOrderResponses;

    @Captor
    private ArgumentCaptor<Pageable> pageableCaptor;

    @InjectMocks
    private RepairOrderController repairOrderController;

    @Test
    public void getAll() {
        when(repairOrderService.getAllPaginated(any(Pageable.class))).thenReturn(repairOrderResponses);

        Page<RepairOrderResponse> result = repairOrderController.getAll(PAGE_COUNT);

        verify(repairOrderService).getAllPaginated(pageableCaptor.capture());
        assertEquals(repairOrderResponses, result);
        Pageable actualPageable = pageableCaptor.getValue();
        assertEquals(PAGE_COUNT, actualPageable.getOffset());
        assertEquals(PAGE_SIZE, actualPageable.getPageSize());
    }
}
