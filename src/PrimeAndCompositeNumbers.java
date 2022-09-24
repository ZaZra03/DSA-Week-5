/**
 * This program implements an application that
 * simply calculates if the number is Prime or Composite and
 * prints the output on the screen.
 * 
 * @class PrimeAndCompositeNumbers
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeAndCompositeNumbers {
	//Declaration of static variables
	public static int[] array;
	public static int size;
	public static int prime;
	public static int composite;
	
	/** 
	 * This is the main method which makes use of isPrime method.
	 * @param args Unused.
	 * @throws IOException If an input or output exception occurred.
	 * @return Nothing.
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Try-catch block if the user did not input a number.
		try {
			System.out.print("Enter the size of the array: ");
			size = Integer.parseInt(in.readLine());
			array = new int[size];
			
			//Ask for the user's input and store it in array.
			for (int i = 0; i < array.length; i++) {
				System.out.print("\nEnter a number: ");
				array[i] = Integer.parseInt(in.readLine());
			}
			
			/*Traverse all elements in the array and checks if each elements is Prime using isPrime method.
			  If isPrime method returns false, then the number is composite*/
			for (int i = 0; i < array.length; i++) {
				isPrime(array[i]);
				if (isPrime(array[i]) == true) {
					prime++;
				} 
				else {
					composite++;
				}
			}
			
			if(prime == 1)
				System.out.println("\nThere is " + prime + " prime number.");
			else if(prime > 1)
				System.out.println("\nThere are " + prime + " prime numbers.");
			else if (prime == 0)
				System.out.println("\nThere are no prime numbers.");
			
			
			if(composite == 1)
				System.out.println("\nThere is " + composite + " composite number.");
			else if(composite > 1)
				System.out.println("\nThere are " + composite + " composite numbers.");
			else if (composite == 0)
				System.out.println("\nThere are no composite numbers.");

		} catch(Exception e) {
			System.out.println("\nPlease enter a number.");
			return;
		}
	}
	
	/** 
	 * This method is used to check if the number is prime.
	 * @param numX This is the parameter.
	 * @return boolean This returns true if the number passed all the test.
	 */
	public static boolean isPrime(int numX) {
		//If the number is 1 then the function will return false.
		//If the number is 2 then the function will return true.
		//If the number is even and is greater than 2 then the function will return false.
		if(numX == 1 || numX % 2 == 0 && numX != 2) {
			return false;
		} else {
			/*A loop that iterates until the square root
			of the number for efficiency.*/
			for(int i = 2; i <= Math.sqrt(numX); i++) {
				//To check if the number is odd
				if(i % 2 != 0) {
					/*If the number can be divided by an odd number
					below its square root then it is not prime.*/
					if(numX % i == 0) {
						return false;
					} 
				}
			}
		}
		return true;
	}
}