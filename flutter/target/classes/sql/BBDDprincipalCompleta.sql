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

CREATE TABLE Userachievements (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  achievementid int,
  userid int,
  likes int,
  dislikes int
);

CREATE TABLE Friendships (
  friendship int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  friendA int,
  friendB int
);

CREATE TABLE FriendRequests (
  friendrequest int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  userSender int,
  userReciever int
);



CREATE TABLE Messages(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	senderid int,
  receiverid int,
  message varchar(1000)
);

#Añadimos usuarios

INSERT INTO Users(username, birthday, mail, password, profile_photo, biography) VALUES ('Marc',2000,'marcramirezmoya@gmail.com','1234', NULL, '');
INSERT INTO Users(username, birthday, mail, password, profile_photo, biography) VALUES ('Roc',2000,'roviraroc@gmail.com','1234', NULL, '');
INSERT INTO Users(username, birthday, mail, password, profile_photo, biography) VALUES ('Miquel',2000,'perezvelasco.miguel@gmail.com','1234', NULL, '');

#Añadir unos cuantos amigos, solicitudes y userachievements a marc
INSERT INTO Friendships (friendA, friendB) VALUES (1, 2);

INSERT INTO FriendRequests (userSender, userReciever) VALUES (3, 1);

INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (18, 2, 20, 2);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (20, 1, 2, 13);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (10, 3, 19, 12);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (21, 2, 2, 11);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (22, 1, 3, 12);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (23, 3, 12, 10);


select * from Friendships;
select * from FriendRequests;
select * from Userachievements;

#Añadimos las categorias

INSERT INTO Categories (name, icon) VALUES ('Musica', NULL);
INSERT INTO Categories (name, icon) VALUES ('Gastronomia', NULL);
INSERT INTO Categories (name, icon) VALUES ('Anime', NULL);
INSERT INTO Categories (name, icon) VALUES ('Lectura', NULL);
INSERT INTO Categories (name, icon) VALUES ('Deporte', NULL);
INSERT INTO Categories (name, icon) VALUES ('Cine', NULL);
INSERT INTO Categories (name, icon) VALUES ('Estudio', NULL);

#Añadimos los logros (id 1 = Musica)

INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Introducción a la música','Escucha un proyecto de cualquier artista.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Género','Descubre tu genero preferido escuchando tus primeras canciones');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'España','Escucha un disco o proyecto de algún artista español.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'International','Escucha algún proyecto donde el inglés sea la lengua principal.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Overseas','Escucha música local de un país de sudamérica.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Expanding taste','Escucha al menos 1 proyecto de 10 géneros musicales distintos.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Día a día','Crea tu primera playlist.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Experto en listas',' Crea múltiples playlists dividiéndolas como quieras.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'0 anuncios','Paga tu primera suscripción en cualquier plataforma de música.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Inanunciable','Paga una suscripción en cualquier plataforma de música durante 12 meses.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Underground experience','Prueba a escuchar a cualquier artista con menos de 1M de oyentes mensuales.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Vecino ruidoso','Prueba a escuchar a cualquier artista con menos de 10k de oyentes mensuales.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Experimentando','Prueba a escuchar por primera vez playboy carti.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Gramola','Escucha música a través de una gramola.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Vinilo','Escucha música de un vinilo.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Cassete','Escucha música de un casette.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'CD','Escucha música de un CD.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'USB','Escucha música de un USB.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'iWindows?','Usa iTunes desde un PC Windows.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'En vivo','Ve a un concierto.');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Method man-Blackout!','Escucha este disco! Hip hop Method man');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Nina Simone - I Put A Spell On You!','Escucha este disco! Jazz Blues Nina Simone');
INSERT INTO Achievements (categoryid, title, description) VALUES (1,'Pink Floyd - Wish You Where Here','Escucha esta canción! Rock Pink Floyd');

#Añadimos los logros (id 2 = Gastronomia)

INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Fogonero','Prepara el fuego perfecto de una barbacoa.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Sangre argentina','Prepara un asado argentino.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Donde hubo fuego…','Prepara una buena calsotada.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Simon quema','Quemarse (por accidente) con aceite o con la paella que estas utilizando.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Taco bill','Prepara tacos.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'El burritos','Prepara burritos.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Nigiboss','Prepara niguiris.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Roller','Prepara makis.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Misopa','Prepara una sopa miso.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Valencia en casa','Cocina una paella.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'La toscana','Prepara una pizza casera.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Negado','Cocina un huevo frito que se te ha roto en el proceso.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Círculo perfecto','Cocina un huevo frito.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Cheese','Cocina un plato de 5 quesos o más.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Vegan free','Cocina un plato con 5 tipos de carne.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Sushi lover','Consigue los logros Nigiboss, Roller y Misopa.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Ilmare','Come ostras.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Pollo de pantano',' Comer ancas de rana.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'El más rápido','Come caracoles.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Paladar Exotico','Consigue los logros Ilmare, Pollo de pantano y El más rápido.');
INSERT INTO Achievements (categoryid, title, description) VALUES (2,'Fricandó de bolets','Cocina esta receta! youtube:fricandoboletscocinabien');

#Añadimos los logros (id 3 = Anime)

INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Your April in April','Empieza y termina “Your Lie in April” en abril.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Tragones y Mazmorras','Mira la primera temporada de “Tragones y Mazmorras”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Old but gold','Mira un anime que empezó su emisión antes del 2000.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Escritura peligrosa','Obtén una Death Note y escribe tres nombres en ella.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Rewatch','Termina un anime por segunda vez.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Bleached!','Termina el anime “Bleach”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'lAdies','Termina el anime “Death Note”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Grand line 2.0','Empieza a ver el live action de one piece.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'iS tHiS a JoJoREfERenCE?!?','Termina el anime “Jojos bizarre adventure”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Tunometacabrasalabambiche','Termina el anime “Baki”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Megustaprobalsuboca','Termina el anime “Baki Hanma”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Cowboy Bebop','Termina el anime “Cowboy Bebop”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Bebop 2.0','Termina el live action de “Cowboy Bebop”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Mi-rodilla!','Termina el anime “My Hero Academia”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Sasageyo','Termina el anime “attack on titan”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Conan el no bárbaro','Termina el anime “Detective Conan”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Tu crush antes de Justin Biber','Termina el anime “Inuyasha”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Card Hunter','Termina el anime “Sakura cazadora de cartas”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'Ataque de los pelos nasales!','Termina el anime “Bobobo Bobobobo”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (3,'HxH','Termina el anime “Hunter x Hunter”.');

#Añadimos los logros (id 4 = Ver para creer)

INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Mahoma','Visita tu primera montaña.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Brisa marina','Visita tu primera cumbre o cresta montañosa.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Salmonete','Visita tu primer río o arroyo de montaña.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Calizo','Visita tu primera montaña caliza.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Minero','Visita tu primera gruta o cueva subterránea.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Para fotografiar','Visita tu primer campo de flores de lavanda, girasoles, etc.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Remanso de paz','Visita tu primer lago o embalse de montaña.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Pirotecnia natural','Visita tu primera explosion volcánica.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Río de fuego','Visita una caída de magma.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Escape','Visita tu primer geiser.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Ice age','Visita tu primer glaciar.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Bujero','Visita tu primer cenote.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Spiker','Ver tus primeras formaciones de estalactitas o estalagmitas.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Da Vinci AC','Ver tus primeras pinturas rupestres.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Subacuático','Ver tu primer río a lago subterráneo.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Cristalero','Ver tu primer cristal gigante formado en una cueva.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Subcascada','Ver tu primera cascada subterránea.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Noche iluminada','Ver por primera vez una aurora boreal/luces del norte.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Dinastia Ming','La Gran Muralla (China) Parte de la Gran Muralla China.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Gebalene','Petra (Jordania) La fachada principal de Petra (Jordania).');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Gladiador','Visita el Coliseo de Roma (Italia).');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Andale','Visita Chichen Itza (México).');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Kuzco','Visita Machu Picchu (Perú).');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Tijuca','El Cristo Redentor (Brasil).');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Al ladin','Taj Mahal (India).');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Maravillas','Conigue los logros Gebalene, Tijuca ,“Dinastia Ming”, “Gladiador”.');
INSERT INTO Achievements (categoryid, title, description) VALUES (4,'Maravillas al completo','Conigue los logros “Andale”, “Kuzco”, y “Al ladin”.');

#Añadimos los logros (id 5 = Lectura)

INSERT INTO Achievements (categoryid, title, description) VALUES (5,'Crimen y castigo','Lee este libro para ver que le pasa a Rascarnicov!');
INSERT INTO Achievements (categoryid, title, description) VALUES (5,'La biblia','Lee la biblia para comunicarte con dios! o para aprender');
INSERT INTO Achievements (categoryid, title, description) VALUES (5,'50 Sombras','Lee 50 Sombras de Gray');
INSERT INTO Achievements (categoryid, title, description) VALUES (5,'Licenciado en Hogwards','Lee la saga de Harry Potter 1-7');
INSERT INTO Achievements (categoryid, title, description) VALUES (5,'Será Mío','Lee la saga de El Señor de los Anillos y El Hobbit');
INSERT INTO Achievements (categoryid, title, description) VALUES (5,'Que empiezen los juegos','Lee la saga de Los Juegos del Hambre');

#Añadimos los logros (id 6 = Deporte)

INSERT INTO Achievements (categoryid, title, description) VALUES (6,'1000 dominadas','Entrena para poder hacer 1000 dominadas en un solo dia');
INSERT INTO Achievements (categoryid, title, description) VALUES (6,'Tirar a canasta con la mano correctamente','youtube:tirarbiencanasta');

#Añadimos los logros (id 7 = Cine)

INSERT INTO Achievements (categoryid, title, description) VALUES (7,'The Joker - primera parte','Mira esta pelicula! un drama chulo');
INSERT INTO Achievements (categoryid, title, description) VALUES (7,'El Resplandor - Stanley Kubrick','Mira esta pelicula! un thriller extraño');
INSERT INTO Achievements (categoryid, title, description) VALUES (7,'La guerra de las galaxias','Mira la Star Wars I, II, III, IV, V y VI');
INSERT INTO Achievements (categoryid, title, description) VALUES (7,'Harry youre a wizard','Mira la saga de Harry Potter 1-7');
INSERT INTO Achievements (categoryid, title, description) VALUES (7,'La comunidad del anillo','Mira la saga de El Señor de los Anillos y El Hobbit');
INSERT INTO Achievements (categoryid, title, description) VALUES (7,'Sayonara beibi','Mira la saga de Terminator');
INSERT INTO Achievements (categoryid, title, description) VALUES (7,'Hambre de juegos','Mira la saga de Los Juegos del Hambre');

#Añadimos los logros (id 8 = Estudio)

INSERT INTO Achievements (categoryid, title, description) VALUES (8,'Estudia Algoritmos de regresion lineal','Estudia los algoritmos para empezar con la ciencia de datos');
INSERT INTO Achievements (categoryid, title, description) VALUES (8,'Estudia las partes de la celula','Estudia las células para iniciarte en biologia');
INSERT INTO Achievements (categoryid, title, description) VALUES (8,'1900 y 1400','Aprende el uso del Mínimo Común Múltiplo (MCM) y Máximo Común Divisor (MCD)');
INSERT INTO Achievements (categoryid, title, description) VALUES (8,'Existen 10 tipos de personas...','Aprende a convertir un numero binario a uno decimal y sé del primer tipo de personas');