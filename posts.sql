create table posts
(
    id       int auto_increment
        primary key,
    title    varchar(255) not null,
    content  text         null,
    password varchar(255) not null
);