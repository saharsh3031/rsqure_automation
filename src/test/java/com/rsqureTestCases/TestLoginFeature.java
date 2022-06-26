package com.rsqureTestCases;

import com.Automation.BaseClass;
import com.Automation.PropertyHandlling;
import com.rsqurepages.Amazon;
import com.rsqurepages.RsqureLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLoginFeature extends BaseClass {

    PropertyHandlling propertyHandlling;
    RsqureLoginPage loginPage;

    @BeforeClass
    public void beforeClass() throws IOException {
        propertyHandlling = new PropertyHandlling();
        loginPage = new RsqureLoginPage();
        getBrowserInstance(propertyHandlling.getProperty("browser"));
        driver.get(propertyHandlling.getProperty("rsqureUrl"));
    }
    @Test
    public void verifyLogin(){
        driver.findElement(loginPage.username).sendKeys(propertyHandlling.getProperty("rsqureUsername"));
        driver.findElement(loginPage.password).sendKeys(propertyHandlling.getProperty("rsqurepassword"));
        driver.findElement(loginPage.singIn).click();
    }
}
