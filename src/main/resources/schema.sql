create table todo(
    id bigint not null auto_increment,
    title varchar(255) not null,
    completed varchar(100),
    createdtime timestamp,
    primary key(id)
);