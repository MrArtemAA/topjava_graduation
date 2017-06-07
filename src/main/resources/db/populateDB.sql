DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
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

INSERT INTO dishes (name, date, price, restaurant_id) VALUES
  ('Fish', now(), 100, 100002),
  ('Chips', now(), 50, 100002),
  ('Water', now(), 10, 100002),
  ('Soup', now(), 100, 100003),
  ('Steak', now(), 250, 100004)
