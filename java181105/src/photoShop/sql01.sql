CREATE TABLE MEMBER(name varchar(20),
age int,
phonenum varchar(20));

INSERT INTO MEMBER(name, age, phonenum) VALUES ('박병관', 3, '111-1111');

INSERT INTO MEMBER VALUES ('이명호', 5, '222-2222');

INSERT INTO MEMBER VALUES ('이은비', 7, '333-3333');

SELECT * FROM MEMBER;

SELECT * FROM MEMBER WHERE name='박병관';

DELETE FROM MEMBER WHERE name='박병관';

SELECT * FROM MEMBER WHERE name LIKE '%박%';