package assignment2;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Uses only the first two letters of the name to sort 
 * If Uppercase, always sorted before the lower case
 * line beginnings with integer (n), then number of input equal to n
 * finishes when n = 0
 * 
 * 1. Get the integer
 * 2. Create ArrayList<Strings>
 * 3. Get the Get first word from input 
 * 4. Call addName to add word 
 * 5. Repeat for all words, 
 * 
 * 6. Continue until n = 0
 * 
 * 
 * Methods : 
 * 
 * public boolean isSmaller(String pInputWord, String pComparedWord)
 * public void addName(String pInputName, ArrayList<String> pInputArrayList)
 * 
 *
 * 
 * 
 * 
 */


public class sortofsorting_260691877 {

	public static void main(String[] args) throws FileNotFoundException
	{
		executeProgram();
	}
	
	/*
	 * @ This method get the input from Stdin and execute program
	 * @ Takes no argument 
	 */
	
	public static void executeProgram() throws FileNotFoundException
	{
		//File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/inputNames.txt/");
		//Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		// One iteration is on set of word sorted and printed
		for (int numExpressions = Integer.parseInt(sc.nextLine());; numExpressions = Integer.parseInt(sc.nextLine()) )
		{
			// Stop if the new n is zero (mean end)
			if (numExpressions == 0)
			{
				return;
			}
			
			ArrayList<String> outputList = new ArrayList<String>();
			// Each iteration adds a new string in outputList is sortd order 
			for (int counterExpression = 0; counterExpression < numExpressions; counterExpression++)
			{
				String currentString = sc.nextLine();
				addName(currentString, outputList);
			}
			
			//Print all the elements of outputList
			for (int counterOutputList = 0; counterOutputList < outputList.size(); counterOutputList++)
			{
				System.out.println(outputList.get(counterOutputList));
			}
			System.out.println();
		}
		
	}
	
	
	/*
	 * @ This method add a string in its "sorted" position in an ArrayList of Strings
	 * @ Takes a (1) String and a (2) arrayList
	 */
	public static void addName(String pInputName, ArrayList<String> pInputList)
	{
		// At each iteration, check if pInputName is smaller than current String, if yes, add at this position 
		for (int indexArrayList = 0; indexArrayList < pInputList.size(); indexArrayList++)
		{
			String currentString = pInputList.get(indexArrayList);
			if (isSmaller(pInputName, currentString))
			{
				pInputList.add(indexArrayList, pInputName);
				return ;
			}
		}
		pInputList.add(pInputName);
	}
	
	
	
	
	
	
	/*
	 * @ This method compares two strings, and return true if the first string is smaller than the second one
	 * 		It only compares the strings based on the first two characters
	 * @ First argument is String pInputWord, Second is pCompareWord 
	 * 
	 */
	public static boolean isSmaller(String pInputWord, String pComparedWord)
	{
		// First check if the input is smaller than compared	
		if (pInputWord.charAt(0) < pComparedWord.charAt(0))
		{
			// if true, input is smaller than compared
			return true;
		}
		// Else, check if input is equal to compared
		if (pInputWord.charAt(0) == pComparedWord.charAt(0))
		{
			// is yes, check if input second character is smaller than compared
			if (pInputWord.charAt(1) < pComparedWord.charAt(1))
			{
				// if yes, input is smaller than compared
				return true; 
			}
			else 
			{
				return false;
			}
		}
		return false;
	}
	
	
	
	
	
}
