-- Library 

--CREATE DATABASE library WITH OWNER=postgres ENCODING='UTF8';


--DROP TABLE author;
--DROP TABLE book;
--DROP TABLE genre;

-- Tables for the DB

CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    full_name text NOT NULL, -- FIO
    birthday date, -- Year of birth
    biography text -- Biography
);



CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    name text NOT NULL,
    publish_day int,
    style text,
    author_id int
);

-- Populates the DB

INSERT INTO author (full_name, birthday, biography) VALUES ('Tolstoy Lev Nikolayevich', '2001-10-05', 'On September 9, 1828, Leo Tolstoy was born in Tula Province, Russia. In the 1860s, he wrote his first great novel, War and Peace. In 1873, Tolstoy set to work on the second of his best known novels, Anna Karenina. He continued to write fiction throughout the 1880s and 1890s. One of his most successful later works was The Death of Ivan Ilyich. Tolstoy died on November 20, 1910 in Astapovo, Russia.');
INSERT INTO author (full_name, birthday, biography) VALUES ('Erich Gamma', '2001-10-05', 'Erich Gamma (born 1961 in Zurich) is Swiss computer scientist and co-author of the influential software engineering textbook, Design Patterns: Elements of Reusable Object-Oriented Software. He co-wrote the JUnit software testing framework with Kent Beck and led the design of the Eclipse platform`s Java Development Tools (JDT). He also worked on the IBM Rational Jazz project.');
INSERT INTO author (full_name, birthday, biography) VALUES ('Richard Helm', '2001-10-05', '<N/A>');
INSERT INTO author (full_name, birthday, biography) VALUES ('Ralph Johnson', '2001-10-05', 'Ralph was an early pioneer in the Smalltalk community and is a continued supporter of the language. He has held several executive roles at the ACM Object-Oriented Programming, Systems, Languages and Applications conference OOPSLA, which he attends every year. He initiated the popular OOPSLA Design Fest workshop.');
INSERT INTO author (full_name, birthday, biography) VALUES ('John Vlissides', '2001-10-05', 'John Matthew Vlissides (August 2, 1961 - November 24, 2005) was a software scientist known mainly as one of the four authors (referred to as the Gang of Four) of the book Design Patterns: Elements of Reusable Object-Oriented Software. Vlissides referred to himself as "#4 of the Gang of Four and wouldn`t have it any other way".');
SELECT * FROM author;



INSERT INTO book (name, publish_day, style,author_id) VALUES ('War and Peace', 1869, 1,1);
INSERT INTO book (name, publish_day, style,author_id) VALUES ('Anna Karenina', 1877, 1,null);
INSERT INTO book (name, publish_day, style,author_id) VALUES ('Design Patterns: Elements of Reusable Object-Oriented Software', 1994, 4,1);
SELECT * FROM book;


