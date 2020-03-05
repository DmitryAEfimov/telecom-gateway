CREATE TABLE address
(
    id         INT PRIMARY KEY,
    fias_id    UUID,
    region     VARCHAR(256),
    district   VARCHAR(256),
    city       VARCHAR(256),
    settlement VARCHAR(256),
    street     VARCHAR(256),
    house      VARCHAR(256),
    block      VARCHAR(256)
);