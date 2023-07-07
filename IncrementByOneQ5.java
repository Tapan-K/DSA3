package in.ineuron.assignmnet3;

import java.util.Arrays;

public class IncrementByOneQ5 {
	public int[] plusOne(int[] digits) {
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {

			digits[i]++;

			// If the digit becomes 10, set it to 0 and carry over the 1
			if (digits[i] == 10) {
				digits[i] = 0;
			} else {

				return digits;
			}
		}

		// If the loop completes, it means there is a carry from the most significant
		// digit
		int[] result = new int[n + 1];
		result[0] = 1;
		return result;
	}

	public static void main(String[] args) {
		// Question 5
		int[] digits = { 1, 2, 3 };

		IncrementByOneQ5 solution = new IncrementByOneQ5();
		int[] result = solution.plusOne(digits);

		System.out.println("Output: " + Arrays.toString(result));

	}

}
