package com.common;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class LaunchBrowser {

//	LaunchBrowser drvr;
	WebDriver driver;
	

	
	
	public LaunchBrowser(WebDriver dr, String browsername) {
		System.out.println(System.getProperty("user.dir"));
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
			dr = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox") || browsername.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckodriver.exe");
			dr = new ChromeDriver();
		}		
	}
	public LaunchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox") || browsername.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckodriver.exe");
			driver = new ChromeDriver();
		}
		
	}
	

	
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
}
