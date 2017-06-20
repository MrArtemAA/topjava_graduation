DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@world.org', 'user'),
  ('Admin', 'admin@world.org', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('USER', 100000),
  ('ADMIN', 100001),
  ('USER', 100001);

INSERT INTO restaurants (name) VALUES
  ('Прага'),
  ('У Дяди Федора');

INSERT INTO dishes (name, date, time, price, restaurant_id) VALUES
  /*('Fish', today(), now(), 100, 100002),
  ('Chips', today(), now(), 50, 100002),
  ('Water', today(), now(), 10, 100002),
  ('Soup', today(), now(), 100, 100003),
  ('Steak', today(), now(), 250, 100003);*/
  ('Fish', today(), now(), 100, 100002),
  ('Chips', today(), now(), 50, 100002),
  ('Water', today(), now(), 10, 100002),
  ('Soup', today(), now(), 100, 100003),
  ('Steak', today(), now(), 250, 100003);
