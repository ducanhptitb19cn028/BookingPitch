create table tblcustomers
(
    id          int auto_increment
        primary key,
    name        varchar(255) not null,
    email       varchar(255) not null,
    phonenumber varchar(255) not null
);

create table tblminipitch
(
    pid       varchar(20)    not null
        primary key,
    pitchtype varchar(50)    not null,
    timeslot  varchar(50)    null,
    price     decimal(40, 2) not null,
    status    tinyint(1)     not null,
    constraint tblMiniPitch_pid_uindex
        unique (pid)
);

create table tblticket
(
    id                  int auto_increment
        primary key,
    customerinfor       varchar(255)   not null,
    pitchinfo           varchar(255)   not null,
    timeslot            varchar(255)   not null,
    startdate           varchar(50)    not null,
    enddate             varchar(50)    not null,
    estimatedtotalprice decimal(10, 2) not null
);

create table tblusers
(
    username varchar(255) not null,
    password varchar(255) not null,
    position varchar(255) not null
);


