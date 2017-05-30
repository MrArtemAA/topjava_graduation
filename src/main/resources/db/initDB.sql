DROP TABLE IF EXISTS restaurants;
-- DROP TABLE user_roles IF EXISTS;
-- DROP TABLE users IF EXISTS;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

/*CREATE TABLE users
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(255),
  email            VARCHAR(255)         NOT NULL,
  password         VARCHAR(255)         NOT NULL,
  registered       TIMESTAMP DEFAULT now(),
  enabled          BOOLEAN   DEFAULT TRUE,
  calories_per_day INTEGER DEFAULT 2000 NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS (email);*/

/*CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY ( user_id ) REFERENCES USERS (id) ON DELETE CASCADE
);*/

CREATE TABLE restaurants
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL
);