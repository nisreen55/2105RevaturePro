
package creditCardValidation;
/**
 * Java function to validate Credit Card number.
 * @author Nisreen Hassan
  */
import java.util.Scanner;
import java.awt.*;

public class CardValidation 
{
	/** Gets Credit Card number from user.
	 * @return boolean represents if card is passed validation process or not
	*/
	public static boolean isValidCreditNum(String crNum)
	{
		boolean res = false;
		String strNum = crNum;
		int lastDigit = 0;
		int sum = 0;
		int[] numArr = new int[strNum.length()];
		int[] revArr = new int[strNum.length()-1];

		// spread string into int array	
		 System.out.println("Printing original digits");
		 for(int i = 0; i < strNum.length()-1; i++)
		 {
			 numArr[i] = Character.getNumericValue(strNum.charAt(i));
			 System.out.print(numArr[i]);
		 }
		 System.out.println("\n---------------------");

		 //step 1: put last digit into var
		 lastDigit = Character.getNumericValue(strNum.charAt(strNum.length()-1));
		       
      	 //step 2: reverse digits
		 System.out.println("Printing reversed digits");
      	 for(int i = numArr.length-2, k =0; i >= 0; i--)
      	 {
      		revArr[k++] = numArr[i];
      		System.out.print(numArr[i]);
      	 }
		 System.out.println("\n---------------------");

      	//step 3: double odd digits
		System.out.println("Printing doubled digits");
    	for(int i = 0; i < revArr.length; i++)
    	{
    		if(i % 2 == 0)
    		{
    			int n = revArr[i] * 2;
    			if(n > 9)
    				revArr[i] = n % 10 + n /10;
    			else
    				revArr[i] = n;
    		}
    		//else
    			//dArr[i] = revArr[i];
    		System.out.print(revArr[i]);
    	}
		 System.out.println("\n---------------------");

    	
  		 System.out.println("last digit is: " + lastDigit);
  		 
  		for(int i = 0; i < revArr.length; i++)
   		 sum = sum +revArr[i];
 		 System.out.println("Sum of digit is: " + sum);

  		int sub = sum > 10 ? 10 - sum %10 : 10 - sum;
 		System.out.println("Encoded digit is: " + sub);

 		res = sub == lastDigit;
		return res;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("**************************************************");
		System.out.println("Please inter your credit card number:");
		System.out.println("**************************************************");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if(input.length() >= 14 && input.length() <= 19 )
		{
			System.out.println("Processing validation in progress......");
			System.out.println(isValidCreditNum(input)? "Validation is completed successfully" : "Wrong card number!!");
		}
		else
		{
			Toolkit.getDefaultToolkit().beep();
			System.out.println("Sorry, your number should be between 14 and 19 digits ......");
		}
}
}
