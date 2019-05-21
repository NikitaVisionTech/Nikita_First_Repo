package com.zerobank.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.utils.Utils;

public class PO_Common {
	
	//Step 1 Driver
	WebDriver driver;

	//Step: Paramatrized constructor
	public PO_Common(WebDriver d) {
		driver = d;
	}

	//Elements or Locators
	@FindBy(how = How.LINK_TEXT,using="Transfer Funds")
	WebElement link_transfer_funds;
	
	public void ClickOnTransferFunds() {
		try {
			link_transfer_funds.click();
			Utils.WriteLogs("info","Clicked on Transfer Funds");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Click on Transfer Funds. Exception: " + e.toString());
		}
	}
}
