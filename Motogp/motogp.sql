-- DATABASE:

drop database if exists motogp;
create database motogp;
use motogp;

create table geschlecht (
	id serial,
	geschlecht varchar(255) not null,
	
	primary key(id),
	unique(geschlecht)
);

create table land (
	id serial,
	land varchar(255) not null,
	
	primary key(id),
	unique(land)
);

create table rennstrecke (
	id serial,
	name varchar(255),
	laenge INTEGER not null,
	anzKurven INTEGER not null,
	avgTemp decimal(3,1),
	land_id bigint unsigned not null,
	
	primary key(id),
	foreign key(land_id) references land(id) on update cascade on delete cascade	
);

create table status (
    id serial, 
    status varchar(255) not null,

    primary key(id),
    unique(status)
);

create table farbe (
    id serial,
	farbe varchar(255) not null,
	
	primary key(id),
	unique(farbe)
);

create table motorrad (
    id serial,
    marke varchar(255) not null,
	farbe_id bigint unsigned not null,

    primary key(id),
	foreign key(farbe_id) references farbe(id) on update cascade on delete cascade,
    unique(marke)
);

create table sponsor (
    id serial,
    name varchar(255) not null,

    primary key(id)
);

create table kategorie (
    id serial,
    kategorie varchar(255) not null,

    primary key(id)
);

create table termin (
	id serial,
	datum date not null,
	
	primary key(id)
);


create table saison (
	id serial,
	name varchar(255) not null,
	kategorie_id bigint unsigned not null,
	
	primary key(id),
	foreign key(kategorie_id) references kategorie(id) on update cascade on delete cascade	
);

create table rennen (
	id serial,
	rennstrecke_id bigint unsigned not null,
	termin_id bigint unsigned not null,
	saison_id bigint unsigned not null,
	
	primary key(id),
	foreign key(rennstrecke_id) references rennstrecke(id) on update cascade on delete cascade,
	foreign key(termin_id) references termin(id) on update cascade on delete cascade,
	foreign key(saison_id) references saison(id) on update cascade on delete cascade
);

create table rangliste (
	id serial,
	rang INTEGER not null,
	punkte INTEGER not null,
	
	
	primary key(id)
);

create table motorrad_sponsor (
    id serial,
    motorrad_id bigint unsigned not null,
    sponsor_id bigint unsigned not null,

    primary key(id),
    foreign key(motorrad_id) references motorrad(id) on update cascade on delete cascade,
    foreign key(sponsor_id) references sponsor(id) on update cascade on delete cascade
);

create table rennfahrer (
    id serial,
    name varchar(255) not null,
    vorname varchar(255) not null,
    koerpergroesse INTEGER not null,
    gewicht INTEGER not null,
    geburtsdatum date not null,
    geschlecht_id bigint unsigned not null,
    status_id bigint unsigned not null,
	land_id bigint unsigned not null,
	motorrad_id bigint unsigned not null,

    primary key(id),
    foreign key(geschlecht_id) references geschlecht(id) on update cascade on delete cascade,
    foreign key(status_id) references status(id) on update cascade on delete cascade,
	foreign key(land_id) references land(id) on update cascade on delete cascade,
	foreign key(motorrad_id) references motorrad(id) on update cascade on delete cascade
);

create table rennfahrer_rangliste (
	id serial,
	rennfahrer_id bigint unsigned not null,
	rangliste_id bigint unsigned not null,
	rennen_id bigint unsigned not null,
	
	primary key(id),
	foreign key(rennfahrer_id) references rennfahrer(id) on update cascade on delete cascade,
	foreign key(rangliste_id) references rangliste(id) on update cascade on delete cascade,
	foreign key(rennen_id) references rennen(id) on update cascade on delete cascade
);


-- INSERTS:

insert into geschlecht (geschlecht) values ('Maenlich'),
('Weiblich');

insert into land (land) values ('Australien'),
('Katar'),
('Portugal'),
('Italien'),
('Brasilien'),
('Argentinien'),
('Frankreich'),
('Spanien'),
('Sued-Afrika'),
('Iran'),
('Tuerkei'),
('Schweden'),
('Deutschland'),
('Neuseeland'),
('Schweiz');

insert into rennstrecke (name, land_id, laenge, avgTemp, anzKurven) values ('Doha','2','5380','38.6','14'),
('Autodromo do Estril','3','4182','21.9','12'),
('Autodromo Internazionale Enzo e Dino Ferrari','4','4909','18.0','8'),
('Autodromo Internacional Ayrton Senna','5','3800','24.5','13'),
('Autodromo Juan y Oscar Ga	lvez','6','4250','22.5','19');

insert into status(status) values
 (';Aktiv')
,('Inaktiv')
,('Verletz oder Disqualifiziert');

insert into farbe(farbe) values
 ('Blau'),
 ('Gelb'),
 ('Rot'),
 ('Gruen'),
 ('Schwarz');


insert into motorrad(marke,farbe_id) values
 ('Ducati',1)
,('Suzuki',2)
,('Petronas SRT',4)
,('Pramac',5)
,('Yamaha',3)
,('KTM',2)
,('Aprilia',5)
,('Tech3',1)
,('Honda',5)
,('Repsol',2);

insert into sponsor(Name) values
 ('Lenovo')
,('Monster Energy')
,('flymeto')
,('Lamborghini')
,('Monster Energy')
,('Red Bull')
,('sky');

insert into kategorie(kategorie) values
 ('MotoGP')
,('Moto2')
,('Moto3')
,('MotoE');


insert into termin(Datum) values
 ('22.04.15')
,('22.09.15')
,('22.10.15')
,('22.11.15')
,('22.12.15')
,('22.04.16')
,('22.09.16')
,('22.10.16')
,('22.11.16')
,('22.12.16')
,('22.04.17')
,('22.09.17')
,('22.10.17')
,('22.11.17')
,('22.12.17')
,('22.04.18')
,('22.09.18')
,('22.10.18')
,('22.11.18')
,('22.12.18')
,('22.04.19')
,('22.09.19')
,('22.10.19')
,('22.11.19')
,('22.12.19')
,('22.04.20')
,('22.09.20')
,('22.10.20')
,('22.11.20')
,('22.12.20')
,('22.04.21')
,('22.09.21')
,('22.10.21')
,('22.11.21')
,('22.12.21');

insert into saison(name,kategorie_id) values
 ('Saison 21/22',1)
,('Saison 20/21',1)
,('Saison 19/20',1)
,('Saison 18/19',1)
,('Saison 17/18',1)
,('Saison 16/17',1)
,('Saison 15/16',1);


insert into rennen(rennstrecke_ID,termin_ID,saison_ID) values
 (1,1,1)
,(2,2,1)
,(3,3,1)
,(4,4,1)
,(5,5,1)

,(1,6,2)
,(2,7,2)
,(3,8,2)
,(4,9,2)
,(5,10,3)

,(1,11,3)
,(2,12,3)
,(3,13,3)
,(4,14,3)
,(5,15,4)

,(1,16,4)
,(2,17,4)
,(3,18,4)
,(4,19,4)
,(5,20,5)

,(1,21,5)
,(2,22,5)
,(3,23,5)
,(4,24,5)
,(5,25,5)

,(1,21,6)
,(2,22,6)
,(3,23,6)
,(4,24,6)
,(5,25,6)

,(1,21,7)
,(2,22,7)
,(3,23,7)
,(4,24,7)
,(5,25,7);

insert into rangliste(rang,punkte) values
 (1,10)
,(2,8)
,(3,7)
,(4,6)
,(5,5)
,(6,5)
,(7,4)
,(8,3)
,(9,2)
,(10,2);

insert into motorrad_sponsor(motorrad_id,sponsor_id) values
 (1,1)
,(2,2)
,(3,3)
,(4,3)
,(5,2)
,(6,5)
,(7,4)
,(8,6)
,(9,7)
,(10,4);

insert into rennfahrer(vorname,name,geburtsdatum,gewicht,koerpergroesse,motorrad_id,land_id,geschlecht_id,status_id) values
 ('Jack','Miller','1995.01.18','70',175,1,1,1,1)
,('Johann','Zarco','1990.07.30','65',171,4,7,1,1)
,('Joan','Mir','1997.07.01','68',181,2,8,1,2)
,('Alex','Rins','1995.12.25','65',176,2,8,1,1)
,('Valentino','Rossi','1979.02.26','69',181,3,4,1,1)
,('Maverick','Vinales','1995.01.12','64',171,5,8,1,1)
,('Brad','Binder','1995.08.11','57',170,6,9,1,1)
,('Miguel','Oliviera','1995.01.04','63',170,6,3,1,2)
,('Aleix','Espargaro','1989.07.30','71',180,7,8,1,1)
,('Lorenzo','Savadori','1993.04.04','67',177,7,4,1,1)
,('Mario','Ballack','2000.02.22','66',172,3,7,1,1)
,('Stefan','Doerflinger','1965.05.19','69',175,9,15,1,2)
,('Eros','Ramazotti','1981.10.21','59',176,2,3,1,2)
,('Timo','Werner','1995.02.19','58',176,1,9,1,1)
,('Julian','Silverstein','1995.01.18','60',181,7,8,1,3)
,('Abdul','Guillet','1990.04.11','61',171,3,14,1,1)
,('Joe','Bamford','1997.07.01','57',170,5,10,1,2)
,('Ben','Dover','1995.10.03','63',170,2,3,1,1)
,('Mike','Oxlong','1979.02.16','71',180,10,1,1,3)
,('Virgil','Mendy','1995.03.21','73',177,9,12,1,1);


insert into rennfahrer_rangliste(rennfahrer_ID,rangliste_ID,rennen_ID) values
(9, 10, 1),(7, 1, 1),(8, 2, 1),(3, 3, 1),(11, 4, 1),(5, 5, 1),(10, 6, 1),(4, 7, 1),(2, 8, 1),(14, 9, 1)
,(11, 10, 2),(7, 1, 2),(8, 2, 2),(9, 3, 2),(14, 4, 2),(12, 5, 2),(10, 6, 2),(5, 7, 2),(3, 8, 2),(13, 9, 2)
,(12, 10, 3),(9, 1, 3),(1, 2, 3),(6, 3, 3),(15, 4, 3),(11, 5, 3),(14, 6, 3),(5, 7, 3),(10, 8, 3),(7, 9, 3)
,(6, 10, 4),(12, 1, 4),(13, 2, 4),(3, 3, 4),(8, 4, 4),(5, 5, 4),(10, 6, 4),(11, 7, 4),(15, 8, 4),(7, 9, 4)
,(7, 10, 5),(2, 1, 5),(13, 2, 5),(4, 3, 5),(3, 4, 5),(11, 5, 5),(15, 6, 5),(14, 7, 5),(9, 8, 5),(6, 9, 5)
,(13, 10, 6),(14, 1, 6),(6, 2, 6),(8, 3, 6),(5, 4, 6),(2, 5, 6),(15, 6, 6),(4, 7, 6),(3, 8, 6),(1, 9, 6)
,(7, 10, 7),(10, 1, 7),(2, 2, 7),(1, 3, 7),(3, 4, 7),(15, 5, 7),(6, 6, 7),(8, 7, 7),(5, 8, 7),(13, 9, 7)
,(15, 10, 8),(12, 1, 8),(13, 2, 8),(10, 3, 8),(1, 4, 8),(9, 5, 8),(11, 6, 8),(5, 7, 8),(3, 8, 8),(8, 9, 8)

,(1, 10, 9),(7, 1, 9),(2, 2, 9),(3, 3, 9),(11, 4, 9),(5, 5, 9),(10, 6, 9),(4, 7, 9),(19, 8, 9),(14, 9, 9)
,(11, 10, 10),(7, 1, 10),(8, 2, 10),(9, 3, 10),(7, 4, 10),(12, 5, 10),(10, 6, 10),(5, 7, 10),(3, 8, 10),(13, 9, 10)
,(12, 10, 11),(9, 1, 11),(1, 2, 11),(6, 3, 11),(15, 4, 11),(11, 5, 11),(14, 6, 11),(5, 7, 11),(10, 8, 11),(7, 9, 11)
,(6, 10, 12),(12, 1, 12),(13, 2, 12),(3, 3, 12),(8, 4, 12),(5, 5, 12),(10, 6, 12),(11, 7, 12),(15, 8, 12),(7, 9, 12)
,(7, 10, 13),(2, 1, 13),(13, 2, 13),(4, 3, 13),(3, 4, 13),(11, 5, 13),(15, 6, 13),(14, 7, 13),(9, 8, 13),(6, 9, 13)
,(13, 10, 14),(14, 1, 14),(6, 2, 14),(8, 3, 14),(5, 4, 14),(2, 5, 14),(15, 6, 14),(4, 7, 14),(3, 8, 14),(1, 9, 14)
,(7, 10, 15),(10, 1, 15),(2, 2, 15),(1, 3, 15),(3, 4, 15),(15, 5, 15),(6, 6, 15),(8, 7, 15),(5, 8, 15),(13, 9, 15)
,(15, 10, 16),(12, 1, 16),(13, 2, 16),(10, 3, 16),(1, 4, 16),(9, 5, 16),(11, 6, 16),(5, 7, 16),(3, 8, 16),(8, 9, 16)

,(1, 10, 17),(7, 1, 17),(8, 2, 17),(3, 3, 17),(11, 4, 17),(5, 5, 17),(10, 6, 17),(4, 7, 17),(2, 8, 17),(14, 9, 17)
,(11, 10, 18),(7, 1, 18),(8, 2, 18),(9, 3, 18),(14, 4, 18),(12, 5, 18),(10, 6, 18),(5, 7, 18),(3, 8, 18),(13, 9, 18)
,(8, 10, 19),(9, 1, 19),(1, 2, 19),(6, 3, 19),(15, 4, 19),(11, 5, 19),(14, 6, 19),(5, 7, 19),(10, 8, 19),(7, 9, 19)
,(2, 10, 20),(12, 1, 20),(13, 2, 20),(3, 3, 20),(8, 4, 20),(5, 5, 20),(10, 6, 20),(11, 7, 20),(15, 8, 20),(7, 9, 20)
,(7, 10, 21),(2, 1, 21),(13, 2, 21),(4, 3, 21),(3, 4, 21),(11, 5, 21),(15, 6, 21),(14, 7, 21),(9, 8, 21),(6, 9, 21)
,(11, 10, 22),(14, 1, 22),(6, 2, 22),(8, 3, 22),(5, 4, 22),(2, 5, 22),(15, 6, 22),(4, 7, 22),(3, 8, 22),(1, 9, 22)
,(7, 10, 23),(10, 1, 23),(2, 2, 23),(1, 3, 23),(3, 4, 23),(15, 5, 23),(6, 6, 23),(8, 7, 23),(5, 8, 23),(13, 9, 23)
,(2, 10, 24),(12, 1, 24),(6, 2, 24),(10, 3, 24),(1, 4, 24),(9, 5, 24),(11, 6, 24),(5, 7, 24),(3, 8, 24),(8, 9, 24)

,(9, 10, 25),(7, 1, 25),(8, 2, 25),(3, 3, 25),(11, 4, 25),(5, 5, 25),(10, 6, 25),(4, 7, 25),(2, 8, 25),(14, 9, 25)
,(11, 10, 26),(7, 1, 26),(8, 2, 26),(9, 3, 26),(14, 4, 26),(12, 5, 26),(10, 6, 26),(5, 7, 26),(3, 8, 26),(13, 9, 26)
,(8, 10, 27),(9, 1, 27),(1, 2, 27),(6, 3, 27),(15, 4, 27),(11, 5, 27),(14, 6, 27),(5, 7, 27),(10, 8, 27),(7, 9, 27)
,(6, 10, 28),(12, 1, 28),(13, 2, 28),(3, 3, 28),(8, 4, 28),(5, 5, 28),(10, 6, 28),(11, 7, 28),(15, 8, 28),(7, 9, 28)
,(7, 10, 29),(2, 1, 29),(13, 2, 29),(4, 3, 29),(3, 4, 29),(11, 5, 29),(15, 6, 29),(14, 7, 29),(9, 8, 29),(6, 9, 29)
,(3, 10, 30),(14, 1, 30),(6, 2, 30),(8, 3, 30),(5, 4, 30),(2, 5, 30),(15, 6, 30),(4, 7, 30),(3, 8, 30),(1, 9, 30)
,(7, 10, 31),(10, 1, 31),(2, 2, 31),(1, 3, 31),(3, 4, 31),(15, 5, 31),(6, 6, 31),(8, 7, 31),(5, 8, 31),(13, 9, 31)
,(15, 10, 32),(12, 1, 32),(13, 2, 32),(10, 3, 32),(1, 4, 32),(9, 5, 32),(11, 6, 32),(5, 7, 32),(3, 8, 32),(8, 9, 32)

,(9, 10, 33),(7, 1, 33),(8, 2, 33),(3, 3, 33),(11, 4, 33),(5, 5, 33),(10, 6, 33),(4, 7, 33),(2, 8, 33),(14, 9, 33)
,(11, 10, 34),(7, 1, 34),(8, 2, 34),(9, 3, 34),(14, 4, 34),(12, 5, 34),(10, 6, 34),(5, 7, 34),(3, 8, 34),(13, 9, 34)
,(8, 10, 35),(9, 1, 35),(1, 2, 35),(6, 3, 35),(15, 4, 35),(11, 5, 35),(14, 6, 35),(5, 7, 35),(10, 8, 35),(7, 9, 35);



-- ABFRAGEN:

-- 1.
select 
    saison.name as Saison, 
	rennen.id as Rennen, 
	datum, rang as Rang, 
	rennfahrer.name as Name, 
	rennfahrer.vorname as Vorname
from 
    rennfahrer_rangliste 
        join rennen on rennen_id = rennen.id
        join termin on termin_id = termin.id
        join saison on saison_id = saison.id 
        join rangliste on rangliste_id = rangliste.id
        join rennfahrer on rennfahrer_id = rennfahrer.id
where 
    saison_id = 1 and rang in (1, 2, 3)
order by 
    datum asc, rang asc
;

-- 2.

select 
    saison.name,  
	sponsor.name as Team,
    avg(rangliste.punkte) as AVG_Punkte_Saison
from 
    rennfahrer
        inner join motorrad on rennfahrer.motorrad_id = motorrad.id
        inner join motorrad_sponsor on motorrad.id = motorrad_sponsor.id
        inner join sponsor on motorrad_sponsor.sponsor_id = sponsor.id
        inner join rennfahrer_rangliste on rennfahrer.id = rennfahrer_rangliste.rennfahrer_id
        inner join rangliste on rangliste_id = rangliste.id
        inner join rennen on rennen_id = rennen.id
        inner join saison on saison_id = saison.id

where 
    saison_id in (1,2,3,4,5)
group by 
    saison.name, sponsor.name
order by 
    saison.id asc, AVG_Punkte_Saison desc
;



-- 3.
select 
    name as Name,
	vorname as Vorname, 
	cast(datediff(datum, geburtsdatum) / 365.2425 as decimal(10, 0)) as Alter_beim_ersten_Podestplatz 
from 
    rennfahrer
       inner join rennfahrer_rangliste on rennfahrer.id = rennfahrer_rangliste.rennfahrer_id
       inner join rennen on rennfahrer_rangliste.rennen_id = rennen.id
       inner join termin on rennen.termin_id = termin.id
where 
    rangliste_id IN (1, 2, 3) 
group by 
    name 
order by 
    datum asc
;

-- 4.
select 
    sponsor.name as Sponsor,
	count(distinct rennfahrer.name) as Anzahl_Rennfahrer,
	count(rang) as Anzahl_Podestplaetze
from 
    rennfahrer
        inner join motorrad on rennfahrer.motorrad_id = motorrad.id
        inner join motorrad_sponsor on motorrad.id = motorrad_sponsor.id
        inner join sponsor on motorrad_sponsor.sponsor_id = sponsor.id
        inner join rennfahrer_rangliste on rennfahrer.id = rennfahrer_rangliste.rennfahrer_id
		inner join rangliste on rangliste_id = rangliste.id
where 
    rangliste_id in (1, 2, 3) 
group by 
    sponsor.name
;









