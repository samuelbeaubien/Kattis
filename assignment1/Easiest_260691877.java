package assignment1;
import java.util.Scanner;

public class Easiest {

	
	public static void main(String[] args) //throws ASCIIexception
	{
		printAnswer();
	}
	
	
	
	/** 
	 *
	 * @param takes numbers from System.in  
	 * @return Returns smallestDigit 
	 * Terminate when input fed is 
	 */
	
	
	public static void printAnswer()
	{
		Scanner sc = new Scanner(System.in);
		
		for(String currentLine = sc.nextLine(); currentLine.equals("0") != true; currentLine = sc.nextLine())
		{
			int currentNumber = Integer.parseInt(currentLine);
			int factor = smallestDigit(currentNumber);
			System.out.println(factor);
		}
		
		sc.close();
		
	}
	
	
	
	/*
	 * For argument N, finds the integer n for which the sum of the digits of n*N is equal to N
	 * 
	 * Takes int pInput
	 * Calculates sum of digits of pInput
	 * Initialize loop in which 
	 * 	1. multiply by counter
	 * 	2. calculate sum of digits
	 * 	3. compares with sum of digits of pInput
	 * 	End when step 3 is successful
	 * Return last counter
	 */
	
	public static int smallestDigit(int pInput) //throws ASCIIexception
	{
		
		// calculates sum of digits of pInput
		int originalSumDigits = sumDigits(pInput);
		int finalFactor;
		//Initialize loop
		for (int possibleFactor = 11; ; possibleFactor++)
		{
			int multAnswer = possibleFactor * pInput;
			if (sumDigits(multAnswer) == originalSumDigits)
			{
				finalFactor = possibleFactor;
				break;
			}
		}
		return finalFactor;
	}
	
	/*
	 * Takes an int 
	 * Transforms it in String
	 * Initiate loop that 
	 * 	1. Get individual char
	 * 	2. Transform chars back in int 
	 * 	3. add int together in sum
	 * return sum
	 */
	public static int sumDigits(int pNumInput)// throws ASCIIexception
	{
		
		/*
		// Verifies if user is using ASCII. 
		char testChar = '0';
		int testInt = (int) testChar;  
		if ( (testInt - 48) != 0)
		{
			throw new ASCIIexception("User is not using ASCII");
		}
		*/
		
		int sum = 0;
		
		// Transform pNumber in String		
		String stringNumInput = Integer.toString(pNumInput);
		
		// Initiate loop
		for (int cIndex = 0; cIndex < stringNumInput.length(); cIndex++)
		{
			char currentChar = stringNumInput.charAt(cIndex);	//Get char at cIndex
			int currentInt = ((int) currentChar) - 48;	// Transform char to int
			sum += currentInt;
		}
		return sum;
	}
}

