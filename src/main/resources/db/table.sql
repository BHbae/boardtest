create table todolist_tb(
	id int auto_increment primary key,
    title varchar(20) not null,
    content varchar(20) not null,
    username varchar(20) not null,
    password integer not null
);