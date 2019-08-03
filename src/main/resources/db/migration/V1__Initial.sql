drop table if exists user;
drop table if exists sector;
drop table if exists user_sector;

create table user
(
	username varchar(100) not null,
	password varchar(100) not null,
	name     varchar(100) not null,
	constraint pk_username primary key (username)
);

create table sector
(
	sector_id int,
	name      varchar(100) not null,
	parent_id int,
	constraint pk_sector_id primary key (sector_id),
	foreign key (parent_id) references sector (sector_id),
);

create table user_sector
(
	username  varchar(100) not null,
	sector_id int          not null,
	foreign key (username) references user (username),
	foreign key (sector_id) references sector (sector_id),
	constraint pk_user_sector primary key (username, sector_id)
);
