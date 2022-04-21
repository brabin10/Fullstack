package com.exception;

//Unchecked Exception aka Runtime Exception must extend RuntimeException

public class UncheckedException extends RuntimeException {

	//constructor
	//similar to our checkdException, this constructor will let us display a stack trace (Error message)
	
	public UncheckedException(String message) {
		super(message);//This super() is calling the constructor form RuntimeException, which calls Exception Throwable
	}
}
