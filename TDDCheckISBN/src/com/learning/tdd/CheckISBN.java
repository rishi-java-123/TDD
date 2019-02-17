
package com.learning.tdd;

public class CheckISBN {

	public boolean validate(String string) {
		int total = 0;
		for (int i = 0; i < 10; i++) {
			total = total + string.charAt(i) * (10 - i);

		}

		if (total % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
