DROP TABLE IF EXISTS user;

create table user (
id BIGINT(20) not null,
name VARCHAR(30) null,
age int(11) null,
email varchar(50) null ,
primary key (id)
);

DELETE FROM user;
INSERT INTO user(id, name, age, email) values
(1, 'Jone', 18, 'test1@ssss.com'),
(2, 'Jack', 20, 'test2@sdsd.com'),
(3, 'Sandy', 22, 'test3@asd.com');