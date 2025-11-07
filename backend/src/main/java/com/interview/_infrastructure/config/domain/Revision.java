package com.interview._infrastructure.config.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "revisions")
@Getter
@Setter
@RevisionEntity
public class Revision {

    @Id
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rev_seq")
    @SequenceGenerator(
            name = "rev_seq",
            sequenceName = "revisions_seq",
            allocationSize = 1   // important so Hibernate doesn't cache ahead incorrectly
    )
    private Integer id;

    @RevisionTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp")
    private Date timeStamp;
}
