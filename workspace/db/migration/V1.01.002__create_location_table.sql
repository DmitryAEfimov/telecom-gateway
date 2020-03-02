CREATE TABLE location
(
    id         INT PRIMARY KEY,
    address_id INT,
    longitude  DECIMAL(10, 6) NOT NULL,
    latitude   decimal(10, 6) NOT NULL,
    CONSTRAINT location_address_fk FOREIGN KEY (address_id) REFERENCES address (id)
);