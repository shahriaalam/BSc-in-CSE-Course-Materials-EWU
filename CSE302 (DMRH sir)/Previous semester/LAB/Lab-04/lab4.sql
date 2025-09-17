SELECT Building_name, count(Role) from Buildings join Employees on Building_name = Building group by Building_name;

SELECT DISTINCT Building_name, Capacity From Buildings;

select distinct Building_name, Role from Buildings left join Employees on Building_name = Building;


====================
SELECT name, role, Building from Employees Where Building is null

SELECT Building_name from Buildings left join Employees on Building_name = Building Where Role is null

============================
SELECT Id, Title, Director, Year, Length_minutes, Movie_id, Rating, ((Domestic_sales + International_sales) / 1000000) as 
Sales from Movies join Boxoffice on Id = Movie_id

SELECT Id, Title, Director, Year, Length_minutes, Movie_id, Rating
 * 10 as Rating from Movies join Boxoffice on Id = Movie_id

SELECT Id, Title, Director, Year, Length_minutes, Movie_id from Movies join Boxoffice on Id = Movie_id where (Year%2 = 0)

===================================


select Director, count(id) from Movies join Boxoffice on Id = Movie_id group by Director

select Director, sum(Domestic_sales + International_sales) as Sum_of_international_and_domestic_sale 
from Movies join Boxoffice on Id = Movie_id group by Director


================================
select name, continent, population from world

SELECT name FROM world
WHERE population > 200000000

SELECT name, (gdp/population) FROM world
WHERE population > 200000000

SELECT name, (gdp/population) FROM world
WHERE population > 200000000

SELECT name, (population/1000000) FROM world WHERE continent = 'South America'

SELECT name, population FROM world WHERE name IN ('France', 'Germany', 'Italy')

SELECT name FROM world WHERE name LIKE 'United%'

SELECT name, population, area FROM world
WHERE area > 3000000 OR population > 250000000;

SELECT name, population, area FROM world
WHERE (area > 3000000 and population <= 250000000) or 
(area <= 3000000 and population > 250000000);

SELECT name, (population/1000000), (gdp / 1000000000)FROM world WHERE continent = 'South America'


SELECT name, round(gdp / population, -3)FROM world WHERE gdp >= 1000000000000

SELECT name, capital
  FROM world
 WHERE LEN(name) = LEN(capital)

SELECT name,  capital
FROM world where name <> capital AND LEFT(name,1) = LEFT(capital,1)

SELECT name
   FROM world
WHERE name LIKE '%a%' and
name LIKE '%e%' and
name LIKE '%i%' and
name LIKE '%o%' and
name LIKE '%u%' 
  AND name NOT LIKE '% %'

=============================

SELECT yr, subject, winner
  FROM nobel
 WHERE yr = 1950

SELECT winner
  FROM nobel
 WHERE yr = 1962 
   AND subject = 'literature'

SELECT yr, subject
  FROM nobel
 WHERE winner = 'Albert Einstein'

SELECT winner
  FROM nobel
 WHERE yr >= 2000
and subject = 'peace'

SELECT  yr, subject, winner
  FROM nobel
 WHERE yr between 1980 and 1989 and subject = 'literature'

SELECT * FROM nobel
 WHERE
  winner IN ('Theodore Roosevelt',
                  'Woodrow Wilson',
                  'Jimmy Carter',
                  'Barack Obama')

SELECT winner
  FROM nobel
 WHERE winner like 'John %'

SELECT * FROM nobel
 WHERE
  (yr = 1980 and subject = 'physics') or (yr = 1984 and subject = 'chemistry')

SELECT * FROM nobel
 WHERE
  (yr = 1980 and subject != 'chemistry' and subject != 'medicine')

SELECT * FROM nobel
 WHERE
  (yr < 1910 and subject = 'Medicine') or (yr >= 2004 and subject = 'Literature')

SELECT * FROM nobel
 WHERE winner = 'PETER GRÜNBERG'

SELECT * FROM nobel
 WHERE winner = 'EUGENE O''NEILL'

SELECT winner, yr, subject
  FROM nobel
 WHERE winner like 'Sir %'
order by yr desc, winner

SELECT winner, subject
FROM nobel
WHERE yr=1984
ORDER BY CASE subject
  WHEN 'chemistry' THEN 2
  WHEN 'physics' THEN 3
  ELSE 1 END, subject, winner;

=========================================

SELECT SUM(population) as value
FROM world;

select distinct continent from world

select sum(gdp) from world group by continent having continent = 'Africa'

select count(name) from world where area >= 1000000

select sum(population ) from world where name in ('Estonia', 'Latvia', 'Lithuania')

select continent, count(name) from world group by continent 

select continent, count(name) from world where population >= 10000000 group by continent 

SELECT continent
FROM world
GROUP BY continent
HAVING SUM(population) >= 100000000;

=================================================

SELECT matchid, player FROM goal 
  WHERE teamid LIKE '%GER'

SELECT id,stadium,team1,team2
  FROM game where id = 1012

SELECT player,teamid, stadium, mdate 
  FROM game JOIN goal ON id = 

