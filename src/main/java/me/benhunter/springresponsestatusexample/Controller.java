package me.benhunter.springresponsestatusexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<String> getRoot(@RequestBody(required = false) String requestBody) {
        if (requestBody != null && requestBody.contains("BAD")) {
            throw new BadRequestException();
        }
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }
}
