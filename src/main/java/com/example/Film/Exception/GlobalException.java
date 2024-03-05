package com.example.Film.Exception;

import java.time.LocalDateTime;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice

public class GlobalException {
@ExceptionHandler(FilmNotFoundException.class)

public ResponseEntity<?> filmException(FilmNotFoundException exception,HttpServletRequest request){
	ApiError  apiError=new ApiError();
	apiError.setDateTime(LocalDateTime.now());
	apiError.setEndpoint(request.getRequestURI());
	apiError.setMessage(exception.getMessage());
	apiError.setHttpStatus(HttpStatus.NOT_FOUND);
	
	return new ResponseEntity(apiError,apiError.getHttpStatus());
}



}
