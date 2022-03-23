package com.duranco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RessourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RessourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RessourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	//

}
