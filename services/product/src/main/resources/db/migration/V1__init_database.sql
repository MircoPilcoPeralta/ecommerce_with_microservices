create table if not exists category
(
    id integer PRIMARY KEY NOT NULL,
    name varchar(255),
    description varchar(255)
);

create table if not exists product
(
    id integer PRIMARY KEY NOT NULL,
    name varchar(255),
    description varchar(255),
    available_quantity double precision NOT NULL,
    price numeric(38,2),
    category_id integer NOT NULL CONSTRAINT product_category_fk REFERENCES category
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;