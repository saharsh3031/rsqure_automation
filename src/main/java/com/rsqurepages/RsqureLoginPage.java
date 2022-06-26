package com.rsqurepages;

import org.openqa.selenium.By;

public class RsqureLoginPage {
	
	public By username = By.name("email");
	
	public By password = By.name("password");
	
	public By singIn = By.xpath("//*[@type='submit']");

}
