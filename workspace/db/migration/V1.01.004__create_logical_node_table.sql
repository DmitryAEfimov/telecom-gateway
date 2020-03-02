CREATE TABLE logical_node
(
    id      INT PRIMARY KEY,
    site_id INT          NOT NULL,
    name    VARCHAR(256) NOT NULL,
    status  varchar(16)
        CONSTRAINT chk_status CHECK (status in ('planned', 'in_use', 'dismantled')),
    model   VARCHAR(512),
    CONSTRAINT ln_site_fk FOREIGN KEY (site_id) REFERENCES site (id)
);