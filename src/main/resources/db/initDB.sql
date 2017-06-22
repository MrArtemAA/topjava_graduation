DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE dishes IF EXISTS;
DROP TABLE restaurants IF EXISTS;

DROP SEQUENCE GLOBAL_SEQ IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE users
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(50) NOT NULL ,
  email            VARCHAR(50) NOT NULL,
  password         VARCHAR(255) NOT NULL,
  registered       TIMESTAMP DEFAULT now(),
  enabled          BOOLEAN   DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id          INTEGER NOT NULL,
  role             VARCHAR(30),

  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(100) NOT NULL
);

CREATE TABLE dishes
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(30) NOT NULL,
  date             DATE DEFAULT today(),
  price            INTEGER NOT NULL,
  restaurant_id    INTEGER NOT NULL,

  CONSTRAINT dishes_unique_rest_date_name_idx UNIQUE (name, date, restaurant_id),
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE votes
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  date             DATE DEFAULT today(),
  --time             TIME,
  user_id          INTEGER NOT NULL,
  restaurant_id    INTEGER NOT NULL,

  CONSTRAINT votes_unique_date_user_restaurant_idx UNIQUE (date, user_id, restaurant_id),
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
)