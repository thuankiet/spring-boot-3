create table customer (
    id bigserial not null,
    age integer,
    created_date timestamp(6),
    email varchar(255),
    firstname varchar(255),
    last_modified_date timestamp(6),
    lastname varchar(255),
    password varchar(255),
    phone varchar(255),
    role varchar(255),
    primary key (id)
)