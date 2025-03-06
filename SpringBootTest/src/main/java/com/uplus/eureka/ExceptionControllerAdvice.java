package com.uplus.eureka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice
 * Project에서 발생하는 모든 오류를 처리하는 기능
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        logger.error(e.getMessage());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=utf-8");

        String msg = "처리 중 오류 발생";
        if (e instanceof EurekaException) {
            msg = e.getMessage();
        }

        return new ResponseEntity<String>(msg,httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}