DROP DATABASE if exists flutter;
create database flutter;
Use flutter;

CREATE TABLE Users(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  birthday year NOT NULL,
  mail varchar(40) NOT NULL,
  password varchar(13) NOT NULL,
  profile_photo varchar(255),
  biography varchar(255)
);

CREATE TABLE Categories (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(40) NOT NULL,
  icon varchar(250)
);

#Añadimos usuarios

INSERT INTO Users(username, birthday, mail, password, profile_photo, biography) VALUES ('Marc',2000,'marcramirezmoya@gmail.com','1234', NULL, '');
INSERT INTO Users(username, birthday, mail, password, profile_photo, biography) VALUES ('Roc',2000,'roviraroc@gmail.com','1234', NULL, '');
INSERT INTO Users(username, birthday, mail, password, profile_photo, biography) VALUES ('Miquel',2005,'perezvelasco.miguel@gmail.com','1234', NULL, '');

#Añadimos las categorias

INSERT INTO Categories (name, icon) VALUES ('Musica', NULL);
INSERT INTO Categories (name, icon) VALUES ('Gastronomia', NULL);
INSERT INTO Categories (name, icon) VALUES ('Cine', NULL);
INSERT INTO Categories (name, icon) VALUES ('Estudio', NULL);
INSERT INTO Categories (name, icon) VALUES ('Leer', NULL);
INSERT INTO Categories (name, icon) VALUES ('Deporte', NULL);