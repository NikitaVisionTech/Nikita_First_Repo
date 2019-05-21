package com.zerobank.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_LoginParaJunk {
	
	//Step 1 Driver
	WebDriver driver;
	
	//Step: Paramatrized constructor
	public PO_LoginParaJunk(WebDriver d) {
		driver = d;
	}
	
	//Elements or Locators
	@FindBy(how = How.NAME,using="username")
	WebElement txtbx_username;
	
	@FindBy(how = How.NAME,using="password")
	WebElement txtbx_password;
	
	@FindBy(how = How.XPATH,using="//input[@value = 'Log In']")
	WebElement btn_submit;
	
	//Methods
	public void SetUserName(String u) {
		try {
			txtbx_username.sendKeys(u);
			Reporter.log("Username set with value as : " + u + " Invoke from method:"
			+ Thread.currentThread().getStackTrace()[1].getMethodName(), true);
		}catch(Exception e) {
			e.printStackTrace();
			Reporter.log("Unable to set user name with value as : u. "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}
	}
	
	public void SetPassword(String u) {
		try {
			txtbx_password.sendKeys(u);
			Reporter.log("Password set with value as : " + u, true);
		}catch(Exception e) {
			e.printStackTrace();
			Reporter.log("Unable to set Password with value as : u. "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}
	}
	
	public void ClickSubmitButton() {
		try {
			btn_submit.click();
			Reporter.log("Submit button Clicked.", true);
			
			//CheckPoint
			String expected = "ParaBank | Accounts Overview";
			String actual = driver.getTitle();
			Assert.assertEquals(expected, actual);
		}catch(Exception e) {
			e.printStackTrace();
			Reporter.log("Unable to Click on Submit Button. "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}
	}
	

	

}
