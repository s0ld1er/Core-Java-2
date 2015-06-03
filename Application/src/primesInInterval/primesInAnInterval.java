package primesInInterval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class primesInAnInterval {

	private static final ArrayList<Integer> intervalOfPrimes(int startNumber,
			int endNumber) {
		final ArrayList<Integer> primeNumbersInRange = new ArrayList<Integer>(
				(endNumber >> 1) + 2);
		final int SQRT_MAX = (int) (Math.sqrt(endNumber) + 1);
		final int MEMORY_SIZE = ((endNumber >> 1) + 1);
		final boolean[] boolResult = new boolean[MEMORY_SIZE];
		if (startNumber == 2)
			primeNumbersInRange.add(2);

		if (startNumber > 0 && endNumber > 0 && startNumber < endNumber) {

			for (int i = 3; i < SQRT_MAX; i += 2) {
				if (!boolResult[(i >> 1)]) {
					int j = (i * i) >> 1;
					while (j < MEMORY_SIZE) {
						boolResult[j] = true;
						j += i;
					}
				}
			}

			for (int i = 1; i <= endNumber; i += 2) {
				if (!boolResult[(i >> 1)] && i >= startNumber) {
					primeNumbersInRange.add(i);
				}
			}
			

			return primeNumbersInRange;

		} else if (startNumber < 0 || endNumber < 0) {
			System.out.println("Please enter two positive numbers");
			return null;
		} else {
			System.out.println("Invalid input.");
			return null;
		}
	}

	private static final void calculateInput() throws NumberFormatException,
			IOException {
		BufferedReader firstNumberReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.print("Enter the first number: ");
		int startNumber = Integer.parseInt(firstNumberReader.readLine());

		BufferedReader secondNumberReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.print("Enter the second number: ");
		int endNumber = Integer.parseInt(secondNumberReader.readLine());
		long start = System.currentTimeMillis();
		System.out.print("The prime numbers between " + startNumber + " and "
				+ endNumber + " are ");

		System.out.println(intervalOfPrimes(startNumber, endNumber));
		System.out.println(System.currentTimeMillis() - start);

	}

	public static final void main(String[] args) throws IOException {
		
		calculateInput();

	}
}
