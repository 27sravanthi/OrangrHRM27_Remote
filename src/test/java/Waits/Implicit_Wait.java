package Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Implicit_Wait {
	
	WebDriver driver;
	
  @Test
  public void Implicit_Login_logout() throws Exception {
	  
	
	  Implicit_Wait IW = new Implicit_Wait();
	  IW.OprnChromeBrowser();
	  IW.OpenOrangeHRMURL();
	  IW.Login();
	  IW.Logout();
	  IW.CloseBrowser();
	  
  }
 public void OprnChromeBrowser() throws Exception {
	  
	  
	 driver=TestBrowser.OpenChromeBrowser();
	 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  
  }
 public void OpenOrangeHRMURL() throws Exception {
	  
	 String TestURL = "https://opensource-demo.orangehrmlive.com/";
	 driver.get(TestURL);
	  
	  
 }
 public void Login() throws Exception{
	 
	 findElement(By.id("txtUsername")).sendKeys("Admin");
	 findElement(By.id("txtPassword")).sendKeys("admin123");
	 findElement(By.id("btnLogin")).click();

 }
 public void Logout() throws Exception{
	  
	  findElement(By.id("welcome")).click();
	  findElement(By.linkText("Logout"));
	  findElement(By.linkText("Logout")).click();
	 	  
	  
 }
 public void CloseBrowser() throws Exception{
	  
	 driver.quit();  
	  
	  
 }
 public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
}
