package org.generation.italy.exceptions;

public class EmptyValueException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3860775743771840579L;

	public EmptyValueException(String message) {  
		super("Empty value:"+ message);
		
	}

}
