package com.training.java.empapp.service;


public class IdAlreadyExists extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public IdAlreadyExists() {
		System.out.println("Id already exists. Please enter a new one.");
	}

}

