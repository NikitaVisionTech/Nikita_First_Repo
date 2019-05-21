package com.zerobank.po;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import core.utils.Utils;

public class PO_TransferFunds {
	WebDriver driver;
	
	public PO_TransferFunds(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Objects
	@FindBy(how = How.ID,using = "tf_fromAccountId")
	private WebElement list_from_account;
	
	@FindBy(how = How.ID,using = "tf_toAccountId")
	private WebElement list_to_account;
	
	@FindBy(how = How.ID,using = "tf_amount")
	private WebElement txtbx_ammount;
	
	@FindBy(how = How.ID,using = "tf_description")
	private WebElement txtbx_description;
	
	@FindBy(how = How.ID,using = "btn_submit")
	private WebElement btn_continue;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Submit']")
	private WebElement btn_submit;
	
	@FindBy(how = How.XPATH,using="//h2[@class='board-header']")
	WebElement txt_success_header;
	
	public void ClickOnSubmit() {
		try {
			
			btn_submit.click();
			Utils.WriteLogs("info","Clickd on Submit Button");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Submit button due to exception: " + e.toString());
		}
	}
	
	public void ClickOnButton() {
		try {
			btn_continue.click();
			Utils.WriteLogs("info","Clickd on Continue Button");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Continue button due to exception: " + e.toString());
		}
	}
	
	
	public void SelectFromAccount(String value) {
		try {
			Select listFromAccount = new Select(list_from_account);
			listFromAccount.selectByValue(value);
			Utils.WriteLogs("info","Selected value as :" + value + " from FromDropDown");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Select value as: '"+ value +"' from FromDropDown: " + e.toString());
		}
	}
	
	public void SelectToAccount(String value) {
		try {
			Select listToAccount = new Select(list_to_account);
			listToAccount.selectByValue(value);
			Utils.WriteLogs("info","Selected value as :" + value + " from ToDropDown");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Select value as: '"+ value +"' from ToDropDown: " + e.toString());
		}
	}
	
	public void SetAmmount(String value) {
		try {
			txtbx_ammount.sendKeys(value);
			Utils.WriteLogs("info","Set Ammount with value as :" + value );
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Set value as: '"+ value +"' in Amount: " + e.toString());
		}
	}
	
	public void SetDescription(String value) {
		try {
			
			txtbx_description.sendKeys(value);
			Utils.WriteLogs("info","Set Description with value as :" + value );
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Set value as: '"+ value +"' in Description: " + e.toString());
		}
	}
	
	public void KW_FillTransferFundsPageAndSubmit(String from, String to,String ammount,String descp) {
		try {
			SelectFromAccount(from);
			SelectToAccount(to);
			SetAmmount(ammount);
			SetDescription(descp);
			ClickOnButton();
			
			//Validation points
			Assert.assertEquals(btn_submit.isDisplayed(),true);
			Assert.assertEquals(list_from_account.isEnabled(), false);
			Utils.WriteLogs("info","Page Navigated to Transfer Funds Verify");
			
			ClickOnSubmit();
			Utils.WriteLogs("pass","Page Navigated to Transfer Funds Verify page");
			
			//Checkpoint to validate the Exepcted Text and values
			String expected = txt_success_header.getText();
			String actual = "Transfer Money & Make Payments - Confirm";
			Assert.assertEquals(actual, expected);
			
			//Checkpoint from ammount
//String xpath = 			"div[@class='span3' and contains(text(),'" + ammount + "')]";
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Fill transsfer funds and Submit page: " + e.toString());
		}
	}
}
