create table cinemas (
	id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name text NOT NULL,
	area text NOT NULL,
	location text NOT NULL,
	phone text NOT NULL,
	score float DEFAULT 0,
	movieList text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

insert into cinemas values(
	null,
	'Guangzhou Central Cinema',
	'TianHe',
	'TianHeQu TaiYangCheng',
	'18817425896',
	7.5,
	'7,8'
),
(
	null,
	'Guangzhou Central Cinema',
	'TianHe',
	'TianHeQu TaiYangCheng',
	'18817425896',
	7.5,
	'7'
);