create table message (
   id integer not null,
   sender varchar(255) not null,
   receiver varchar(255) not null,
   value varchar(255) not null,
   type varchar(255) not null,
   primary key(id)
);