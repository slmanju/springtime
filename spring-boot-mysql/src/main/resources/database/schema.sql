-- create database book_store;

CREATE TABLE IF NOT EXISTS book (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    author VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);
