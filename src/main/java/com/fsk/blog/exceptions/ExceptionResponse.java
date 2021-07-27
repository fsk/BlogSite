package com.fsk.blog.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private String exceptionMessage;
    private LocalDateTime exceptionDateTime;

}
