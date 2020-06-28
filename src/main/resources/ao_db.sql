create table user
(
    id         bigint auto_increment
        primary key,
    email      varchar(255) null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    login      varchar(255) null,
    password   varchar(255) null
)
    engine = MyISAM;

INSERT INTO ao_db.user (id, email, first_name, last_name, login, password) VALUES (1, 'admin@admin.pl', 'AdminName', 'AdminSurname', 'admin', '{bcrypt}$2a$10$vZ7r2qOP7q.ExEvR.04oo.PdnYDuNOE8.fQNuQjQMzcRpROM146wS');
INSERT INTO ao_db.user (id, email, first_name, last_name, login, password) VALUES (2, 'user@user.pl', 'UserName', 'UserSurname', 'user', '{bcrypt}$2a$10$wp8WmbD649v3z7wCxPpiQOHxVFRvN1RPC.jFMZSQ9r.3tYjNUVTqK');





create table user_role
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    role        varchar(255) null
)
    engine = MyISAM;

INSERT INTO ao_db.user_role (id, description, role) VALUES (1, 'administrator account', 'ROLE_ADMIN');
INSERT INTO ao_db.user_role (id, description, role) VALUES (2, 'ordinary user account', 'ROLE_USER');





create table user_roles
(
    user_id  bigint not null,
    roles_id bigint not null,
    primary key (user_id, roles_id)
)
    engine = MyISAM;

create index FK5i6gd32hnpr2nyf5edlvl9nhw
    on user_roles (roles_id);

INSERT INTO ao_db.user_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO ao_db.user_roles (user_id, roles_id) VALUES (2, 2);





create table sky_object
(
    id      bigint auto_increment
        primary key,
    date    varchar(255) not null,
    image   varchar(255) not null,
    name    varchar(255) not null,
    id_user bigint       null
)
    engine = MyISAM;

create index FKdj8a9b298cljqjc95sasrsa4j
    on sky_object (id_user);

