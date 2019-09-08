package com.smoketest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.common.LaunchBrowser;
import com.pages.HomePage;

public class FlipkartCart {

	HomePage hpObj;
	LaunchBrowser lbObj;
	WebDriver driver;
	String url = "https://www.flipkart.com/";
	
	
	@BeforeTest
	public void InitializeDriver(){
		String broserName = "chrome";
		lbObj = new LaunchBrowser(broserName);
		driver = lbObj.getWebDriver();
	}
	
	@BeforeClass
	public void launchUrl() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(9, TimeUnit.SECONDS);
		hpObj = new HomePage(driver);
	}
	
	
	@Test
	public void getTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(dependsOnMethods = "getTitleTest")
	public void closePopupTest() {
		Assert.assertTrue(hpObj.closePopup());

	}
	
	@Test(dependsOnMethods = "closePopupTest")
	public void clickCartTest() {
		Assert.assertTrue(hpObj.gotoCart());
	}
	
}
