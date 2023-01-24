package com.skilloVillaProjLib.service;

import com.skilloVillaProjLib.model.Users;
import com.skilloVillaProjLib.repository.usersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class usersService {
    @Autowired
    private usersRepository userRepository;

    public void borrowBooks(LocalDateTime borrow_date,LocalDateTime due_date,int library_books_id,int users_id){
             userRepository.addIntoBorrowRecord(borrow_date,due_date,library_books_id,users_id);

    }
    public int countbyborrowBooks(int users_id){
        return userRepository.countUsersByBorrowRecords(users_id);

    }


    public LocalDateTime getDueDate(int library_books_id,int users_id){
        return userRepository.due_date(library_books_id,users_id);
    }

    public void returnRecord(LocalDateTime actual_return_date,LocalDateTime due_date,int library_books_id,int fine_paid,int users_id){
        userRepository.addIntoReturnRecord(actual_return_date,due_date,library_books_id,fine_paid,users_id);
    }



}
