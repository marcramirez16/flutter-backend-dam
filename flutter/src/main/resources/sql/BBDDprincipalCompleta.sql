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

CREATE TABLE Achievements (
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
categoryid int,
title varchar(60) NOT NULL,
description varchar(128) NOT NULL
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

#Añadimos objetivos

INSERT INTO Achievements (categoryid, title, description) VALUES (1, 'Method man-Blackout!','Escucha este disco! Hip hop Method man');
INSERT INTO Achievements (categoryid, title, description) VALUES (1, 'Nina Simone - I Put A Spell On You!','Escucha este disco! Jazz Blues Nina Simone');
INSERT INTO Achievements (categoryid, title, description) VALUES (1, 'Pink Floyd  - Wish You Where Here','Escucha esta cancion! Rock Pink Floyd');
INSERT INTO Achievements (categoryid, title, description) VALUES (2, 'Fricando de bolets','Concina esta receta! youtube:fricandoboletscocinabien');
INSERT INTO Achievements (categoryid, title, description) VALUES (3, 'The jocker - primera parte','Mira esta pelicula! un drama chulo');
INSERT INTO Achievements (categoryid, title, description) VALUES (3, 'El resplandor - Stanley Kubrick','Mira esta pelicula! un thriller extranyo');
INSERT INTO Achievements (categoryid, title, description) VALUES (4, 'Estudia Algoritmos de regresion lineal','Estudia los algoritmos para empezar con la ciencia de datos');
INSERT INTO Achievements (categoryid, title, description) VALUES (4, 'Estudia las partes de la celula','Estudialas para iniciarte en biologia');
INSERT INTO Achievements (categoryid, title, description) VALUES (5, 'Crimen y castigo','Lee este libro para ver que le pasa a rascarnicov!');
INSERT INTO Achievements (categoryid, title, description) VALUES (5, 'La biblia','Lee la biblia para comunicarte con dios! o para aprender');
INSERT INTO Achievements (categoryid, title, description) VALUES (6, '1000 dominadas','Entrena para poder hacer 1000 dominadas en un solo dia');
INSERT INTO Achievements (categoryid, title, description) VALUES (6, 'Tirar a canasta con la mano correctamente','youtube:tirarbiencanasta');
