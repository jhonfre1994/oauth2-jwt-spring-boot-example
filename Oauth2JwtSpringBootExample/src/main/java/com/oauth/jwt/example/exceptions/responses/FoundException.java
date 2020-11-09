package com.oauth.jwt.example.exceptions.responses;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class FoundException extends RuntimeException {

	public FoundException(String exception) {
		super(exception);
	}

}

