package com.interview.repair_order_line.domain;

import com.interview.repair_order.domain.RepairOrder;
import com.interview.repair_order.domain.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "repair_order_lines")
@Getter
@Setter
@NoArgsConstructor
public class RepairOrderLine {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id ;

    @ManyToOne(targetEntity = RepairOrder.class)
    @JoinColumn(name = "repair_order_id")
    private RepairOrder repairOrder;

    private String description;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public BigDecimal getAmount() {
        return quantity.multiply(unitPrice);
    }
}
