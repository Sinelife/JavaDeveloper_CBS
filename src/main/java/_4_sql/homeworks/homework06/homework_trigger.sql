/*EX1-------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*Создание таблички коментариев*/
CREATE TABLE comments(
  id SERIAL PRIMARY KEY,
  comment_text TEXT,
  creation_date DATE,
  update_date DATE
);
/*Заполнение таблички коментариев*/
INSERT INTO comments(comment_text, creation_date, update_date) VALUES ('Some text', NOW(), NULL );
INSERT INTO comments(comment_text, creation_date, update_date) VALUES ('QWERTYUIKJBVXGNB', NOW(), NULL );
INSERT INTO comments(comment_text, creation_date, update_date) VALUES ('4987538794573', NOW(), NULL );

/*Создание процедуры*/
CREATE OR REPLACE FUNCTION updateDate()
  RETURNS TRIGGER AS $$
BEGIN
  IF old.comment_text != new.comment_text
  THEN
    new.update_date = NOW();
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

/*создания тригера*/
CREATE TRIGGER updateLastEditDate BEFORE UPDATE ON "comments" FOR EACH ROW EXECUTE PROCEDURE updateDate();


/*обновление коментария*/
UPDATE "comments" SET comment_text = 'SOME OTHER ferfferfT345353' WHERE id = 1;




/*!!!!!!!!!!!!!!!!Для удаления таблички, тригера и процедуры*/
DROP TRIGGER updateLastEditDate on comments;
DROP FUNCTION updateDate();
DROP TABLE comments;






/*EX2-------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*Создание табличек пользователей, топиков, комментариев и истории комментариев*/
CREATE TABLE h6_users(
  id SERIAL PRIMARY KEY,
  username VARCHAR(40)
);

CREATE TABLE h6_topics(
  id SERIAL PRIMARY KEY,
  title TEXT
);

CREATE TABLE h6_comments(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES h6_users(id),
  title TEXT,
  text TEXT,
  topic_id INTEGER REFERENCES h6_topics(id)
);

CREATE TABLE h6_comment_history(
  id SERIAL PRIMARY KEY,
  comment_id INTEGER REFERENCES h6_comments(id),
  old_value TEXT,
  new_value TEXT,
  column_name TEXT,
  edit_by VARCHAR(40),
  edit_when DATE
);


/*Заполнение табличек пользователей, топиков и комментариев*/
INSERT INTO h6_users(username) VALUES ('Andrey9999');
INSERT INTO h6_users(username) VALUES ('Viktoria');

INSERT INTO h6_topics(title) VALUES ('Java Starter');
INSERT INTO h6_topics(title) VALUES ('Java Essential');

INSERT INTO h6_comments(user_id, title, text, topic_id) VALUES (1, 'JavaStarterMethods', 'Methods is very useful.', 1);
INSERT INTO h6_comments(user_id, title, text, topic_id) VALUES (2, 'JavaStarterArray', 'Arrays are very cool!!', 1);
INSERT INTO h6_comments(user_id, title, text, topic_id) VALUES (1, 'JavaEssentialInnerClass', 'Inner classes are interesting...', 2);
INSERT INTO h6_comments(user_id, title, text, topic_id) VALUES (2, 'JavaStarterArrayList', 'ArraysList better than Array!!', 2);




/*Создание процедуры записывания в историю коментариев изменений заглавия коментария и текста коментария*/
CREATE OR REPLACE FUNCTION updateHistory()
  RETURNS TRIGGER AS $$
BEGIN
  IF old.title != new.title
  THEN
    INSERT INTO h6_comment_history(comment_id, old_value, new_value, column_name, edit_by, edit_when) VALUES (old.id, old.title, new.title, 'title', (SELECT u.username FROM h6_users u WHERE old.user_id = u.id), now());
  END IF;
  IF old.text != new.text
  THEN
    INSERT INTO h6_comment_history(comment_id, old_value, new_value, column_name, edit_by, edit_when) VALUES (old.id, old.text, new.text, 'text', (SELECT u.username FROM h6_users u WHERE old.user_id = u.id), now());
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

/*создания тригера, который будет вызывать процедуру при обновлении информации коментария*/
CREATE TRIGGER updateHistoryy BEFORE UPDATE ON "h6_comments" FOR EACH ROW EXECUTE PROCEDURE updateHistory();


/*Обновление некотррых коментариев чтоб оттестить триггер*/
UPDATE h6_comments SET text = 'SOME NEW TEXTTTTT' WHERE id = 1;
UPDATE h6_comments SET title = 'ghbjbgh' WHERE id = 3;
UPDATE h6_comments SET text = 'ASD GHJ KIOL PPPP', title = 'OTHER_TITLE' WHERE id = 2;



/*!!!!!!!!Удаление табличек и тригера*/
DROP TABLE h6_comment_history,h6_comments, h6_topics, h6_users;
DROP TRIGGER updateHistoryy ON "h6_comments";
DROP FUNCTION updateHistory();