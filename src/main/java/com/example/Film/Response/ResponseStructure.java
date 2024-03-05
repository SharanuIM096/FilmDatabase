package com.example.Film.Response;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	private  HttpStatus httpStatus;

}
