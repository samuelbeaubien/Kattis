package assignment3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Returns the number a letter I have to take out so that the given string is a Paragram
 * 
 * Idea : in a Paragram, each letter comes in a multiple of two, except one. 
 * So, for any word, the number of sums of letters that is un even is at most one. 
 * 	Then return 0
 * Otherwise, return the number of uneven sum - 1 
 * 
 * 1. Get the string 
 * 2. For each letters in the string, add 1 to it's respective position in an int[] of size 26 (number of chars)
 * 3. Go over all the letters and check if sum is uneven
 * 4. if sum uneven == 0, return 1
 * 	  if sum uneven == 1, return 0
 *    if sum uneven > 1 , return sumUneven - 1
 * 
 * 	No uppercase letters
 * 
 */

public class Peragrams_260691877 {

	public static void main(String[] args) throws FileNotFoundException
	{
		execute();
		
		
	}
	
	/*
	 * Execute program 
	 * 
	 */
	public static void execute() throws FileNotFoundException
	{
		//File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/inputNames.txt/");
		//Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arrayOfSums = new int[26];
		
		// Each iteration add a new char to the Array
		for (int counter = 0; counter < input.length(); counter++)
		{
			includeChar(arrayOfSums, input.charAt(counter));
		}
		
		// Calculate the number of odd counts
		int numOdd = countOdd(arrayOfSums, 26);
		
		if (numOdd == 0)
		{			
			System.out.println(0);
			return;
		}
		
		else if (numOdd == 1)
		{
			System.out.println(0);
			return;
		}
		else if (numOdd > 1)
		{
			System.out.println(numOdd - 1);
		}
	}
	
	
	
	/*
	 * Add +1 to the position of a char in an array (ex a = 0, z = 25)
	 * 
	 * @param pArray, one int in this array will be incremented by one
	 * @param pChar, determines at which position the int will be incremented ( a = 0, z = 25)
	 */
	
	public static void includeChar(int[] pArray, char pChar)
	{
		// Determines the position 
		int currentIndex = pChar - 97;
		
		// Increment 
		pArray[currentIndex] +=1;
	}
	
	
	/* 
	 * Counts the number of odd numbers in an array of size n. 
	 * 
	 * @param pArray, the array
	 * @param pSize, the size of the array
	 * 
	 * @return the number of odd numbers in the array (int)
	 */
	
	public static int countOdd(int[] pArray, int pSize)
	{
		int numOdd = 0;
		
		// Each iteration checks the odditie of a given index
		for (int counter = 0; counter < pSize ; counter++)
		{
			if (pArray[counter] % 2 == 1)
			{
				numOdd++;
			}
		}
		return numOdd;
	}
	
	
	
	
	
	
	
	
	
	
}
