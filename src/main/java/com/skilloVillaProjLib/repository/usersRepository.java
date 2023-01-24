package com.skilloVillaProjLib.repository;

import com.skilloVillaProjLib.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
public interface usersRepository extends JpaRepository<Users,Integer> {
    @Modifying
    @Query(value="insert into borrow_record(borrow_date,due_date,library_books_id,users_id) values(?,?,?,?)",nativeQuery = true)
    void addIntoBorrowRecord(@Param("borrow_date")LocalDateTime borrow_date,@Param("due_date")LocalDateTime due_date,@Param("library_books_id") int library_books_id,@Param("users_id") int users_id);

    //@Query("SELECT c.year, COUNT(c.year) FROM Comment AS c GROUP BY c.year ORDER BY c.year DESC")
//    SELECT COUNT(CustomerID), Country
//    FROM Customers
//    GROUP BY Country
//    ORDER BY COUNT(CustomerID) DESC;
//    @Query(value = "SELECT COUNT(users_id) as count FROM borrow_record GROUP BY borrow_record.users_id=?1 HAVING count<=5;",nativeQuery = true)
//    int countUsersByBorrowRecords(@Param("users_id") int users_id);


    @Query(value = "SELECT COUNT(*) as c FROM borrow_record WHERE users_id =?1 having c<=5;",nativeQuery = true)
    int countUsersByBorrowRecords(@Param("users_id") int users_id);

    @Query(value = "SELECT IFNULL(count(users_id),0)  from borrow_record as b where b.users_id=?1;",nativeQuery = true)
    int isUsersId(@Param("users_id") int users_id);

    @Query(value="select due_date from borrow_record where library_books_id=?1 and users_id=?2",nativeQuery = true)
    LocalDateTime due_date(@Param("library_books_id") int library_books_id,@Param("users_id")int users_id);

    @Modifying
    @Query(value="insert into return_record(actual_return_date,due_date,library_books_id,fine_paid,users_id) values(?,?,?,?,?)",nativeQuery = true)
    void addIntoReturnRecord(@Param("actual_return_date")LocalDateTime actual_return_date,@Param("due_date")LocalDateTime due_date,@Param("library_books_id") int library_books_id,@Param("fine_paid") int fine_paid,@Param("users_id") int users_id);


    }
