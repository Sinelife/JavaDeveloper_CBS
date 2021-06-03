/*Перечисление гендер*/
CREATE TYPE gender AS ENUM ('Female', 'Male');

/*Таблица информации про пользователей.*/
CREATE TABLE h4_user_details(
  id SERIAL PRIMARY KEY ,
  phone VARCHAR(40),
  email VARCHAR(30),
  age INTEGER,
  gender gender
);



/*Таблица пользователей
  Относиться к таблице информации про пользователей как 1 к 1
  так как информация привязываеться к каждому уникальному человеку*/
CREATE TABLE h4_users(
  id SERIAL PRIMARY KEY ,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  username VARCHAR(50),
  password VARCHAR(30),
  role VARCHAR(30),
  user_details_id INTEGER UNIQUE REFERENCES h4_user_details(id)
);



/*Таблица коментариев.
  Относиться к таюлице пользователей как много к 1
  так как один пользователь может оставлять много коментариев*/
CREATE TABLE h4_comments(
  id SERIAL PRIMARY KEY,
  title VARCHAR(40),
  text VARCHAR(200),
  isDeleted BOOLEAN,
  user_id INTEGER REFERENCES h4_users(id)
);


/*Таблица адресов.
  относиться к таблице пользователей как много к 1 так как у пользователя
  может быть несколько адресов*/
CREATE TABLE h4_addresses(
  id INTEGER PRIMARY KEY,
  city VARCHAR(30),
  country VARCHAR(30),
  postcode VARCHAR(30),
  user_id INTEGER REFERENCES h4_users(id)
);



/*Таблица продуктов*/
CREATE TABLE h4_products(
  id SERIAL PRIMARY KEY,
  name VARCHAR(40),
  description VARCHAR(100),
  price INTEGER
);




/*Таблицы категорий продуктов. Категория может иметь отцовскую категорию
  подкатегорией которой она являеться*/
CREATE TABLE h4_categories(
  id SERIAL PRIMARY KEY,
  name VARCHAR(40),
  description VARCHAR(200),
  parent_category_id INTEGER REFERENCES h4_categories(id)
);




/*Вспомагательная табличка для связи много к много между таблицами продуктов
  и категорий продуктов. Одна категория может быть у многих продуктов и
  продукты могут иметь несколько категорий.*/
CREATE TABLE h4_products_categories(
  id SERIAL PRIMARY KEY,
  product_id INTEGER REFERENCES h4_products(id),
  category_id INTEGER REFERENCES h4_categories(id)
);


/*Таблица заказов пользователей.
  Относиться к таблице пользователей как много к 1.
  Один пользователь может зделать много заказов и один заказ может зделать
  лишь один пользователь*/
CREATE TABLE h4_orders(
  id SERIAL PRIMARY KEY,
  serial_number INTEGER,
  order_status BOOLEAN,
  user_id INTEGER REFERENCES h4_users(id),
  address_id INTEGER REFERENCES h4_addresses(id)
);



/*Вспомогательная таблица для связи много к много в таблицах продуктов
  и заказов. В одном заказе может быть много продуктов, и один продукт
  может встречаться в многих заказах.*/
CREATE TABLE h4_orders_products(
  id SERIAL PRIMARY KEY,
  order_id INTEGER REFERENCES h4_orders(id),
  product_id INTEGER REFERENCES h4_products(id),
  quantity INTEGER
);



/*Таблица тегов.*/
CREATE TABLE h4_tags(
  id SERIAL PRIMARY KEY,
  name VARCHAR(50)
);



/*Вспомагательная таблица для связи много к много таблиц продуктов и тегов.
  Один тег может встречаться в многих продуктах, и один продукт может иметь
  много тегов.*/
CREATE TABLE h4_products_tags(
  id SERIAL PRIMARY KEY,
  tag_id INTEGER REFERENCES h4_tags(id),
  product_id INTEGER REFERENCES h4_products(id)
);




/*Удаление всех таблиц*/
DROP TABLE h4_products, h4_tags, h4_orders_products, h4_products_categories,h4_products_tags, h4_users, h4_user_details, h4_categories, h4_comments, h4_addresses, h4_orders;
DROP TYPE gender;