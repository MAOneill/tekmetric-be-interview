package com.interview.repair_order.domain;

import com.interview.repair_order_line.domain.RepairOrderLine;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "repair_orders")
@Getter
@Setter
@NoArgsConstructor
public class RepairOrder {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id ;

    private String shopId;

    @Column(name = "external_RO")
    private String externalRO;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Instant createdAt;

    private Integer odometerIn;

    private Integer odometerOut;

    private String notes;

    @OneToMany(mappedBy = "repairOrder", fetch = FetchType.EAGER)
    private List<RepairOrderLine> repairOrderLines = new ArrayList<>();

    public BigDecimal getTotalAmount() {
        return this.repairOrderLines.stream()
                .map(RepairOrderLine::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
