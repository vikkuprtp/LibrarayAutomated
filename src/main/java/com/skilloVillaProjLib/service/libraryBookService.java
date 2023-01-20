package com.skilloVillaProjLib.service;

import com.skilloVillaProjLib.repository.libraryBooksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class libraryBookService {
    @Autowired
    private libraryBooksRepository libraryBooksRepository;

    public List<Map<?,?>>  addBooks(String author_name, String book_name, String genre){
       return new ArrayList<>(libraryBooksRepository.saveAll(author_name,book_name,genre));
    }

}
