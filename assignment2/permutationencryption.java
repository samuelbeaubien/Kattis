package assignment2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


/*
 * Need to include single quote around message
 * first line is permutation 
 * second line is message 
 * finish with first line being 0
 * 
 * break the string at num char of key
 * inverse string 
 * add to new string 
 * do this until all string is broken down 
 * 
 * inversing sub string 
 * create new string empty
 * go over key 
 * mfor each number, take the index in first setring and append to secon string 
 * 
 * 
 * String mixString(String pInputString, String pKey)
 * 
 * 
 * 
 * 
 */



public class permutationencryption {

 public static void main(String[] args) throws FileNotFoundException
 {
  executeProgram();
 }
 
 public static void executeProgram() throws FileNotFoundException
 {
  //File file = new File("/Users/samuelbeaubien/Documents/workspace/COMP321/src/inputNames.txt/");
  //Scanner sc = new Scanner(file);
  Scanner sc = new Scanner(System.in);
  // Each iteration codes a new line
  for (String currentKey = sc.nextLine();; currentKey = sc.nextLine())
  {
   /*
   // First format the code
   String formattedKey = currentKey.replaceAll("\\s+","");
   // Check if 0 (end of input)
   if ( formattedKey.equals("0"))
   {
    return;
   }
   */
   
   ArrayList<String> listKey = new ArrayList<String>(Arrays.asList(currentKey.split("\\s+")));
   if (listKey.get(0).equals("0"))
   {
    return;
   }
   listKey.remove(0);
   
   // First get the initialString
   String initialString = sc.nextLine();
   String outputString = mixString(initialString, listKey);
   System.out.println("'" + outputString +"'");
  }
 }
 
 /*
  *@Convert a whole string with a key 
  *@ @ Takes (1) String pInputString (2) String pKey
  */
 
 public static String mixString(String pInputString, ArrayList<String> pArrayKey)
 {
  String outputString = "";
  int keyLength = pArrayKey.size();
  int numSubStrings = pInputString.length()/keyLength;
  // First mix the well numbered substrings
  for (int indexStartSub = 0; indexStartSub/keyLength < numSubStrings; indexStartSub = indexStartSub + keyLength)
  {
   String currentSubString = pInputString.substring(indexStartSub, indexStartSub + keyLength);
   outputString = outputString.concat(mixSubString(currentSubString, pArrayKey));
  }
  
  // Than mix the rest 
  if (pInputString.length()%keyLength != 0)
  {
   int indexStartSub = (pInputString.length() - (pInputString.length()%keyLength));  // -1 since it is index 
   String currentSubString;
   if (indexStartSub != pInputString.length()-1)
   {
    currentSubString = pInputString.substring(indexStartSub, pInputString.length());
   }
   else
   {
    currentSubString = "" + pInputString.charAt(indexStartSub);
   }
   
   outputString = outputString + mixSubString(currentSubString, pArrayKey);
  }
  return outputString;
 }
 
 /*
  * @ Mix a string according to the key given as argument
  * @ Takes (1) String pInputString (2) String pKey
  * 
  */
 public static String mixSubString(String pInputString, ArrayList<String> pArrayKey)
 {
  //Make both string same size 
  if (pInputString.length() != pArrayKey.size())
  {
   for (int counter = pArrayKey.size() - pInputString.length(); counter > 0; counter--)
   {
    pInputString = pInputString + " ";
   }
  }
  
  String outputString = ""; 
  for (int counterArrayKey = 0; counterArrayKey < pArrayKey.size(); counterArrayKey++)
  {
   int nextIndex = Integer.parseInt(pArrayKey.get(counterArrayKey));
   outputString = outputString + pInputString.charAt(nextIndex - 1);
  }
  return outputString; 
 }
}
