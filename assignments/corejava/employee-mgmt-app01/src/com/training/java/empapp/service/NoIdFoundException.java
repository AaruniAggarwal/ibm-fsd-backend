package com.training.java.empapp.service;


public class NoIdFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoIdFoundException()
	{
		System.out.println("Id doesn't exist. Please enter a valid one.");
	}

}

