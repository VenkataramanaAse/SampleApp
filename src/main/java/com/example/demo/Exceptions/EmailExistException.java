package com.example.demo.Exceptions;

public class EmailExistException extends RuntimeException{
	public EmailExistException(String msg) {
		System.out.println(msg);
	}

}
