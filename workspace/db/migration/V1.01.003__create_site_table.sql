CREATE TABLE site
(
    id          INT PRIMARY KEY,
    location_id INT           NOT NULL,
    name        VARCHAR(256) NOT NULL,
    description VARCHAR(512),
    CONSTRAINT site_location_fk FOREIGN KEY (location_id) REFERENCES location (id)
);