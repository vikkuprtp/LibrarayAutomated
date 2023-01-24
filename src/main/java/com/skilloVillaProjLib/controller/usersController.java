package com.skilloVillaProjLib.controller;
import com.skilloVillaProjLib.exceptionHandler.PostResponseHandler;
import com.skilloVillaProjLib.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.util.Map;

@RestController
public class usersController {

    @Autowired
    private usersService userServices;

    @PostMapping("/api/home/borrow-record/user")
    public ResponseEntity<Object> borrowBooks(@RequestBody Map<?,?> mp, @RequestParam("users_id") Integer users_id) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime borrow_date = localDateTime;
  //          LocalDateTime due_date = localDateTime.plusDays(7);
            LocalDateTime due_date=localDateTime.plusMinutes(1);
            int library_books_id = (int) mp.get("libraryBooksId");
            int count=userServices.countbyborrowBooks(users_id);
            if (count <= 5) {
                userServices.borrowBooks(borrow_date, due_date, library_books_id, users_id);
                boolean bool = true;
                return PostResponseHandler.genPostResponse("successful", HttpStatus.ACCEPTED, bool, due_date);
            }
            boolean bool = false;
            return PostResponseHandler.generatePostResponse("Not Allowed", HttpStatus.BAD_REQUEST, bool);

        } catch (Exception e) {
            boolean bool = false;
            return PostResponseHandler.generatePostResponse("Not Allowed", HttpStatus.BAD_REQUEST, bool);
        }
    }



    @PostMapping("/api/home/return-record/user")
    public ResponseEntity<Object> returnBooks(@RequestBody Map<?,?> mp, @RequestParam("users_id") Integer users_id){
        try {
            int finePerDay = 50;
            int finePerMinute=50;
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime actualReturnDate = localDateTime;
            int library_books_id = (int) mp.get("libraryBooksId");
            int fine_paid = (int) mp.get("fine_paid");
            LocalDateTime due_date = userServices.getDueDate(library_books_id, users_id);
            System.out.println(due_date);

            //Tried over 7 days of gap for usage
//             if (actualReturnDate.getDayOfMonth()<=due_date.getDayOfMonth()) {
//                userServices.returnRecord(actualReturnDate, due_date, library_books_id, fine_paid, users_id);
//                boolean bool = true;
//                return PostResponseHandler.genPostResponse("successful", HttpStatus.ACCEPTED, bool, due_date);
//             }else if(actualReturnDate.getDayOfMonth() > due_date.getDayOfMonth()){
//                int noOfDay = actualReturnDate.getDayOfMonth()-due_date.getDayOfMonth();
//                fine_paid = noOfDay * finePerDay;
//                userServices.returnRecord(actualReturnDate, due_date, library_books_id, fine_paid, users_id);
//                boolean bool = true;
//                return PostResponseHandler.genPostResponse("successful", HttpStatus.ACCEPTED, bool, due_date);
//             }else{
//             boolean bool=false;
//             return PostResponseHandler.generatePostResponse("wonderful",HttpStatus.BAD_REQUEST,bool);}

            //Checking the fine amount to be collected taking difference in minutes
            //Both cases works

            if (due_date.isAfter(actualReturnDate)) {
                userServices.returnRecord(actualReturnDate, due_date, library_books_id, fine_paid, users_id);
                boolean bool = true;
                return PostResponseHandler.genPostResponseForFinePaid("successful", HttpStatus.ACCEPTED, bool, due_date,actualReturnDate,fine_paid);
            }else if(due_date.isBefore(actualReturnDate)){
                int noOfMinute = actualReturnDate.getMinute()-due_date.getMinute();
                fine_paid = noOfMinute * finePerMinute;
                userServices.returnRecord(actualReturnDate, due_date, library_books_id, fine_paid, users_id);
                boolean bool = true;
                return PostResponseHandler.genPostResponseForFinePaid("successful", HttpStatus.ACCEPTED, bool, due_date,actualReturnDate,fine_paid);
            }else{
                boolean bool=false;
                return PostResponseHandler.generatePostResponse("wonderful",HttpStatus.BAD_REQUEST,bool);}
        }catch(Exception e){
            boolean bool=false;
            return PostResponseHandler.generatePostResponse("Not Allowed",HttpStatus.BAD_REQUEST,bool);
        }
    }
}
