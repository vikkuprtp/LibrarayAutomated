package com.skilloVillaProjLib.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetResponseHandler {
    public static ResponseEntity<Object> generateGetResponse(String message, HttpStatus status, List<Object> responseObject, boolean bool) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("HTTP status", status.value());
        map.put("data", responseObject);
        map.put("status", bool);
        return new ResponseEntity<>(map, status);
    }
    public static ResponseEntity<Object> generateCustomGetResponse(String message, HttpStatus status,List<Map<String,Object>> obj, boolean bool) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("data",obj);
        map.put("HTTP status", status.value());
        map.put("status", bool);
        return new ResponseEntity<>(map, status);
    }


}
