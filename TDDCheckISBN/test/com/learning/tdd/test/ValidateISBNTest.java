package com.learning.tdd.test;

import static org.junit.Assume.assumeTrue;

import org.junit.Test;

import com.learning.tdd.CheckISBN;

public class ValidateISBNTest {

	@Test
	public void checkValidIsbn() {
		CheckISBN isbn = new CheckISBN();
		boolean validate = isbn.validate("1526602385");
		assumeTrue("Is Valid isbn Number", validate);
	}

}
