package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Entity not Found")
public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
}
