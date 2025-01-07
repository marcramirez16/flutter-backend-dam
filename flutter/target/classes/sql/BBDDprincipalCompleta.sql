DROP DATABASE if exists flutter;
create database flutter;
Use flutter;

CREATE TABLE Users(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL UNIQUE,
  birthday year NOT NULL,
  mail varchar(40) NOT NULL,
  password varchar(13) NOT NULL,
  profilephoto blob(50000),
  biography varchar(255),
  youtube varchar(90),
  twitterx varchar(90),
  facebook varchar(90),
  twitch varchar(90),
  reddit varchar(90),
  steam varchar(90),
  epicgames varchar(90),
  nswitch varchar(90),
  psn varchar(90),
  xbox varchar(90)
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
  friendB int,
  UNIQUE (friendA, friendB)  

);

CREATE TABLE FriendRequests (
  friendrequest int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  userSender int,
  userReciever int,
  UNIQUE (userSender, userReciever)  

);

CREATE TABLE AchievementsFavorites (
    id int AUTO_INCREMENT PRIMARY KEY,
    userId int NOT NULL,
    achievementId int NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(id) ON DELETE CASCADE,
    FOREIGN KEY (achievementId) REFERENCES Achievements(id) ON DELETE CASCADE
);

CREATE TABLE Messages(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	senderid int,
  receiverid int,
  message varchar(1000)
);

#Añadimos usuarios
INSERT INTO Users(username, birthday, mail, password, profilephoto, biography, youtube, twitterx, facebook, twitch, reddit, steam, epicgames, nswitch, psn, xbox) VALUES ('Marc',2000,'marcramirezmoya@gmail.com','1234', NULL, '', 'elrubiusOMG', 'rubiu5', 'ElrubiusOMG-337992166223323', 'Rubius', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO Users(username, birthday, mail, password, profilephoto, biography, youtube, twitterx, facebook, twitch, reddit, steam, epicgames, nswitch, psn, xbox) VALUES ('Roc',2000,'roviraroc@gmail.com','1234', NULL, '', 'elrubiusOMG', 'rubiu5', 'ElrubiusOMG-337992166223323', 'Rubius', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO Users(username, birthday, mail, password, profilephoto, biography, youtube, twitterx, facebook, twitch, reddit, steam, epicgames, nswitch, psn, xbox) VALUES ('Miquel',2000,'perezvelasco.miguel@gmail.com','1234', NULL, '', 'elrubiusOMG', 'rubiu5', 'ElrubiusOMG-337992166223323', 'Rubius', NULL, NULL, NULL, NULL, NULL, NULL);

#Añadir unos cuantos amigos, solicitudes y userachievements a marc
INSERT INTO Friendships (friendA, friendB) VALUES (1, 2);
INSERT INTO Friendships (friendA, friendB) VALUES (3, 1);
INSERT INTO FriendRequests (userSender, userReciever) VALUES (3, 1);

INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (18, 2, 20, 2);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (20, 1, 2, 13);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (10, 3, 19, 12);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (21, 2, 2, 11);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (22, 1, 3, 12);
INSERT INTO Userachievements (achievementid, userid, likes, dislikes) VALUES (23, 3, 12, 10);

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

#Agregar imagenes por defecto iniciales a los 3 usuarios ------
-- agregar foto al marc
UPDATE Users
SET profilephoto = "'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
AABJRU5ErkJggg==
'"
WHERE username = "Marc";

-- agregar la foto al roc
UPDATE Users
SET profilephoto = "'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
AABJRU5ErkJggg==
'"
WHERE username = "Roc";

-- agregar la foto al miquel

UPDATE Users
SET profilephoto = "'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
AABJRU5ErkJggg==
'"
WHERE username = "Miquel";