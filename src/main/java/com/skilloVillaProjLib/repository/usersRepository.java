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


    @Query(value = "select users_id,count(*) as count from borrow_record group by users_id having count=5;",nativeQuery = true)
    int countUsersById(@Param("users_id") int users_id);

    @Query(value="select due_date from borrow_record where library_books_id=?1 and users_id=?2",nativeQuery = true)
    LocalDateTime due_date(@Param("library_books_id") int library_books_id,@Param("users_id")int users_id);

    @Modifying
    @Query(value="insert into return_record(actual_return_date,due_date,library_books_id,fine_paid,users_id) values(?,?,?,?,?)",nativeQuery = true)
    void addIntoReturnRecord(@Param("actual_return_date")LocalDateTime actual_return_date,@Param("due_date")LocalDateTime due_date,@Param("library_books_id") int library_books_id,@Param("fine_paid") int fine_paid,@Param("users_id") int users_id);



}
