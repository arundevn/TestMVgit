package com.smoketest;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.common.LaunchBrowser;
//import com.common.commonFunctions;
import com.pages.DeviceListPage;
import com.pages.HomePage;


public class Flipkart {
	WebDriver driver;
	LaunchBrowser lbObj;
	String url = "https://www.flipkart.com/";
//	commonFunctions objCommon;
	HomePage hpObj;
	DeviceListPage dlObj;
	String searchItem = "iphone";
	
	@BeforeTest
	public void initializeDriver() {
		String browserName = "chrome";
		lbObj = new LaunchBrowser(browserName);
		driver = lbObj.getWebDriver();
	}

	@BeforeClass
	public void launchUrl() {
		System.out.println("launching url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("url launched");
//		objCommon = new commonFunctions();
		hpObj = new HomePage(driver);
		dlObj = new DeviceListPage(driver);
		
	}
	
	@BeforeMethod()
	public void messagePrintBeforeTest() {
//		System.out.println("initiating new test");
	}
	
	@AfterMethod()
	public void messagePrintAfterTest() {
		System.out.println("the previous test completed");
	}
	
	@Test(priority = 1)
	public void verifyTitle() {
		System.out.println("checking to see ===================== 66666666666 ************");
		Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 2)
	public void closePopupTest() {
		Assert.assertTrue(hpObj.closePopup());

	}
	
	@Test(priority = 3)
	public void linkTest() {
		Assert.assertTrue(hpObj.linkcount().size()>0);
	}
	
	@Test(priority = 4)
	public void searchItemTest() {
		if(hpObj.searchAnItem(searchItem)) {
			try {
				Thread.sleep(2000);
				Assert.assertEquals(driver.getTitle(), "Iphone - Buy Products Online at Best Price in India - All Categories | Flipkart.com");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority = 5)
	public void sortItems() {
		Assert.assertTrue(dlObj.sortItems());
	}
	
	
	@Test(dependsOnMethods = "sortItems")
	public void sortByAvailabilityTest() {
		Assert.assertTrue(dlObj.sortByAvailability());
	}
	
	
//	public void linkTestt() {
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		liList = driver.findElements(By.tagName("a"));
//		System.out.println("number of a tags are :" + liList.size());
//		liList.addAll(driver.findElements(By.tagName("img")));
//		System.out.println("number of a & img tags are :" + liList.size());	
//		for(WebElement li : liList) {
//			System.out.println(li.getAttribute("href"));
//			if(!li.getAttribute("href").equals(null)) {
//				System.out.println("good");
//				hrList.add(li);
//				System.out.println(hrList.size());
//			}
//		}
//		
//	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
}
