package assignment3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/input.txt/");
		Scanner sc = new Scanner(file);
		
		//String x = sc.nextLine();
		//System.out.println(x);
		
		//yolo(sc);
		
		//x = sc.nextLine();
		//System.out.println(x);
		
		int[] yolo = {1,2,3,4,6,7,8,9,10,11};
		
		
		
		int correctIndex = Math.abs(Arrays.binarySearch(yolo, 5)) - 1;
		
		System.out.println(correctIndex);
		
		
	}
	
	public static void yolo(Scanner sc) 
	{
		String y = sc.nextLine();
		System.out.println(y);
		
	}
	
	
}
