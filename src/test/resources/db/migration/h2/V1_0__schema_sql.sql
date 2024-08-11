CREATE TABLE customer
(
    id           UUID DEFAULT random_uuid() PRIMARY KEY,
    first_name   VARCHAR(255)        NOT NULL,
    last_name    VARCHAR(255)        NOT NULL,
    email        VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    address      TEXT,
    version      INTEGER
);

create table contract
(
    gross_price double precision not null,
    net_price   double precision not null,
    version     integer,
    customer_id uuid references customer,
    id          uuid not null primary key
);