package stringRotation;
/**
* The String Rotation Application reads two strings from user. The output is the result,
* if rotated or not.
*
* @author  Nisreen Hassan
* @since   10/11/2021
* @For Revature LLC -  OnBoarding Activity
*/
 
import java.util.Scanner;

public class StrRotation 
{
	// define var for console colors.
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m	";
	public static final String ANSI_BLUE = "\u001B[34m"; 
	public static final String ANSI_RESET = "\u001B[0m";
	
	/**
	 * isRotated
	 * @param two strings
	 * @return true(if rotated) or false(if not)
	 */
	static boolean isRotated(String str1, String str2)
	{
	      // merge two strings and check if str2 is part of it 
	      return  ((str1 + str1).indexOf(str2) != -1);
	}
	public static void main(String[] args) 
	{
		System.out.println(ANSI_BLUE+"----------------------------------------");
        System.out.println(ANSI_BLUE+ "Welcome to String Rotation Checker App"+ ANSI_RESET);
        System.out.println(ANSI_BLUE+"---------------------------------------- \n");
		
        Scanner sc = new Scanner(System.in);
		System.out.println(ANSI_GREEN+"Please enter first string:");
		String str1 = sc.nextLine();
		System.out.println(ANSI_GREEN+"Please enter next string:");
        String str2 = sc.nextLine();
        
        if(str1.length() == str2.length())
        	System.out.println(isRotated(str1, str2)? ANSI_BLUE+"rotation :)" : ANSI_RED+"no rotation :(");
        else
        	System.out.println(ANSI_RED+"Sorry, length must be same. Try again");
	 
	}
}
