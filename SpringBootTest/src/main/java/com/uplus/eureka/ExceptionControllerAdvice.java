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
        
        //에러메세지가 한글인 경우 깨지므로 한글 처리를 위한 응답 헤더 설정
        httpHeaders.add("Content-Type", "application/json; charset=utf-8");

        String msg = "처리 중 오류 발생";
        
        // 에러가 우리가 만든 EurekaException 이라면
        if (e instanceof EurekaException) {
            msg = e.getMessage();
        }

        return new ResponseEntity<String>(msg,httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}