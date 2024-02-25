drop table if exists accounts;

create table accounts (
    seq bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    password varchar(50) not null,
    age int not null,
    primary key (seq)
);
