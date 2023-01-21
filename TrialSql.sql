Drop database library;
create database library;
insert into users(id,address,name,phone_number,role_id) values(1,"India","Vikrant","3456789012",1);
insert into users(id,address,name,phone_number,role_id) values(2,"India","pratap","3456789012",2);
insert into users(id,address,name,phone_number,role_id) values(3,"japan","singh","3456909012",2);
insert into users(id,address,name,phone_number,role_id) values(4,"china","ching","9456909012",2);
insert into users(id,address,name,phone_number,role_id) values(5,"china","ching","9456909012",2);
select * from users;





insert into library_books(id,author_name,book_name,genre) values(1,"Cing","JOMOPONG","fiction");
insert into library_books(id,author_name,book_name,genre) values(2,"wing","zumangi","fiction");
insert into library_books(id,author_name,book_name,genre) values(3,"Youhan","Naruto","Anime");
insert into library_books(id,author_name,book_name,genre) values(4,"xinping","The dragon fist","Action");
insert into library_books(id,author_name,book_name,genre) values(5,"rajveer","The 2022:EOY","fiction");


create database library;


insert into borrow_record(id,borrow_date,due_date,library_books_id,users_id) values(1,"2022-11-02 13:23:44","2023-11-09 13:23:44",2,1);
insert into borrow_record(id,borrow_date,due_date,library_books_id,users_id) values(2,"2022-11-03 13:23:44","2023-11-05 13:23:44",3,1);
insert into borrow_record(id,borrow_date,due_date,library_books_id,users_id) values(3,"2022-11-02 13:23:44","2023-11-09 13:23:44",1,1);
insert into borrow_record(id,borrow_date,due_date,library_books_id,users_id) values(4,"2022-11-02 13:23:44","2023-11-09 13:23:44",4,1);
insert into borrow_record(id,borrow_date,due_date,library_books_id,users_id) values(5,"2022-11-02 13:23:44","2023-11-09 13:23:44",5,1);

delete from borrow_record where users_id=3;








select due_date from borrow_record where library_books_id=6 and users_id=3;

SELECT users_id, COUNT(users_id) as count FROM borrow_record GROUP BY users_id HAVING count < 5;
select users_id,count(*) as count from borrow_record group by users_id having count=5;
select * from users;
select * from return_record;
select * from borrow_record;

drop table users;
ALTER TABLE tbl_name DROP FOREIGN KEY fk_symbol;
drop table library_books;
ALTER TABLE library_books DROP FOREIGN KEY fk_symbol;

drop table borrow_record;
ALTER TABLE borrow_record DROP FOREIGN KEY users_borrowed_books ;insert into borrow_record(id,borrow_date,due_date,library_books_id,users_id) values(1,"2022-11-02 13:23:44","2023-11-09 13:23:44",2,1)
