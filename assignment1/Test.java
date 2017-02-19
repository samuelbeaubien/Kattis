package assignment1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) throws FileNotFoundException
	{
		
	/*
		
	System.out.println("yolo");
	Scanner sc = new Scanner(System.in);
	
	int foo = sc.nextInt();
	
	System.out.println(sc.hasNext());
	
	System.out.println("yolo");
	foo = sc.nextInt();
	
	System.out.println(foo);
	
	
		
		File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/input.txt/");
		
		Scanner sc = new Scanner(file);
		
		for (String foo = sc.nextLine();; foo = sc.nextLine() )
		{
			
			System.out.println(GuessTheDataStructure.separateString(foo));
			
			if (sc.hasNextLine() != true)
			{
				break;
			}
		}
	*/
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(20, Collections.reverseOrder());
		
		queue.add(4);
		queue.add(2);
		
		System.out.println(queue.poll());
		
		
		
		File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/input.txt/");
		Scanner sc = new Scanner(file);
		
		ArrayList<ArrayList<Integer>> foo = GuessTheDataStructure.getOneInput(sc);
		System.out.println("Queue " + GuessTheDataStructure.isQueue(foo));
		System.out.println("Priority queue " + GuessTheDataStructure.isPriorityQueue(foo));
		System.out.println("Stack : " + GuessTheDataStructure.isStack(foo));
		System.out.println(foo);
		
		foo = GuessTheDataStructure.getOneInput(sc);
		System.out.println("Queue " + GuessTheDataStructure.isQueue(foo));
		System.out.println("Priority queue " + GuessTheDataStructure.isPriorityQueue(foo));
		System.out.println("Stack : " + GuessTheDataStructure.isStack(foo));
		System.out.println(foo);
		
		foo = GuessTheDataStructure.getOneInput(sc);
		System.out.println("Queue " + GuessTheDataStructure.isQueue(foo));
		System.out.println("Priority queue " + GuessTheDataStructure.isPriorityQueue(foo));
		System.out.println("Stack : " + GuessTheDataStructure.isStack(foo));
		System.out.println(foo);
		
		foo = GuessTheDataStructure.getOneInput(sc);
		System.out.println("Queue " + GuessTheDataStructure.isQueue(foo));
		System.out.println("Priority queue " + GuessTheDataStructure.isPriorityQueue(foo));
		System.out.println("Stack : " + GuessTheDataStructure.isStack(foo));
		System.out.println(foo);
		
		foo = GuessTheDataStructure.getOneInput(sc);
		System.out.println("Queue " + GuessTheDataStructure.isQueue(foo));
		System.out.println("Priority queue " + GuessTheDataStructure.isPriorityQueue(foo));
		System.out.println("Stack : " + GuessTheDataStructure.isStack(foo));
		System.out.println(foo);
		
		foo = GuessTheDataStructure.getOneInput(sc);
		System.out.println("Queue " + GuessTheDataStructure.isQueue(foo));
		System.out.println("Priority queue " + GuessTheDataStructure.isPriorityQueue(foo));
		System.out.println("Stack : " + GuessTheDataStructure.isStack(foo));
		System.out.println(foo);
	
	}
}

