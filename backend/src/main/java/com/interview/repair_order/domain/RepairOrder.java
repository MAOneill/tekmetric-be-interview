package com.interview.repair_order.domain;

import com.interview._infrastructure.config.domain.AuditedFields;
import com.interview.repair_order.api.model.RepairOrderRequest;
import com.interview.repair_order_line.domain.RepairOrderLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
@Audited
public class RepairOrder extends AuditedFields {

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

    @CreatedDate
    @Column(name = "created_date")
    private Instant createdDate;

    private Integer odometerIn;

    private Integer odometerOut;

    private String notes;

    @OneToMany(mappedBy = "repairOrder", fetch = FetchType.LAZY)
    private List<RepairOrderLine> repairOrderLines = new ArrayList<>();

    public BigDecimal getTotalAmount() {
        return this.repairOrderLines.stream()
                .map(RepairOrderLine::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public RepairOrder(RepairOrderRequest request) {
        this.shopId = request.getShopId();
        this.externalRO = request.getExternalRO();
        this.status = request.getStatus();
        this.odometerIn = request.getOdometerIn();
        this.odometerOut = request.getOdometerOut();
        this.notes = request.getNotes();
    }

    //add equals and hash
}
