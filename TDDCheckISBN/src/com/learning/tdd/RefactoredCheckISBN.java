package com.learning.tdd;

public class RefactoredCheckISBN {
	private static final int SHORT_VERSION_ISBN_MULTIPLIER = 11;
	private static final int LONG_VERSION_ISBN_MULTIPLIER = 10;
	private static final int SHORT_VERSION_ISBN = 10;
	private static final int LONG_VERSION_ISBN = 13;

	public boolean validate(String isbn) {
		if (isbn.length() == LONG_VERSION_ISBN) {
			return checkForLongISBNVersion(isbn);
		} else if 
			((isbn.length() == SHORT_VERSION_ISBN) )
				
			return checkForShortVersionISBN(isbn);
		
		throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long");
	}

	private boolean checkForLongISBNVersion(String isbn) {
		int total = 0;
		for (int i = 0; i < LONG_VERSION_ISBN; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}

		return (total % LONG_VERSION_ISBN_MULTIPLIER == 0);

	}

	private boolean checkForShortVersionISBN(String isbn) {
		int total = 0;
		for (int i = 0; i < SHORT_VERSION_ISBN; i++) {
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					total = total + 10;
				} else {
					throw new NumberFormatException("ISBN numbers can only contain numeric digits");
				}
			} else {
				total = total + Character.getNumericValue(isbn.charAt(i)) * (10 - i);
			}

		}

		return (total % SHORT_VERSION_ISBN_MULTIPLIER == 0);

	}

}
