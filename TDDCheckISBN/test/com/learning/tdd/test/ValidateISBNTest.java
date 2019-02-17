package com.learning.tdd.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.tdd.CheckISBN;

public class ValidateISBNTest {

	@Test
	public void check10DigitValidIsbn() {
		CheckISBN isbn = new CheckISBN();
		assertTrue("Is Valid isbn Number", isbn.validate("0140449116"));
		assertTrue("second value", isbn.validate("0140177396"));
	}

	@Test
	public void check13DigitValidIsbn() {
		CheckISBN isbn = new CheckISBN();
		boolean result = isbn.validate("9781853260087");
		assertTrue("first value", result);
		result = isbn.validate("9781853267338");
		assertTrue("second value", result);
	}

	@Test
	public void checkInvalidIsbn() {
		CheckISBN validator = new CheckISBN();
		boolean result = validator.validate("0140449117");
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void NineDigitIsbnIsNotAllowed() {
		CheckISBN validator = new CheckISBN();
		validator.validate("123456789");
	}

	@Test(expected = NumberFormatException.class)
	public void NonNumricIsbnNotAllowed() {
		CheckISBN validator = new CheckISBN();
		validator.validate("helloworld");
	}

	@Test
	public void TenDigitISBNNumbersEndingInAnXAreValid() {
		CheckISBN validator = new CheckISBN();
		boolean result = validator.validate("012000030X");
		assertTrue(result);
	}

}
