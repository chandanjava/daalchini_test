package com.daalchini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Customer Not Available")
public class CustomerNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 8989898980L;

	public CustomerNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotAvailableException(Throwable cause) {
		super(cause);
	}

	
}
