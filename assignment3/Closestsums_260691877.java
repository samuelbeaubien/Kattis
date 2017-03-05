package assignment3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Closestsums_260691877 {

	public static void main(String[] args) throws FileNotFoundException
	{
		execute();
		
	}
	
	
public static void execute() throws FileNotFoundException
{
	// Scanner
	//File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/input.txt/");
	//Scanner sc = new Scanner(file);
	Scanner sc = new Scanner(System.in);
	
	// Stops at end of input
	for (int currentCase = 1; sc.hasNextLine(); currentCase++)
	{
		System.out.println("Case " + currentCase + ":");
		solveOneCase(sc);	
	}
	 	
}

/*
 * Solve one case (a.k.a get value, sort, print answer)
 * 
 * @param sc: scanner to the file/ Stdin
 */


public static void solveOneCase(Scanner sc)
{
	int numIntegers = Integer.parseInt(sc.nextLine());	// Get number of inputs
	int[] arrayInput = new int[numIntegers];			// stores the inputs
	int numSums = (((int) Math.pow((numIntegers-1), 2)) + (numIntegers -1))/2;	
	int[] arraySums = new int[numSums];		// stores the sums calculated from the inputs
	int indexArraySums = 0;		// know where to add value in arraySums
	
	// Each iteration get one more number from the input and calculates the sums
	for (int counter_input = 0; counter_input < numIntegers; counter_input++)
	{
		int currentInput = Integer.parseInt(sc.nextLine());
		arrayInput[counter_input] = currentInput;
		
		// Each iteration calculates one more sum
		for (int counter_arrayIntegers = counter_input; counter_arrayIntegers != 0; counter_arrayIntegers--)
		{
			arraySums[indexArraySums] = currentInput + arrayInput[counter_arrayIntegers -1];
			indexArraySums++;
		}
	}
	// Sort the array
	Arrays.sort(arraySums, 0, indexArraySums);
	
	//Get number of test cases
	int numQuery = Integer.parseInt(sc.nextLine());
	
	for (int counter_query = 0; counter_query < numQuery; counter_query++)
	{
		int currentQuery = Integer.parseInt(sc.nextLine()); 
		
		System.out.print("Closest sum to " + currentQuery + " is ");
		
		int indexSum = Arrays.binarySearch(arraySums, currentQuery);	// Get the sum, or the closest in the array
		
		if (indexSum >= 0)
		{
			System.out.println(arraySums[indexSum] + ".");
		}
		
		else
		{
			int upPossibleIndex = Math.abs(indexSum) - 1;
			int downPossibleIndex = upPossibleIndex -1; 
			
			if (upPossibleIndex == 0)
			{
				System.out.println(arraySums[upPossibleIndex] + ".");
				continue;
			}
			
			else if (downPossibleIndex == indexArraySums - 1)
			{
				System.out.println(arraySums[downPossibleIndex] + ".");
				continue;
			}
			
			else if (Math.abs(currentQuery - arraySums[upPossibleIndex]) < Math.abs(currentQuery - arraySums[downPossibleIndex]))
			{
				System.out.println(arraySums[upPossibleIndex] + ".");
				continue;
			}
			
			else 
			{
				System.out.println(arraySums[downPossibleIndex] + ".");
				continue;
			}
		}
		
		
	}
	
	
	
	
	
	
}
	



public static void binarySearch()
{
	
	
	
}
	
	
}
