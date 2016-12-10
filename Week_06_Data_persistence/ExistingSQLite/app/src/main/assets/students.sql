DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
    id INT PRIMARY KEY     NOT NULL,
    name          TEXT    NOT NULL,
    age           INT,
    address       CHAR(50)
);
INSERT INTO contacts (id, name, age, address) VALUES (1, 'Paul', 22, 'Singer Hall');
INSERT INTO contacts (id, name, age, address) VALUES (2, 'John', 23, 'Singer Hall');
INSERT INTO contacts (id, name, age, address) VALUES (3, 'Ben', 23, 'Callice Court');
