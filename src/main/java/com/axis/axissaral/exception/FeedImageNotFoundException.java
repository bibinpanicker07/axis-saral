package com.axis.axissaral.exception;

public class FeedImageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -77615066L;

	public FeedImageNotFoundException() {
		super();
	}

	public FeedImageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FeedImageNotFoundException(String message) {
		super(message);
	}
	
}
