package com.numeriquepro.springsecurity.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiException {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
}
