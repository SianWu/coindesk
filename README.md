# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/html/#build-image)

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