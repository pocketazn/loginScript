package loginScript;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class facebookLogin {

	public static void main(String[] args) throws IOException, InterruptedException 
	{

		FileReader freader=new FileReader("exampleUserPassComb.txt"); 
	    BufferedReader br=new BufferedReader(freader);
	    String userPassLine =  null;
		
		
	    /*Reads in each line from the File, parses the string into an array 
	      and compares the Username and Password given to the correct 
	      Username and Password
	     */
	    
	    
	    //create firefox driver
	    WebDriver driver = new FirefoxDriver();
	    
	    //Get Ready to Input given Username and Password Combinations
	    while((userPassLine = br.readLine()) != null)
	    {
	    	String delims = "[ ]+";
	    	String[] userPassArray = userPassLine.split(delims);
			
			//open facebook homepage
			driver.get("http://www.facebook.com");
			
			//Find Username field and enter username
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(userPassArray[0]);
			
			//Find Password field and enter password
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(userPassArray[1]);
			
			//Find LogIn Button and click on it
			driver.findElement(By.id("u_0_o")).click();
	    }
	    br.close();
	    //Close the Driver Window
	    driver.close();
	    
	}
	
}
