create table repair_orders (
            id              varchar(36) PRIMARY KEY NOT NULL,
            shop_id         varchar(36) NOT NULL,
            external_RO     varchar(50) NOT NULL,
            status          varchar(32) NOT NULL,
            created_at      TIMESTAMP    NOT NULL,
            odometer_in     INT,
            odometer_out    INT,
            notes           varchar(1000)
            );

create table repair_order_lines (
            id              varchar(36) PRIMARY KEY NOT NULL,
            repair_order_id varchar(36) NOT NULL,
            description     varchar(255) NOT NULL,
            quantity        DECIMAL(10,2) DEFAULT 0,
            unit_price      DECIMAL(10,2) DEFAULT 0,
            CONSTRAINT fk_repair_order FOREIGN KEY (repair_order_id) REFERENCES repair_orders(id)
            );

-- create audit tables?