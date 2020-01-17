--
-- Database: `MovieBase`
--
CREATE DATABASE IF NOT EXISTS `MovieBase` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `MovieBase`;

-- --------------------------------------------------------

--
-- Table structure for table `Actors`
--

CREATE TABLE IF NOT EXISTS `Actors` (
  `ActorId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `Birth` date NOT NULL,
  PRIMARY KEY (`ActorId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Actors`
--

INSERT INTO `Actors` (`ActorId`, `FirstName`, `LastName`, `Nationality`, `Birth`) VALUES
(1, 'Оуэн', 'Уилсон', 'EU', '1988-01-01'),
(2, 'Винс', 'Вон', 'EU', '1989-02-02'),
(3, 'Маколей', 'Калкин', 'EU', '2000-03-03'),
(4, 'Томми', 'Ли Джонс', 'EU', '1980-04-04'),
(5, 'Уилл', 'Смит', 'EU', '1985-05-05');

-- --------------------------------------------------------

--
-- Table structure for table `Directors`
--

CREATE TABLE IF NOT EXISTS `Directors` (
  `DirectorId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `Birth` date NOT NULL,
  PRIMARY KEY (`DirectorId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Directors`
--

INSERT INTO `Directors` (`DirectorId`, `FirstName`, `LastName`, `Nationality`, `Birth`) VALUES
(1, 'Барри', 'Зонненфельд', 'EU', '1985-05-05'),
(2, 'Криc', 'Коламбус', 'EU', '1986-06-06'),
(3, 'Шон', 'Леви', 'EU', '1986-04-06');

-- --------------------------------------------------------

--
-- Table structure for table `Genres`
--

CREATE TABLE IF NOT EXISTS `Genres` (
  `GenreId` int(11) NOT NULL AUTO_INCREMENT,
  `GenreName` varchar(20) NOT NULL,
  PRIMARY KEY (`GenreId`),
  UNIQUE KEY `GenreName` (`GenreName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Genres`
--

INSERT INTO `Genres` (`GenreId`, `GenreName`) VALUES
(3, 'Action'),
(1, 'Comedy'),
(2, 'Family');

-- --------------------------------------------------------

--
-- Table structure for table `MovieActor`
--

CREATE TABLE IF NOT EXISTS `MovieActor` (
  `MovieId` int(11) NOT NULL,
  `ActorId` int(11) NOT NULL,
  KEY `MovieId` (`MovieId`),
  KEY `ActorId` (`ActorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MovieActor`
--

INSERT INTO `MovieActor` (`MovieId`, `ActorId`) VALUES
(1, 4),
(1, 5),
(2, 3),
(3, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `MovieGenres`
--

CREATE TABLE IF NOT EXISTS `MovieGenres` (
  `MovieId` int(11) NOT NULL,
  `GenreId` int(11) NOT NULL,
  KEY `MovieId` (`MovieId`),
  KEY `GenreId` (`GenreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MovieGenres`
--

INSERT INTO `MovieGenres` (`MovieId`, `GenreId`) VALUES
(1, 3),
(2, 1),
(3, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Movies`
--

CREATE TABLE IF NOT EXISTS `Movies` (
  `MovieId` int(11) NOT NULL AUTO_INCREMENT,
  `DirectorId` int(11) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `ReleaseYear` int(11) NOT NULL,
  `Rating` int(11) NOT NULL,
  `Plot` longtext NOT NULL,
  `MovieLength` int(11) NOT NULL,
  PRIMARY KEY (`MovieId`),
  KEY `fk_movies_directors` (`DirectorId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Movies`
--

INSERT INTO `Movies` (`MovieId`, `DirectorId`, `Title`, `ReleaseYear`, `Rating`, `Plot`, `MovieLength`) VALUES
(1, 1, 'Люди в черном', 1997, 7, 'На нашей планете тайно проживают инопланетяне. Для решения вопросов их защиты создано бюро сотрудничества с инопланетянами. У агентов-землян есть современная технология взаимодействия с пришельцами', 160),
(2, 2, 'Один дома', 1990, 9, 'Действия фильма разворачиваются на кануне Рождества. Большая американская семья собирается отправиться в путешествие из Чикаго в Европу. Хаотичные сборы приводят к тому, что родители забыли одного из детей дома. Юное создание по имени Кевин не растерялся и продемонстрировал свою изобретательность', 160),
(3, 3, 'Стажеры', 2013, 8, 'Главных героев, Билла и Ника, увольняют с любимой работы. Они работали продавцами, но ведь на улице цифровой век, теперь можно продавать и на кресле перед монитором компьютера. Но, главные герои не унывают и решают тоже попробовать себя в интернете. Так они совершенно случайно попадают в отборочную группу одной популярной интернет компании', 155);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `MovieActor`
--
ALTER TABLE `MovieActor`
  ADD CONSTRAINT `MovieActor_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `Movies` (`MovieId`),
  ADD CONSTRAINT `MovieActor_ibfk_2` FOREIGN KEY (`ActorId`) REFERENCES `Actors` (`ActorId`);

--
-- Constraints for table `MovieGenres`
--
ALTER TABLE `MovieGenres`
  ADD CONSTRAINT `MovieGenres_ibfk_1` FOREIGN KEY (`MovieId`) REFERENCES `Movies` (`MovieId`),
  ADD CONSTRAINT `MovieGenres_ibfk_2` FOREIGN KEY (`GenreId`) REFERENCES `Genres` (`GenreId`);

--
-- Constraints for table `Movies`
--
ALTER TABLE `Movies`
  ADD CONSTRAINT `fk_movies_directors` FOREIGN KEY (`DirectorId`) REFERENCES `Directors` (`DirectorId`);

