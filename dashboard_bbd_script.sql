DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS enum_state;
DROP TABLE IF EXISTS enum_promotion;


CREATE TABLE enum_state(
                           id_state INTEGER PRIMARY KEY,
                           state VARCHAR(20)
);

CREATE TABLE enum_promotion(
                          id_promotion INTEGER PRIMARY KEY,
                          promotion VARCHAR(20)
);

CREATE TABLE student(
                        id_student INTEGER PRIMARY KEY AUTOINCREMENT,
                        login VARCHAR(20),
                        lastname VARCHAR(20),
                        firstname VARCHAR(20),
                        _password VARCHAR(20),
                        promotion INTEGER,
                        englishGroup INTEGER,
                        state INTEGER,
                        _comment VARCHAR(100),
                        FOREIGN KEY(state) REFERENCES enum_state(id_state),
                        FOREIGN KEY(promotion) REFERENCES enum_promotion(id_promotion)
);

INSERT INTO enum_state VALUES(1, 'présent');
INSERT INTO enum_state VALUES(2, 'positif-ve');
INSERT INTO enum_state VALUES(3, 'positif-ve');
INSERT INTO enum_state VALUES(4, 'cas contact');
INSERT INTO enum_state VALUES(5, 'cas contact');
INSERT INTO enum_state VALUES(6, 'prévention');
INSERT INTO enum_state VALUES(7, 'prévention');
INSERT INTO enum_state VALUES(8, 'malade');
INSERT INTO enum_state VALUES(9, 'malade');
INSERT INTO enum_state VALUES(10, 'professionnel');
INSERT INTO enum_state VALUES(11, 'professionnel');

INSERT INTO enum_promotion VALUES(1, 'FILA1');
INSERT INTO enum_promotion VALUES(2, 'FILA2');
INSERT INTO enum_promotion VALUES(3, 'FILA3');
INSERT INTO enum_promotion VALUES(4, 'FITA1');
INSERT INTO enum_promotion VALUES(5, 'FISEA1');
INSERT INTO enum_promotion VALUES(6, 'FISEA2');
INSERT INTO enum_promotion VALUES(7, 'FISEA3');

/*
Promotion FILA1
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('victoirelenglart', 'Lenglart', 'Victoire', 'victoire', 1, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('romainbarou', 'Barou', 'Romain', 'romain', 1, 1, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('romainorvoen', 'Orvoen', 'Romain', 'romain', 1, 1, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('sylvaindousset', 'Dousset', 'Sylvain', 'sylvain', 1, 1, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alexisgros', 'Gros', 'Alexis', 'alexis', 1, 1, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('samirkamar', 'Kamar', 'Samir', 'samir', 1, 1, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('tanguymossion', 'Mossion', 'Tanguy', 'tanguy', 1, 1, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('martinkeyling', 'Keyling', 'Martin', 'martin', 1, 1, 11);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('noemorvillers', 'Morvillers', 'Noé', 'noe', 1, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('nicolaskirchhoffer', 'Kirchhoffer', 'Nicolas', 'nicolas', 1, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('simonsassi', 'Sassi', 'Simon', 'simon', 1, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('clementnicolas', 'Nicolas', 'Clement', 'clement', 1, 2, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('guillaumegrimault', 'Grimault', 'Guillaume', 'guillaume', 1, 2, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jeremypouzargues', 'Pouzargues', 'Jeremy', 'jeremy', 1, 2, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('louismuzellec', 'Muzellec', 'Louis', 'louis', 1, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('adrienjallais', 'Jallais', 'Adrien', 'adrien', 1, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('lucasrouret', 'Rouret', 'Lucas', 'lucas', 1, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('cantincaloone', 'Caloone', 'Cantin', 'cantin', 1, 2, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('theomartel', 'Martel', 'Theo', 'theo', 1, 2, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('geraudsimon', 'Simon', 'Geraud', 'geraud', 1, 2, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('theoletouze', 'Letouze', 'Theo', 'theo', 1, 3, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('loisgigaud', 'Gigaud', 'Lois', 'lois', 1, 3, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('maellhoutellier', 'Lhoutellier', 'Mael', 'mael', 1, 3, 9);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('vincentescoffier', 'Escoffier', 'Vincent', 'vincent', 1, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('yanimensar', 'Imensar', 'Yan', 'yan', 1, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('raphaelpainter', 'Painter', 'Raphael', 'raphael', 1, 3, 9);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('remibardon', 'Bardon', 'Remi', 'remi', 1, 3, 11);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('floriandussable', 'Dussable', 'Florian', 'florian', 1, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('leobeaujean', 'Beaujean', 'Leo', 'leo', 1, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('victorleiglat', 'Leiglat', 'Victor', 'victor', 1, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('cynthiaandriamparivony', 'Andriamparivony', 'Cynthia', 'cynthia', 1, 3, 1);

/*
Promotion FILA2
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('robtdumbleton', 'Dumbleton', 'Robt', 'robt', 2, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jacksonsterner', 'Sterner', 'Jackson', 'jackson', 2, 1, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kevinwaltz', 'Waltz', 'Kelvin', 'kelvin', 2, 1, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jarrodrakow', 'Rakow', 'Jarrod', 'jarrod', 2, 1, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('louvalerius', 'Valerius', 'Lou', 'lou', 2, 1, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('rogeliolafortune', 'Lafortune', 'Rogelio', 'rogelio', 2, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('trentonhayashida', 'Hayashida', 'Trenton', 'trenton', 2, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('caseywagener', 'Wagener', 'Casey', 'casey', 2, 1, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('elwoodgranderson', 'Granderson', 'Elwood', 'elwood', 2, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('gusinman', 'Inman', 'Gus', 'gus', 2, 1, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('cameronlabar', 'Labar', 'Cameron', 'cameron', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('danmaggio', 'Maggio', 'Dan', 'dan', 2, 2, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alphonsolaver', 'Laver', 'Alphonso', 'alphonso', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alonsoadkison', 'Adkison', 'Alonso', 'alonso', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('forrestmango', 'Mango', 'Forrest', 'forrest', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('juanmijares', 'Mijares', 'Juan', 'juan', 2, 2, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('brookscoleman', 'Coleman', 'Brooks', 'brooks', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('sebastianlockwood', 'Lockwood', 'Sebastian', 'sebastian', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('sanfordbow', 'Bow', 'Sanford', 'sanford', 2, 2, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('reynaldonewton', 'Newton', 'Reynaldo', 'reynaldo', 2, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('patrickvialpando', 'Vialpando', 'Patrick', 'patrick', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('cedrickhuntington', 'Huntington', 'Cedrick', 'cedrick', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('merrillmani', 'Mani', 'Merrill', 'merrill', 2, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('rooseveltbreuning', 'Breuning', 'Roosevelt', 'roosevelt', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jeanhazelwood', 'Hazelwood', 'Jean', 'jean', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('trinidadpoe', 'Poe', 'Trinidad', 'trinidad', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('ottowickens', 'Wickens', 'Otto', 'otto', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jimgorski', 'Gorski', 'Jim', 'jim', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('londonvaughan', 'Vaughan', 'London', 'london', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('charlienolan', 'Nolan', 'Charlie', 'charlie', 2, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('pipernunez', 'Nunez', 'Piper', 'piper', 2, 3, 6);

/*
Promotion FILA3
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('cristallester', 'Lester', 'Cristal', 'cristal', 3, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aspenconrad', 'Conrad', 'Aspen', 'aspen', 3, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('ellenwu', 'Wu', 'Ellen', 'ellen', 3, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('pamelawalter', 'Walter', 'Pamela', 'pamela', 3, 1, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('maribelfrancis', 'Francis', 'Maribel', 'Maribel', 3, 1, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('derekmckinney', 'McKinney', 'Derek', 'derek', 3, 1, 9);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('fredericksantiago', 'Frederick', 'Santiago', 'santiago', 3, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('laurynhamilton', 'Hamilton', 'Lauryn', 'lauryn', 3, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('andreaolsen', 'Olsen', 'Andrea', 'andrea', 3, 1, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('lizethjones', 'Jones', 'Lizeth', 'lizeth', 3, 1, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('crystalwilkerson', 'Wilkerson', 'Crystal', 'crystal', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('brentonwoodard', 'Woodard', 'Benton', 'benton', 3, 2, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('brennenmoore', 'Moore', 'Brennen', 'brennen', 3, 2, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('calliemccoy', 'Mccoy', 'Callie', 'callie', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('andersondavidson', 'Davidson', 'Anderson', 'anderson', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('leylajuarez', 'Juarez', 'Leyla', 'leyla', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jakemorris', 'Morris', 'Jake', 'jake', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jonathoncarlson', 'Carlson', 'Jonathon', 'jonathon', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('rebekahswanson', 'Swanson', 'Rebekah', 'rebekah', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('hannahhorne', 'Horne', 'Hannah', 'hannah', 3, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('javiervillanueva', 'Villanueva', 'Javier', 'javier', 3, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('janaegill', 'Gill', 'Janae', 'janae', 3, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('salvatorewiggins', 'Wiggins', 'Salvatore', 'salvatore', 3, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('miahbooker', 'Booker', 'Miah', 'miah', 3, 3, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('ellenklein', 'Klein', 'Ellen', 'ellen', 3, 3, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('caraproctor', 'Proctor', 'Cara', 'cara', 3, 3, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('gracieenglish', 'English', 'Gracie', 'gracie', 3, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('tiaraarellano', 'Arellano', 'Tiara', 'tiara', 3, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('julissadixon', 'Dixon', 'Julissa', 'julissa', 3, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('harperzamora', 'Zamora', 'Harper', 'harper', 3, 3, 2);

/*
Promotion FITA1
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('tiasnyder', 'Snyder', 'Tia', 'tia', 4, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('damionbell', 'Bell', 'Damion', 'damion', 4, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('juantorres', 'Torres', 'Juan', 'juan', 4, 1, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('evantaylor', 'Taylor', 'Evan', 'evan', 4, 1, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('salvadormccann', 'Mccann', 'Salvador', 'salvador', 4, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aleenamiddleton', 'Middleton', 'Aleena', 'aleena', 4, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('caitlinblair', 'Blair', 'Caitlin', 'caitlin', 4, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('calvinmason', 'Mason', 'Calvin', 'calvin', 4, 1, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('marleyyoung', 'Young', 'Marley', 'marley', 4, 1, 9);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('josephinechurch', 'Church', 'Josephine', 'josephine', 4, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aliyacamacho', 'Camacho', 'Aliya', 'aliya', 4, 2, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('vanessawright', 'Wright', 'Vanessa', 'vanessa', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('paitynbarton', 'Barton', 'Paityn', 'paityn', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('michaelgraves', 'Graves', 'Michael', 'michael', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('saulponce', 'Ponce', 'Saul', 'saul', 4, 2, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('allanvaughan', 'Vaughan', 'Allan', 'allan', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('giovannidouglas', 'Douglas', 'Giovanni', 'giovanni', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('carlolong', 'Long', 'Carlo', 'carlo', 4, 2, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('gillianjensen', 'Jensen', 'Gillian', 'gillian', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aydanavila', 'Avila', 'Aydan', 'aydan', 4, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('bellacaldwell', 'Caldwell', 'Bella', 'bella', 4, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jaidenmoran', 'Moran', 'Jaiden', 'jaiden', 4, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kaileedavies', 'Davies', 'Kailee', 'kailee', 4, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('sashaortiz', 'Ortiz', 'Sasha', 'sasha', 4, 3, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('brentmcdaniel', 'Mcdaniel', 'Brent', 'brent', 4, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('marccisneros', 'Cisneros', 'Marc', 'marc', 4, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('savannabonilla', 'Bonilla', 'Savanna', 'savanna', 4, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('emmymichael', 'Michael', 'Emmy', 'emmy', 4, 3, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jacobarellano', 'Arellano', 'Jacob', 'jacob', 4, 3, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('edwardholland', 'Holland', 'Edward', 'edward', 4, 3, 1);

/*
Promotion FISE1
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('rainaschultz', 'Schultz', 'Raina', 'raina', 5, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('deshawnbarajas', 'Barajas', 'Deshawn', 'deshawn', 5, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('ronaldkennedy', 'Kennedy', 'Ronald', 'ronald', 5, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('libbymckinney', 'Mckinney', 'Libby', 'libby', 5, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('amarisoneal', 'Oneal', 'Amaris', 'amaris', 5, 1, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('eastonhunt', 'Hunt', 'Easton', 'easton', 5, 1, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('brodyoconnor', 'Oconnor', 'Brody', 'brody', 5, 1, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('abdullahjohnston', 'Johnston', 'Abdullah', 'abdullah', 5, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('reesebrennan', 'Brennan', 'Reese', 'reese', 5, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jasehebert', 'Hebert', 'Jase', 'jase', 5, 1, 10);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kaylynhurley', 'Hurley', 'Kaylyn', 'kaylyn', 5, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('elishaadams', 'Adams', 'Elisha', 'elisha', 5, 2, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('warrengutierrez', 'Gutierrez', 'Warren', 'warren', 5, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('damariscobb', 'Cobb', 'Damaris', 'damaris', 5, 2, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('christopherjoyce', 'Joyce', 'Christopher', 'christopher', 5, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('gageolsen', 'Olsen', 'Gage', 'gage', 5, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jaylynndalton', 'Dalton', 'Jaylynn', 'jaylynn', 5, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('chayaholder', 'Holder', 'Chaya', 'chaya', 5, 2, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alfonsoclay', 'Clay', 'Alfonso', 'alfonso', 5, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('toddsantana', 'Santana', 'Todd', 'todd', 5, 2, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('clareswanson', 'Swanson', 'Clare', 'clare', 5, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('marinburton', 'Burton', 'Marin', 'marin', 5, 3, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alonzorojas', 'Rojas', 'Alonzo', 'alonzo', 5, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jovanperez', 'Perez', 'Jovan', 'jovan', 5, 3, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('noelcross', 'Cross', 'Noel', 'noel', 5, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jenniferconley', 'Conley', 'Jennifer', 'jennifer', 5, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('bronsonbonilla', 'Bonilla', 'Bronson', 'bronson', 5, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('eileenlara', 'Lara', 'Eileen', 'eileen', 5, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('emmaleedaugherty', 'Daugherty', 'Emmalee', 'emmalee', 5, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('asherfigueroa', 'Figueroa', 'Asher', 'asher', 5, 3, 1);

/*
Promotion FISEA2
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('johnathonmcclure', 'Mcclure', 'Johnathon', 'johnathon', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('brileygates', 'Gates', 'Briley', 'briley', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('elianapennington', 'Pennington', 'Eliana', 'eliana', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('madeleinecastillo', 'Castillo', 'Madeleine', 'madeleine', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('thaddeuswu', 'Wu', 'Thaddeus', 'thaddeus', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('chancegalvan', 'Galvan', 'Chance', 'chance', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('matteomcbride', 'Mcbride', 'Matteo', 'matteo', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jalenho', 'Ho', 'Jalen', 'jalen', 6, 1, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jaydenbell', 'Bell', 'Jayden', 'jayden', 6, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('reedellis', 'Ellis', 'Reed', 'reed', 6, 1, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('tommyconner', 'Conner', 'Tommy', 'tommy', 6, 2, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('amarezamora', 'Zamora', 'Amare', 'amare', 6, 2, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('dantemccann', 'Mccann', 'Dante', 'dante', 6, 2, 11);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('cierrabrandt', 'Brandt', 'Cierra', 'cierra', 6, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('sterlingmarks', 'Marks', 'Sterling', 'sterling', 6, 2, 10);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jazmynsheppard', 'Sheppard', 'Jazmyn', 'jazmyn', 6, 2, 9);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aronstrickland', 'Strickland', 'Aron', 'aron', 6, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('dariowise', 'Wise', 'Dario', 'dario', 6, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('nasirmorton', 'Morton', 'Nasir', 'nasir', 6, 2, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kaylenduncan', 'Duncan', 'Kaylen', 'kaylen', 6, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aleahburgess', 'Burgess', 'Aleah', 'aleah', 6, 3, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('maximoholmes', 'Holmes', 'Maximo', 'holmes', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('louisbrowning', 'Browning', 'Louis', 'louis', 6, 3, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('giadadaniel', 'Daniel', 'Giada', 'giada', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('azulray', 'Ray', 'Azul', 'azul', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('isaiasscott', 'Scott', 'Isaias', 'isaias', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kingmurray', 'Murray', 'King', 'king', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kaylinarroyo', 'Arroyo', 'Kaylin', 'kaylin', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kylielewis', 'Lewis', 'Kylie', 'kylie', 6, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('emilienoble', 'Noble', 'Emilie', 'emilie', 6, 3, 11);

/*
Promotion FISEA3
*/

INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jaydanodom', 'Odom', 'Jaydan', 'jaydan', 7, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jordenwilliamson', 'Williamson', 'Jorden', 'jorden', 7, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('caseypierce', 'Pierce', 'Casey', 'casey', 7, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alondrapatrick', 'Patrick', 'Alondra', 'alondra', 7, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('owengray', 'Gray', 'Owen', 'owen', 7, 1, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('abelleon', 'Leon', 'Abel', 'abel', 7, 1, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('montserratpadilla', 'Padilla', 'Montserrat', 'montserrat', 7, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('julianasimmons', 'Simmons', 'Juliana', 'juliana', 7, 1, 5);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('damionsutton', 'Sutton', 'Damion', 'damion', 7, 1, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('alysonboyle', 'Boyle', 'Alyson', 'alyson', 7, 1, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('levidavies', 'Davies', 'Levi', 'levi', 7, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('georgehuang', 'Huang', 'George', 'george', 7, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('hillarymelton', 'Melton', 'Hillary', 'hillary', 7, 2, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('derrickdaniel', 'Daniel', 'Derrick', 'derrick', 7, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('victorcordova', 'Cordova', 'Victor', 'victor', 7, 2, 7);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('moshesalazar', 'Salazar', 'Moshe', 'moshe', 7, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('ainsleypittman', 'Pittman', 'Ainsley', 'ainsley', 7, 2, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('islamcneil', 'Mcneil', 'Isla', 'isla', 7, 2, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('linaweeks', 'Weeks', 'Lina', 'lina', 7, 2, 4);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('claireromero', 'Romero', 'Claire', 'claire', 7, 2, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('simonhoward', 'Howard', 'Simon', 'simon', 7, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('anniecobb', 'Cobb', 'Annie', 'annie', 7, 3, 3);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('justinhooper', 'Hooper', 'Justin', 'justin', 7, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('carlomorse', 'Morse', 'Carlo', 'carlo', 7, 3, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('aryanhensley', 'Hensley', 'Aryan', 'aryan', 7, 3, 6);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('raidenbarnes', 'Barnes', 'Raiden', 'raiden', 7, 3, 8);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('kaileycalhoun', 'Calhoun', 'Kailey', 'kailey', 7, 3, 2);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('lennonroth', 'Roth', 'Lennon', 'lennon', 7, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('jessicajimenez', 'Jimenez', 'Jessica', 'jessica', 7, 3, 1);
INSERT INTO student(login, lastname, firstname, _password, promotion, englishGroup, state) VALUES('bellarobbins', 'Robbins', 'Bella', 'bella', 7, 3, 1);