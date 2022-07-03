package com.example.entrevueSpringBoot.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Response message to generate ...
 * @author jbeaudhuy
 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponseMessage implements Serializable {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -8257347675362189235L;

	/**
	 * Exception code
	 */
	private String code;

	/**
	 * Message de l'exception.
	 */
	private String message;
}
