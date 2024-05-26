package com.example.demo.Exceptions;

public class InvalidEmailException extends RuntimeException {

	public InvalidEmailException (String msg) {
		System.out.println(msg);
	}
}
