
/*1) Создать таблицу contact*/
CREATE TABLE contacts();


/*2) Удалить таблицу contact*/
DROP TABLE contacts;

/*3) Пересоздать таблицу contact с атрибутами first_name(VARCHAR, NON_NULL), last_name(TEXT), birthday(DATE), phone(INT), city(VARCHAR),country(VARCHAR)*/
CREATE TABLE contacts(
  first_name VARCHAR(30),
  last_name TEXT,
  birthday DATE,
  phone INT,
  city VARCHAR(30),
  country VARCHAR(30)
)

/*4) Изменить тип атрибута last_name с TEXT на VARCHAR*/
ALTER TABLE contacts
  ALTER COLUMN last_name
  SET DATA TYPE VARCHAR(30);


/*5) Добавить ограничение NON_NULL в атрибут last_name*/
ALTER TABLE contacts
  ALTER COLUMN last_name
  SET NOT NULL;



/*6) Заполнить таблицу contact 20 записями(женские имена должны заканчиваться на букву 'а') */
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Максим', 'Орлов',	'1980-12-11', 1111111, 'Киев', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Марина', 'Антонова','2000-12-23', 1113431, 'Харьков', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Злата', 'Андреева',	'2001-08-01', 143241111, 'Херсон', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Лера', 'Максимова',	'1998-11-19', 1154511, 'Сеул', 'Южная Корея');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Антонина', 'Чернова',	'1996-06-22', 76571111, 'Одесса', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Петр', 'Петренко',	'1978-03-12', 111176571, 'Немиров', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Антон', 'Антонович',	'1941-06-21', 11787111, 'Винница', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Дмитрий', 'Белов',	'1969-11-23', 17686781, 'Львов', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Николай', 'Белов',	'1997-10-10', 1443411, 'Симферополь', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Александр', 'Кириленко',	'1990-04-15', 3431111, 'Донецк', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Надежда', 'Лугина',	'1992-11-14', 1111535, 'Нью-Йорк', 'США');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Кирил', 'Орлов',	'1966-12-01', 1143111, 'Лондон', 'Англия');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Святослава', 'Гордиенко',	'2001-11-08', 10000111, 'Париж', 'Франция');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Федор', 'Федоренко',	'1982-10-02', 1113431, 'Берлин', 'Германия');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Святослав', 'Ромашкин',	'1949-03-03', 15656111, 'Мюнхен', 'Германия');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Мила', 'Демьянчук',	'1997-07-07', 111187871, 'Черновцы', 'Украина');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Катерина', 'Лугина',	'1995-11-10', 19999981, 'Минск', 'Белоруссия');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Григорий', 'Крутов',	'1967-10-10', 11888811, 'Лос-Анджелес', 'США');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Ольга', 'Маслова',	'2006-11-25', 111686811, 'Краков', 'Польша');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Геннадий', 'Федорин',	'1990-10-24', 1907651111, 'Токио', 'Япония');
INSERT INTO contacts(first_name, last_name, birthday, phone, city, country) VALUES ('Яна', 'Красилова',	'1993-05-05', 110651111, 'Пекин', 'Китай');



/*7) Добавить в таблицу contact атрибут gender(VARCHAR)*/
ALTER TABLE contacts
    ADD COLUMN "gender" VARCHAR(10);



/*8) Изменить таблицу contact, заполнив атрибут gender значениями male/female по условию - если first_name заканчивается на букву 'а' - female, все другие - male*/
UPDATE contacts
SET gender = 'female' WHERE first_name LIKE '%а';

UPDATE contacts
SET gender = 'male' WHERE first_name NOT LIKE '%а';




/*9) Добавить атрибут rating (INT) с ограничением на только положительные значения*/
ALTER TABLE contacts
  ADD COLUMN "rating" NUMERIC CHECK("rating" > 0);