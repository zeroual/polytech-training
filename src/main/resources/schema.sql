CREATE TABLE STORY (
  ID      INT IDENTITY,
  CONTENT VARCHAR(144)
);

create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(250) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);


-- create user
INSERT INTO users values('zeros','$2a$10$rFFfK7IX48.M6cY9zH4bkugjlfux0LUBkqXHlwHH13GH9AA4fuvcm',true);
insert into authorities  values ('zeros','ADMIN');