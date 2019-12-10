package com.ExpenseApp.customexception;

public class ExpenseNotFoundException extends RuntimeException {
	public ExpenseNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
