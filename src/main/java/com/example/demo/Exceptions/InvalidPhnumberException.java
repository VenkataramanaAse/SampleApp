package com.example.demo.Exceptions;

public class InvalidPhnumberException extends RuntimeException {
	public InvalidPhnumberException(String msg) {
		System.out.println("cause is "+msg);
	}
}
