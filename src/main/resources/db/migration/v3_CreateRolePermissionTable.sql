create table role (
  id bigserial not null,
  name varchar(50),
  created_date timestamp(6),
  last_modified_date timestamp(6),
  created_by varchar(255),
  last_modified_by varchar(255),
  primary key (id)
);

create table permission (
  id bigserial not null,
  name varchar(50),
  created_date timestamp(6),
  last_modified_date timestamp(6),
  created_by varchar(255),
  last_modified_by varchar(255),
  primary key (id)
);

create table role_permission (
  id bigserial not null,
  role_id bigserial not null,
  permission_id bigserial not null,
  created_date timestamp(6),
  last_modified_date timestamp(6),
  created_by varchar(255),
  last_modified_by varchar(255),
  primary key (id)
);