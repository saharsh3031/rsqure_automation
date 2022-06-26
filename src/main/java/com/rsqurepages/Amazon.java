package com.rsqurepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.Automation.BaseClass;

public class Amazon extends BaseClass {
	
	public By searchDropDown = By.id("searchDropdownBox");
	
	public By searchBox = By.id("twotabsearchtextbox");
	
	public By addCart = By.id("add-to-cart-button");
	
	

//	@FindBy(id = "twotabsearchtextbox")
//	public WebElement searchBox;

	public By searchButton = By.id("nav-search-submit-button");

	public Amazon() {

		PageFactory.initElements(driver, this);
	}

}
