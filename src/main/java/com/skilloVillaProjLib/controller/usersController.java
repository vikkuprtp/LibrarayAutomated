package com.skilloVillaProjLib.controller;
import com.skilloVillaProjLib.model.Users;
import com.skilloVillaProjLib.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/home/users")
public class usersController {

    @Autowired
    private usersService userService;

    public ResponseEntity<Object> borrowBooks(@RequestBody Users u, @RequestParam Integer user_id){
        return null;
    }

}
