-- create database cinema;
create table movies
(
    id       serial primary key,
    title    varchar(255),
    duration int
);
create table showtimes
(
    id         serial primary key,
    movie_id   int,
    start_time timestamp,
    price      decimal(10, 2),
    foreign key (movie_id) references Movies (id)
);
create table tickets
(
    id          serial primary key,
    showtime_id int,
    foreign key (showtime_id) references showtimes (id)
);


insert into movies (title, duration)
values ('film1', 90),
       ('film2', 120),
       ('film3', 60),
       ('film4', 120),
       ('film5', 90);
insert into showtimes (movie_id, start_time, price)
values (1, '2023-04-12 14:00:00', 300.00),
       (3, '2023-04-12 15:00:00', 500.00),
       (2, '2023-04-12 13:00:00', 300.00),
       (2, '2023-04-12 18:00:00', 300.00),
       (5, '2023-04-12 19:00:00', 400.00);
insert into tickets (showtime_id)
values (1),
       (1),
       (2),
       (3),
       (4),
       (3),
       (2),
       (4),
       (1);
