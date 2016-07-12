package loginScript;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class login 
{

	public static void  main(String[] args) throws IOException
	{
		//Username and Password Combination Accepted by Script
		String username = "exampleUser123$%^";   
		String password = "pass!@$@^{}";
		
		//File to be read as External Data Source containing Username Password Combinations
		//Format is each in line contains Username and Password in that order with space as the delimiter 
		FileReader freader=new FileReader("exampleUserPassComb.txt"); 
	    BufferedReader br=new BufferedReader(freader);
	    String userPassLine =  null;
	    
	    /*Reads in each line from the File, parses the string into an array 
	      and compares the Username and Password given to the correct 
	      Username and Password
	     */
	    while((userPassLine = br.readLine()) != null)
	    {
	    	String delims = "[ ]+";
	    	String[] userPassArray = userPassLine.split(delims);
	    	
	    	//Username is Compared to Attempt
	    	if ( userPassArray[0].equals(username))
	    	{
	    		//Password is Compared to Attempt
	    		if (userPassArray[1].equals(password))
	    		{
	    			//Both Username and Password are Correct
	    			System.out.println("Credentials Excepted");
	    			System.out.println("");
	    		}
	    		else
	    		{
	    			//Username was Correct but Password is incorrect
	    			System.out.println("Username or Password is bad");
	    			System.out.println("");
	    		}
	    	}
	    	else
    		{
	    		//Username was incorrect and that is all that was compared;
	    		System.out.println("Username or Password is bad");
    			System.out.println("");
    		}
	    }
	    br.close();
		
	}
	
}
