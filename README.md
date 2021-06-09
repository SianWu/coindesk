# Getting Started

## Create Database
`create database testdb;`
## Create table
`create table coin_desk
(
code          varchar(255) not null,
chart_name    varchar(255),
currency_name varchar(255),
description   varchar(255),
disclaimer    varchar(255),
rate          varchar(255),
rate_float    float8       not null,
remove        boolean      not null,
symbol        varchar(255),
updated       timestamp,
updatediso    timestamp,
updateduk     timestamp,
primary key (code)
);`
