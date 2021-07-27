package com.fsk.blog.success.adminsuccess;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class AdminArticleSuccessMessages extends ResponseEntity {


    private String message;


    public AdminArticleSuccessMessages(HttpStatus status, String message) {
        super(status);
        this.message = message;
    }
}
