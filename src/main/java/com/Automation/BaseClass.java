package com.Automation;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentTest logger;

	public static void getBrowserInstance(String browser) {
		switch (browser) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Java Programs\\Chrome\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "Edge":
//			System.setProperty("webdriver.edge.driver", "C:\\Java Programs\\Chrome\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "IE":
//			System.setProperty("webdriver.ie.driver", "C:\\Java Programs\\Chrome\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Java Programs\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}
	public static void validate(String actual, String expected) throws Exception {
		if (actual.equals(expected)) {
			System.out.println("Succesfully validate " + actual + " in the screen");

		} else {
			throw new Exception("Faild to validate " + actual + "with " + expected);
		}
	}

//	public static String generateRandomString(int count) {
//
//		Random random = new Random();
//
//		return random.ints(65, 90).limit(count)
//				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
//
//	}
	
	public void createFolder(String filepath) {
		File file = new File(filepath);
		
		if(!file.exists()) {
			
			file.mkdir();
			}	
	}
}
