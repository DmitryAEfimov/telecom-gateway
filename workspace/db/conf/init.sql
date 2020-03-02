CREATE USER migrate WITH PASSWORD 'migrate';
CREATE DATABASE telecomdb WITH OWNER migrate;

CREATE ROLE ADMIN_ROLE NOINHERIT;
CREATE USER admin WITH PASSWORD 'admin';
GRANT ADMIN_ROLE TO admin;

CREATE ROLE READONLY_ROLE NOINHERIT;
CREATE USER readonly WITH PASSWORD 'readonly';
GRANT READONLY_ROLE TO readonly;

GRANT CONNECT ON DATABASE telecomdb TO ADMIN_ROLE;
GRANT CONNECT ON DATABASE telecomdb TO READONLY_ROLE;

GRANT ALL PRIVILEGES ON DATABASE telecomdb TO ADMIN_ROLE;