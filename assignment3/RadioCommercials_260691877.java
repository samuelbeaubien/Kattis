package assignment3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RadioCommercials_260691877 {

	public static void main(String[] args) throws FileNotFoundException
	{
		execute();
		
	}
	
	
	public static void execute()	throws FileNotFoundException
	{
		// Scanner
		//File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/input.txt/");
		//Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		// Get the size and cost
		String input = sc.nextLine();
		String[] splitted = input.split("\\s+");
		int numInput = Integer.parseInt(splitted[0]);
		int cost = Integer.parseInt(splitted[1]);
		
		// Get input 
		input = sc.nextLine();
		splitted = input.split("\\s+");
		
		// transform String[] in int[]
		int[] arrayInput = new int[numInput];
		// Each iteration transforms one String in int and store it into the array (the array contains value - cost for each elements)
		for(int counter_arrayInput = 0; counter_arrayInput < numInput; counter_arrayInput++)
		{
			arrayInput[counter_arrayInput] = Integer.parseInt(splitted[counter_arrayInput]) - cost;
		}
		
		// Merge together the positive and the negative, so arrayMerged is +,-,+,-
		int sizeArrayMerged = 0;
		int[] arrayMerged = new int[numInput];
		
		for (int counter_arrayInput = 0; counter_arrayInput < numInput;)
		{
			int currentInput = arrayInput[counter_arrayInput];
			counter_arrayInput++;	//increment counter
			//check if currentInput is last of the list
			if (counter_arrayInput == numInput)
			{
				arrayMerged[sizeArrayMerged] = currentInput;
				sizeArrayMerged++;
				break;
			}
			// check if nextInput's sign is the same than currentInput if yes, add to current input
			for (int nextInput = arrayInput[counter_arrayInput]; (nextInput*currentInput) >= 0; nextInput = arrayInput[counter_arrayInput] )
			{
				nextInput = arrayInput[counter_arrayInput];
				currentInput += nextInput;
				counter_arrayInput++;
				if (counter_arrayInput == numInput)
				{
					break;
				}
			} // When the for loops ends, the counter_arrayInput points to the next currentInput
			// Add currentInput to arrayMerged
			arrayMerged[sizeArrayMerged] = currentInput;
			sizeArrayMerged++;
		}
		
		// Calculate the biggest profit 
		int biggestProfit = biggestProfit(arrayMerged, sizeArrayMerged);
		
		System.out.println(biggestProfit);
		
	}
	
	/*
	 * Returns the biggest possible profit possible by selecting a continuous amount of integers in an array
	 * 
	 * @param arrayMerged : array of int containing the profit (or lose) for given times. The array in of form (+,-,+,-)
	 * @param sizeArrayMerged : size of the input array
	 * 
	 */
	
	public static int biggestProfit(int[] arrayMerged, int sizeArrayMerged)
	{
		int biggestProfit = 0;
		int indexArray = 0;
		// check if first element is negative. if yes, increment index by one
		if (arrayMerged[indexArray] < 0)
		{
			indexArray++;
		}
		
		int sumValues = 0;
		int currentValue = arrayMerged[indexArray];
		biggestProfit = currentValue;
		
		//set varaibles
		sumValues = currentValue;
		indexArray = indexArray+2;
		// Each iteration checks if adding two value (so one negative and one positive) increases the sum of value
		// We assume that the current value has already been checked
		for (; indexArray < sizeArrayMerged; indexArray = indexArray + 2)
		{
			sumValues = sumValues + arrayMerged[indexArray - 1] + arrayMerged[indexArray];	// add two values to sum
			currentValue = arrayMerged[indexArray];		// get new current value 
			
			if (sumValues > currentValue)
			{
				// Check if the sum is bigger than the biggestValue
				if (sumValues > biggestProfit)
				{
					biggestProfit = sumValues;
				}
				// else just continue
			}
			
			else //  if the sum of values is not bigger than the currentValue, then reset sumValues to currenttSum and restart
			{
				if (currentValue > biggestProfit)
				{
					biggestProfit = currentValue;
					sumValues = currentValue;
				}
				else 
				{
					sumValues = currentValue;
				}
			}
		}
		
		
		return biggestProfit;
	}
	
	
	
	
}
