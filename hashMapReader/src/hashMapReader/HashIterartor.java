package hashMapReader;
/**
* The Hash Iterator Application creates HashMap, insert key and values, and prints them. 
* The output is the map key and value.
* 
*
* @author  Nisreen Hassan
* @since   10/11/2021
* @For     Revature LLC -  OnBoarding Activity
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashIterartor 
{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m	";
	public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args) 
	{
		System.out.println(ANSI_GREEN+"--------------------------");
        System.out.println(ANSI_GREEN+ "Welcome to HashMap App"+ ANSI_RESET);
        System.out.println(ANSI_GREEN+"-------------------------- \n");

        Map<Integer, String> certName = new HashMap<Integer, String>();
 
        certName.put(1, "AWS Certified Developer");
        certName.put(2, "Spring Professional");
        certName.put(3, "Oracle Certified Associate");
        certName.put(4, "AWS Certified Cloud");
        certName.put(5, "AWS Database Architect");

        
        // Advanced for loop Printing
        System.out.println(ANSI_YELLOW+"******************  Advanced for loop Printing ************"+ANSI_RESET);
        for (Map.Entry<Integer, String> set :certName.entrySet()) 
        {
            System.out.println(ANSI_RED+set.getKey() + " : " + set.getValue()+ANSI_RESET);
        }
        
        // While loop Printing 
        System.out.println(ANSI_YELLOW+" \n******************  While loop Printing *******************"+ANSI_RESET);
        Iterator<Entry<Integer, String> > new_Iterator = certName.entrySet().iterator();
 
        while (new_Iterator.hasNext()) 
        {
            Map.Entry<Integer, String> new_Map = (Map.Entry<Integer, String>) new_Iterator.next();
            System.out.println(ANSI_BLUE+new_Map.getKey() + " : " + new_Map.getValue()+ANSI_RESET);
        }
	}
}
