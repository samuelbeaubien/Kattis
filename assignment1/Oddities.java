package assignment1;
import java.util.Scanner;

public class Oddities {

	public static void main(String[] args)
	{
		givesAnswer(); 
	}
	
	/*
	 * Takes number from System.in
	 * if number is even, return "number" is even
	 * if number is odd, return "number" is odd 
	 * 
	 * @return 
	 */
	
	public static void givesAnswer()
	{
		Scanner sc = new Scanner(System.in);
		int numLines = Integer.parseInt(sc.nextLine());
		String currentLine;
		
		for (int counterLines = 0; counterLines < numLines; counterLines++)
		{
			currentLine = sc.nextLine();
			int currentNumber = Integer.parseInt(currentLine);
			boolean answer = isEven(currentNumber);
			if (answer == true)
			{
				System.out.println(currentNumber + " is " + "even");
			}
			else if (answer == false)
			{
				System.out.println(currentNumber + " is " + "odd");
	
			}
		}
	}
	
	
	
	
	/*
	 * @param pInputNumber
	 * @returns true if pInputNumber is even, false if odd
	 * 
	 */
	public static boolean isEven(int pInputNumber)
	{
		
		int remainder = pInputNumber % 2;
		
		if (Math.abs(remainder) == 1)
		{
			return false;
		}
		
		else {
			return true;
		}
	}
	
}
