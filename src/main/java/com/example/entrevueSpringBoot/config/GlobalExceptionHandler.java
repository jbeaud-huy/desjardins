package com.example.entrevueSpringBoot.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.entrevueSpringBoot.exception.ExceptionResponseMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * Gestionnaire d'exceptions standard
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * Interception des arguments illegaux
	 * 
	 * @param e l'exception soulevée
	 * @return une réponse formatée selon l'exception levée
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(final IllegalArgumentException e) {
		log.error("IllegalArgumentException : ", e);
		return new ResponseEntity<>(ExceptionResponseMessage.builder().code(HttpStatus.PRECONDITION_FAILED.toString())
				.message("Wrong paramaters").build(), HttpStatus.PRECONDITION_FAILED);
	}

	/**
	 * Interception des nullPointerException
	 * 
	 * @param e l'exception soulevée
	 * @return une réponse formatée selon l'exception levée
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(final NullPointerException e) {
		log.error("NullPointerException : ", e);
		return new ResponseEntity<>(ExceptionResponseMessage.builder().code(HttpStatus.PRECONDITION_FAILED.toString())
				.message("Wrong parameters").build(), HttpStatus.PRECONDITION_FAILED);
	}

}
