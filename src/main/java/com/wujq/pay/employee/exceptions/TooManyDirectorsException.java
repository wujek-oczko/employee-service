package com.wujq.pay.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TooManyDirectorsException extends RuntimeException {

	public TooManyDirectorsException(String exception) {
		super(exception);
	}

}
