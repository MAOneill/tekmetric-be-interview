package com.interview.repair_order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

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

    private String status; //change ot enum

    private Instant createdAt;

    private Integer odometerIn;

    private Integer odometerOut;

    private String notes;
}
