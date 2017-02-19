package assignment2;
import java.util.ArrayList;
import java.util.Arrays;

public class test {

	
	public static void main(String[] args)
	{

		//System.out.println("'" + "'");
		
		String u = "hello";
		
		String x = "hello hello hello hello hello";
		
		String s = "" + u.charAt(4);
		String[] z = x.split("\\s+");
		String key = "15432";
		
		System.out.println(z);
		
		ArrayList<String> foo = new ArrayList<String>(Arrays.asList(z));
		
		System.out.println(foo);
		
		//String output = permutationencryption_260691877.mixString(x, key);
		
		//System.out.println(output);
	
		String white = "h h h h h ";
		
		white = white.replaceAll("\\s+","");
		//System.out.println(white);
	}
	
	
}
