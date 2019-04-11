package com.bh08.javaquizapp.exceptions;

public class DataAccessException extends Exception {

	public DataAccessException(Throwable e) {
		super("A data source exception has occured.", e);
	}
	
	
	
}