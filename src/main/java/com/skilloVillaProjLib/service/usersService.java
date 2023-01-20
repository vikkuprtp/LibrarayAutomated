package com.skilloVillaProjLib.service;

import com.skilloVillaProjLib.model.Users;
import com.skilloVillaProjLib.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class usersService {
    @Autowired
    private usersRepository userRepository;

    public List<Map<String,Object>> borrowBooks(Integer user_id,List<Map<String,Object>> ls){

        return ls;
    }

}
