package com.amazonAutomation;

import org.testng.annotations.Test;

import com.Automation.BaseClass;
import com.Automation.PropertyHandlling;
import com.pageClass.Amazon;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AddMobileInCart extends BaseClass {
	PropertyHandlling prop;
	Amazon amazon;

	@BeforeClass
	@Parameters("browser")
	public void beforeClass() throws IOException {
		amazon = new Amazon();
		prop = new PropertyHandlling();
//		getBrowserInstance(prop.getProperty("browser"));
		getBrowserInstance(prop.getProperty("browser"));
		driver.get(prop.getProperty("amazon"));
	}

	@Test(priority = 1)
	public void mObileData() {
		List<Map<String, Integer>> mobile = new ArrayList<>();

		Map<String, Integer> mobileMap = new HashMap<>();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List<WebElement> mobileDetails = driver
				.findElements(By.xpath("//*[@data-component-type='s-search-result']/descendant::h2//span"));
		IntStream.range(1, mobileDetails.size()).forEach(num -> {
			String mobileName = driver
					.findElement(
							By.xpath("//*[@data-component-type='s-search-result'][" + num + "]/descendant::h2//span"))
					.getText();
			String mobilePrice = driver.findElement(By.xpath("//*[@data-component-type='s-search-result'][" + num
					+ "]/descendant::span[@class='a-price-whole']")).getText().replace(",", "");
			mobileMap.put(mobileName, Integer.parseInt(mobilePrice));
			mobile.add(mobileMap);
		});
		System.out.println(mobile);
	}

	@Test(priority = 2)
	public void searchMobile() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement dropdown = driver.findElement(amazon.searchDropDown);
		Select select = new Select(dropdown);

		select.getFirstSelectedOption();
		driver.findElement(amazon.searchBox).sendKeys("Mobile");

		driver.findElement(amazon.searchButton).click();

		WebElement selectMobile = driver
				.findElement(By.xpath("//*[@data-component-type='s-search-result']/descendant::h2//span"));

		selectMobile.click();
		String parentWindow = driver.getWindowHandle();

		Set<String> windowId = driver.getWindowHandles();

		windowId.forEach(childWindowId -> {

			if (!childWindowId.equals(parentWindow)) {

				driver.switchTo().window(childWindowId);
				System.out.println(childWindowId);
				System.out.println("ProductName:- " + driver.findElement(By.id("productTitle")).getText());

				String price = driver.findElement(By.xpath("//*[@class='a-span12']/span[1]/span[2]")).getText()
						.replace(",", "");
				System.out.println("Product Price:- " + price);
			}
		});
	}

	@Test(priority = 3)
	public void addCart() {
		
		WebElement element1 = driver.findElement(amazon.addCart);
	
		System.out.println("Add mobile into cart");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element1);

		element1.click();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}
}
