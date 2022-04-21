package com.exception;

//This is a checked exception aka comile time exception, so we have to extend Exception
@SuppressWarnings("serial")
public class CheckedException extends Exception{
	
	//constructor is calling the super constructor from Exception..
	//which is actually calling the constructor from Throwable
	public CheckedException(String message) {
		super(message);//super calls the SUPER constructor
	}
	
	// so the whole point of this constructor  is to  return an Exception message (stack trace) when it gets thrwon

	
}
