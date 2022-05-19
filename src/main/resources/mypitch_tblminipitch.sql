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

INSERT INTO mypitch.tblminipitch (pid, pitchtype, timeslot, price, status) VALUES ('101', 'Single', '8h-10h Tuesday', 500000.00, 0);
INSERT INTO mypitch.tblminipitch (pid, pitchtype, timeslot, price, status) VALUES ('202', 'Double', '14h-16h Sarturday', 1000000.00, 1);
INSERT INTO mypitch.tblminipitch (pid, pitchtype, timeslot, price, status) VALUES ('203', 'Single', '17h-19h Friday', 500000.00, 0);
INSERT INTO mypitch.tblminipitch (pid, pitchtype, timeslot, price, status) VALUES ('301', 'Double', '15h-17h Wenesday', 1000000.00, 0);
