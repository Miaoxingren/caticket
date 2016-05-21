create table movies (
	id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name text NOT NULL,
	releaseTime date NOT NULL,
	timeLength int NOT NULL,
	doctors text NOT NULL,
	actors text NOT NULL,
	movieTypes text NOT NULL,
	cinemaList text NOT NULL,
	detail text NOT NULL,
	lowCost float NOT NULL,
	score float NOT NULL
)  ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

insert into movies values (
	null,
	'The Huntsman',
	'2016-04-15',
	90,
	'Doctor Miao',
	'Miaoxingren,Wangxingren,Tiger',
	'action,comedy',
	'7,8',
	'detail',
	37.5,
	7.5
),(
	null,
	'The Huntsman',
	'2016-04-15',
	90,
	'Doctor Miao',
	'Miaoxingren,Wangxingren,Tiger',
	'action,comedy',
	'7',
	'detail',
	37.5,
	5.5
);

	
	
	
	
	
	
	