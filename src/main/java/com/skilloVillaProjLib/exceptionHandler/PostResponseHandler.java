package com.skilloVillaProjLib.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostResponseHandler {

    public static ResponseEntity<Object> generatePostResponse(String message, HttpStatus status, boolean bool) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("HTTP status", status.value());
        map.put("status", bool);
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> genPostResponse(String message, HttpStatus status, boolean bool, LocalDateTime due_date) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("HTTP status", status.value());
        map.put("status", bool);
        map.put("due_date", due_date);
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> genPostResponseForFinePaid(String message, HttpStatus status, boolean bool, LocalDateTime due_date,LocalDateTime actualReturnDate,int fine_paid) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("HTTP status", status.value());
        map.put("status", bool);
        map.put("due_date", due_date);
        map.put("return_date",actualReturnDate);
        map.put("fine_paid",fine_paid);
        return new ResponseEntity<>(map, status);
    }
}
