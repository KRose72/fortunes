package com.grangeinsurance.fortunes;

public class FortuneNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FortuneNotFoundException(String message) {
		super(message);
	}
}
