CREATE TABLE `users2` (
  `userID` int primary key auto_increment NOT NULL,
  `login` varchar(20) NOT NULL unique,
  `email` varchar(20) NOT NULL unique,
  `password` varchar(20) NOT NULL
) ;

CREATE TABLE `usersRegister` (
   `userID` int primary key  NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ;


////////////////////////////////////////////////////////////////////////////////////
/*if you insert into user2 table, this procedure checks, that you are adding a new user and returns id*/

drop procedure if exists java2019.sp_add_user;
delimiter $$
create procedure java2019.sp_add_user
(
 IN `u_login` varchar(20),
 IN `u_email` varchar(20),
 IN `u_password` varchar(20),
  OUT `u_id` int
 )
 BEGIN 
 IF NOT EXISTS(SELECT * FROM users2
              WHERE users2.login = u_login OR users2.email = u_email)
 THEN
    INSERT INTO users2(login, email, password) VALUES(u_login, u_email, u_password);
    SET u_id = last_insert_id();
 ELSE
    SET u_id = 0;
 END IF;
 END $$
 delimiter ;

CALL `sp_add_user`('user1','user@.dp','123',@user)

///////////////////////////////////////////////////////////////////////////////////
/*if you insert into user2 table, this trigger adds data to the usersRegister table*/

drop trigger if exists java2019.register_trigger;
delimiter $$
create trigger java2019.register_trigger
   after INSERT ON users2
   FOR EACH ROW
BEGIN
    INSERT INTO usersRegister
    VALUES(NEW.userID, NEW.login, NEW.email, NEW.password, current_timestamp());
END $$
delimiter ;
