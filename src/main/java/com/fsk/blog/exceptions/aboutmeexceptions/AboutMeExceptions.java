package com.fsk.blog.exceptions.aboutmeexceptions;

import com.fsk.blog.exceptions.ExceptionMessages;
import com.fsk.blog.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AboutMeExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Object> handleCompanyNotFoundExceptions(CompanyNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionDateTime(LocalDateTime.now());
        response.setExceptionMessage(ExceptionMessages.COMPANY_NOT_FOUND);
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(ConferenceNotFoundException.class)
    public ResponseEntity<Object> handleConferenceNotFoundException(ConferenceNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionDateTime(LocalDateTime.now());
        response.setExceptionMessage(ExceptionMessages.CONFERENCE_NOT_FOUND);
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(ReferenceNotFoundException.class)
    public ResponseEntity<Object> handleReferenceNotFoundException(ReferenceNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionDateTime(LocalDateTime.now());
        response.setExceptionMessage(ExceptionMessages.REFERENCE_NOT_FOUND);
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionDateTime(LocalDateTime.now());
        response.setExceptionMessage(ExceptionMessages.PROJECT_NOT_FOUND);
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
