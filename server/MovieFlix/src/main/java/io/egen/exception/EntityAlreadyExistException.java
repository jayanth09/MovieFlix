package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Entity already exist")
public class EntityAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;
}
