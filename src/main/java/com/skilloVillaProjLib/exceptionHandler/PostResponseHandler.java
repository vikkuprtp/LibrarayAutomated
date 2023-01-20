package com.skilloVillaProjLib.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}
