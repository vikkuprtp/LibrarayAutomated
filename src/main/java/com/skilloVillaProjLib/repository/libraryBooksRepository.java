package com.skilloVillaProjLib.repository;

import com.skilloVillaProjLib.model.libraryBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface libraryBooksRepository extends JpaRepository<libraryBooks,Integer> {

    @Modifying
    @Query(value = "insert into library_books(author_name,book_name,genre) values(?,?,?)",nativeQuery = true)
    void saveAll(@Param("author_name") String author_name,@Param("book_name") String book_name,@Param("genre") String genre);
}
