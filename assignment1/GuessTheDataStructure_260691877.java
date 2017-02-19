package assignment1;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.lang.NullPointerException;
import java.util.PriorityQueue;
import java.util.Collections;


public class GuessTheDataStructure {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		giveGuesses();
	}
	
	
	
	public static void giveGuesses() throws FileNotFoundException
	{
		// Prepare scanner
		//File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/input.txt/");
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine() == true)
		{
			ArrayList<ArrayList<Integer>> inputData = getOneInput(sc);
			boolean isItQueue = isQueue(inputData);
			boolean isItPriorityQueue = isPriorityQueue(inputData);
			boolean isItStack = isStack(inputData);
			int totalTrue = 0;
			
			if (isItPriorityQueue == true)
			{
				totalTrue++;
			}
			if (isItQueue == true)
			{
				totalTrue++;
			}
			if (isItStack == true)
			{
				totalTrue++;
			}
			
			if (totalTrue > 1)
			{
				System.out.println("not sure");
			}
			else if (totalTrue == 0)
			{
				System.out.println("impossible");
			}
			else if (isItPriorityQueue == true)
			{
				System.out.println("priority queue");
			}
			else if (isItQueue == true)
			{
				System.out.println("queue");
			}
			else if (isItStack == true)
			{
				System.out.println("stack");
			}
		}
		sc.close();
	}
	
	/*
	 * @param 2D ArrayList<Integer>, the inner arrays have only 2 elements, the first element of 
	 * the inner array defines the operation on the queue (1 = push, 2 = pull)
	 * @return true if Stack, false if not
	 */
	public static boolean isStack(ArrayList<ArrayList<Integer>> inputDoubleArrayList)
	{
		try 
		{
			int sizeList = inputDoubleArrayList.size();
			LinkedList<Integer> stack = new LinkedList<Integer>();

			// Loop go over each inner array of inputDoubleArrayList
			// if inner array's first element is 1, push, if 2, push and compare with second element 
			for (int counterInputDoubleArray = 0; counterInputDoubleArray < sizeList; counterInputDoubleArray++)
			{
				int firstElement = inputDoubleArrayList.get(counterInputDoubleArray).get(0);
				// Push
				if (firstElement == 1)
				{
					stack.add(inputDoubleArrayList.get(counterInputDoubleArray).get(1));
				}
				if (firstElement == 2)
				{
					int supposedElement = inputDoubleArrayList.get(counterInputDoubleArray).get(1);
					int realElement = stack.pollLast();	
					if (supposedElement != realElement)
					{
						return false;
					}
				}
			}
			return true;
		}	
		
		catch (NullPointerException error)
		{
			return false;
		}
	}
	
	/*
	 * @param 2D ArrayList<Integer>, the inner arrays have only 2 elements, the first element of 
	 * the inner array defines the operation on the queue (1 = enqueue, 2 = dequeue)
	 * @return true if priority queue, false if not
	 */
	public static boolean isPriorityQueue(ArrayList<ArrayList<Integer>> inputDoubleArrayList)
	{
		try 
		{
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(20, Collections.reverseOrder());
			int sizeArray = inputDoubleArrayList.size();

			// Loop go over each inner array of inputDoubleArrayList
			// if inner array's first element is 1, enqueue, if 2, dequeue and compare with second element 
			for (int counterDoubleArrayList = 0; counterDoubleArrayList < sizeArray; counterDoubleArrayList++)
			{
				int currentOperation = inputDoubleArrayList.get(counterDoubleArrayList).get(0);
				int supposedValue = inputDoubleArrayList.get(counterDoubleArrayList).get(1);
				if (currentOperation == 1)
				{
					priorityQueue.add(supposedValue);
				}
				if (currentOperation == 2 )
				{
					if (supposedValue != priorityQueue.poll())
					{
						return false;
					}
				}
			}
			return true;
		}

		catch (NullPointerException error)
		{
			return false;
		}
	}
	
	
	/*
	 * @param 2D ArrayList<Integer>, the inner arrays have only 2 elements, the first element of 
	 * the inner array defines the operation on the queue (1 = enqueue, 2 = dequeue)
	 * @return true if queue, false if not queue 
	 */
	public static boolean isQueue(ArrayList<ArrayList<Integer>> inputDoubleArrayList) throws NullPointerException
	{
		try 
		{
			int sizeList = inputDoubleArrayList.size();
			LinkedList<Integer> queue = new LinkedList<Integer>();

			// Loop go over each inner array of inputDoubleArrayList
			// if inner array's first element is 1, enqueue, if 2, dequeue and compare with second element 
			for (int counterInputDoubleArray = 0; counterInputDoubleArray < sizeList; counterInputDoubleArray++)
			{
				int firstElement = inputDoubleArrayList.get(counterInputDoubleArray).get(0);
				// Enqueue
				if (firstElement == 1)
				{
					queue.add(inputDoubleArrayList.get(counterInputDoubleArray).get(1));
				}
				if (firstElement == 2)
				{
					int supposedElement = inputDoubleArrayList.get(counterInputDoubleArray).get(1);
					int realElement = queue.pollFirst();
					if (supposedElement != realElement)
					{
						return false;
					}
				}
			}
			return true;
		}	
		
		catch (NullPointerException error)
		{
			return false;
		}
	}
	
	/*
	 * @param get input from standard in 
	 * @return 2D arrayList of integer. Size = first number in System.in. Each inner array is size 2 
	 * 	
	 */
	public static ArrayList<ArrayList<Integer>> getOneInput(Scanner sc) throws FileNotFoundException
	{
		
		// Get first line, should be an integer equal to number of element in input.
		String numCommandsString = sc.nextLine();
		int numCommands = Integer.parseInt(numCommandsString);
				
		// Loop over input until numCommands is reached
		ArrayList<ArrayList<Integer>> inputList = new ArrayList<ArrayList<Integer>>();
		for (int counterInput = 0; counterInput < numCommands ; counterInput++)
		{
			String currentLine = sc.nextLine();
			inputList.add(separateString(currentLine));
		}

		return inputList;
	}
	
	
	/*
	 * @param pInputString, a string containing a white space 
	 * @return an ArrayList<Integer> of the pInputString split, with each item transformed to a string
	 */
	public static ArrayList<Integer> separateString(String pInputString)
	{
		ArrayList<Integer> outputArray = new ArrayList<Integer>();
		String[] stringArray = pInputString.split("\\s+");
		for (int counter = 0; counter < stringArray.length ; counter++)
		{
			int currentInt = Integer.parseInt(stringArray[counter]);
			outputArray.add(currentInt);
		}
		return outputArray;
	}
	
	
	
}
