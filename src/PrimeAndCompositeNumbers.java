import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeAndCompositeNumbers {
	public static int[] array;
	public static int size;
	public static int prime;
	public static int composite;

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("Enter the size of the array: ");
			size = Integer.parseInt(in.readLine());
			array = new int[size];

			for (int i = 0; i < array.length; i++) {
				System.out.print("\nEnter a number: ");
				array[i] = Integer.parseInt(in.readLine());
			}
			for (int i = 0; i < array.length; i++) {
				isPrime(array[i]);
				if (isPrime(array[i]) == true) {
					prime++;
				} else {
					composite++;
				}
			}

			System.out.println("\nThere are " + prime + " prime numbers");
			System.out.println("\nThere are " + composite + " composite numbers");

		} catch(Exception e) {
			System.out.println("\nPlease enter a number.");
			return;
		}
	}	
	
public static boolean isPrime(int n) {
		/*
		 * If the number is 1 then the function will return false 
		 * If the number is 2 then the function will return true 
		 * If the number is even and is greater than 2 then the function will return false
		 */
		if(n == 1 || n % 2 == 0 && n != 2) {
			return false;
		} else {
			//A loop that iterates until the square root
			//of the number for efficiency
			for(int i = 2; i <= Math.sqrt(n); i++) {
				//To check if the number is odd
				if(i%2 != 0) {
					//If the number can be divided by an odd number
					//below its square root then it is not prime
					if(n%i == 0) {
						return false;
					} 
				}
			}
		}
		//Return true as a default if the number passed
		//all the test.
		return true;
	}
}
