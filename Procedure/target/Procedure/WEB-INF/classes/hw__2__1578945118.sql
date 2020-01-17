
В домашнем задании использовать ранее созданную базу данных фильмов.

use MovieBase;

1. Создать процедуру, которая принимает два аргумента - начальную запись 
   и конечную запись и выводит через print все записи в заданном диапазоне
   из таблиц Directors (FirstName, LastName), из таблицы Movies(Title, Rating)
   и из таблицы Actors (FirstName, LastName).


drop procedure if exists MovieBase.sp_print_movies;
delimiter $$
create procedure MovieBase.sp_print_movies(
  firstArg int,
  secondArg int)
  BEGIN
  IF (firstArg IS NOT NULL AND secondArg IS NOT NULL) AND

/*Why REGEXP doesn't work here? But select firstArg REGEXP ('^[0-9]+$') working? */

  firstArg REGEXP ('^[0-9]+$') AND secondArg REGEXP ('^[0-9]+$')AND
  EXISTS(SELECT Movies.Title FROM Movies WHERE Movies.MovieId = firstArg) AND
  EXISTS(SELECT Movies.Title FROM Movies WHERE Movies.MovieId = secondArg) THEN
  SELECT Directors.FirstName, Directors.LastName, Movies.Title, 
  Movies.Rating, Actors.FirstName, Actors.LastName FROM Movies
  JOIN Directors ON Directors.DirectorId=Movies.DirectorId
  JOIN MovieActor ON MovieActor.MovieId=Movies.MovieId
  JOIN Actors ON MovieActor.ActorId=Actors.ActorId
  WHERE Movies.MovieId BETWEEN firstArg AND secondArg;
  END IF;
  END $$
  delimiter ;

CALL `sp_print_movies`(1,3);

2. Создать процедуру, которая принимает два аргумента - текущее имя жанра и
   новое имя жанра и обновляет запись в таблице Genres.

drop procedure if exists MovieBase.sp_update_genre;
delimiter $$
create procedure MovieBase.sp_update_genre(
  oldName varchar(20),
  newName varchar(20))
  BEGIN
  if LENGTH(newName) > 0 AND
  (NOT EXISTS(SELECT * FROM Genres WHERE Genres.GenreName = newName))then
  UPDATE Genres SET Genres.GenreName = newName WHERE Genres.GenreName = oldName;
  END IF;
  END $$
  delimiter ;

CALL `sp_update_genre`('Action','Fantasy');

3. Создать процедуру, которая удаляет всех продюсеров из таблицы Directors, на
   которых нет ни одной ссылки из таблицы Movies.

drop procedure if exists MovieBase.sp_delete_directors;
delimiter $$
create procedure MovieBase.sp_delete_directors()
BEGIN
DELETE Directors FROM Directors LEFT JOIN Movies ON Directors.DirectorId = Movies.DirectorId
WHERE Movies.MovieId IS NULL;
END $$
delimiter ;

CALL `sp_delete_directors`();


