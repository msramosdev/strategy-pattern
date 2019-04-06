package br.com.mramosdev.exceptions;

public class InfiniteValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InfiniteValueException(String message) {
		super(message);
	}
	
}
