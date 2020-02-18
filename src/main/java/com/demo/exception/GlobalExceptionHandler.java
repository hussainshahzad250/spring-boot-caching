package com.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 
 * @author shahzad.hussain
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Response> handlerException(ObjectNotFoundException ex) {
		logger.error("ObjectNotFoundException occurs => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), ex.getHttpStatus()), ex.getHttpStatus());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Response> handlerBadRequestException(BadRequestException ex) {
		logger.error("BadRequestException occurs => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), ex.getHttpStatus()), ex.getHttpStatus());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Response> handlerRequestMethodException(HttpRequestMethodNotSupportedException ex) {
		logger.error("HttpRequestMethodNotSupportedException Occured => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handlerException(Exception ex, WebRequest request) {
		logger.error("Exception occurs => {} ", ex);
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Response> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		logger.error("MethodArgumentTypeMismatchException Occured => {}", ex);
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

}
