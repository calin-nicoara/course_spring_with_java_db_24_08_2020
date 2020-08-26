CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE product
(
    id    bigint PRIMARY KEY,
    name  varchar(255),
    price numeric(12, 4)
);

--------------------------------
CREATE TABLE category
(
    id     bigint PRIMARY KEY,
    name   varchar(255),
    active boolean
);

CREATE TABLE product_with_category
(
    id          bigint PRIMARY KEY,
    name        varchar(255),
    price       numeric(12, 4),
    category_id bigint,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

------------------------------------------
CREATE TABLE book
(
    id    bigint PRIMARY KEY,
    title varchar(255)
);

CREATE TABLE author
(
    id   bigint PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE book_author
(
--     id   bigint PRIMARY KEY,
    book_id   bigint,
    author_id bigint,
    FOREIGN KEY (book_id) REFERENCES book (id),
    FOREIGN KEY (author_id) REFERENCES author (id)
);
------------------------------------
CREATE TABLE client
(
    id               bigint PRIMARY KEY,
    name             varchar(255),
    credit           numeric(12, 4),
    street_name      varchar(255),
    street_number    varchar(255),
    number_of_orders int,
    created_at       timestamp,
    updated_at       timestamp
);
