create table users (
	id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name text NOT NULL,
	password text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

insert into users values (
	null,
	'win7',
	'12345678'
), (
	null,
	'win9',
	'12345678'
);