package com.javaegitimleri.petclinic.exception;

public class OwnerNotFoundException extends RuntimeException {

	public OwnerNotFoundException(String message) {
		super(message);
	}
}
