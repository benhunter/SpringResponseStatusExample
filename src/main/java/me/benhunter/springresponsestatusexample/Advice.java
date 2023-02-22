package me.benhunter.springresponsestatusexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException badRequestException) {
//        return ResponseEntity.badRequest().body("Bad bad bad");
        return new ResponseEntity<>("Bad bad bad", HttpStatus.BAD_REQUEST);
    }
}
