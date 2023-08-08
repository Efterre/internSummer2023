create table teams (
    teamname varchar(50),
    country varchar(50),
    coefficientOfCountry int,
    rankInLeague int,
    round int,
    power int
);

insert into teams(teamname, country, coefficientOfCountry, rankInLeague, round, power)
VALUES ('Bayern Munchen','Germany',0,1,0,84),
       ('RB Leipzig','Germany',0,3,0,80),
       ('Eintracht Frankfurt','Germany',0,4,0,75),
       ('Borussia Mönchengladbach','Germany',0,5,0,74),
       ('Borussia Dortmund','Germany',0,2,0,80),
       ('Arsenal','England',0,2,0,78),
       ('Chelsea','England',0,4,0,75),
       ('Liverpool','England',0,6,0,82),
       ('Manchester City','England',0,1,0,84),
       ('Manchester United','England',0,5,0,79),
       ('Tottenham','England',0,3,0,78),
       ('Brighton','England',0,7,0,73),
       ('West Ham','England',0,8,0,73),
       ('Aston Villa','England',0,9,0,70),
       ('Paris Saint Germain','France',0,1,0,82),
       ('Lyon','France',0,2,0,77),
       ('Lille','France',0,6,0,75),
       ('Lens','France',0,3,0,73),
       ('Rennes','France',0,4,0,75),
       ('Marseille','France',0,5,0,76),
       ('Real Madrid','Spain',0,2,0,84),
       ('Barcelona','Spain',0,1,0,84),
       ('Athletico Madrid','Spain',0,3,0,79),
       ('Sevilla','Spain',0,6,0,80),
       ('Real Socie dad','Spain',0,4,0,78)
ON CONFLICT (teamname) do nothing ;

UPDATE teams SET coefficientOfCountry=69552
WHERE country='Germany';

UPDATE teams SET round=5
where country='Germany';

UPDATE teams SET coefficientOfCountry=88928
WHERE country='England';

UPDATE teams SET round=5
where country='England';

UPDATE teams SET coefficientOfCountry=75927
WHERE country='Spain';

UPDATE teams SET round=5
where country='Spain';

UPDATE teams SET coefficientOfCountry=51914
WHERE country='France';

UPDATE teams SET round=5
where country='France';


SELECT count(country) , country from teams
GROUP BY country
ORDER BY count(country) DESC;

SELECT * from teams
ORDER BY coefficientOfCountry desc , rankInLeague;
