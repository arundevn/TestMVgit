package com.smoketest;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.common.LaunchBrowser;
import com.common.commonFunctions;
import com.pages.DeviceListPage;
import com.pages.HomePage;

public class FlipkartParam {

	WebDriver driver;
	commonFunctions comObj;
	LaunchBrowser lbObj;
	HomePage hpObj;
	DeviceListPage dlObj;
	
	String url = "https://www.flipkart.com/";
	String browserName;
	
	String filePath;
	String fileName;
	String sheetName;
	List<String> inputList;
	HashMap<String, String> localdata;
	
	@BeforeTest
	public void initializeObjs() {
		browserName = "chrome";
		comObj = new commonFunctions();
		lbObj = new LaunchBrowser(browserName);
		driver = lbObj.getWebDriver();
		hpObj = new HomePage(driver);
		dlObj = new DeviceListPage(driver);
		
		filePath = "C:\\OCE\\kevin";
		fileName = "testdata.xlsx";
		sheetName = "phones";
		inputList = comObj.getphoneItems();
		localdata = comObj.getTestdataMap();
		System.out.println(inputList.size());
		for(int i=0; i<inputList.size();i++) {
			System.out.println(inputList.get(i));
		}
		
	}
	
	@BeforeClass
	public void launchUrl() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);			
		
	}
	
	@BeforeMethod
	public void testBefore() {
		System.out.println("  ----------- New Test -----------  ");
	}
	
	@AfterMethod 
	public void testAfter(){
		System.out.println("  -------- Test Completed --------  ");
	}
	

	
	@Test
	public void popupTestinParam() {
		Assert.assertTrue(hpObj.closePopup());
	}
	
	@Test(dependsOnMethods = "popupTestinParam")
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(dependsOnMethods = "verifyTitle")
	public void testPhone() {
		
		for(int i=1; i<inputList.size();i++) {
			
			Assert.assertTrue(hpObj.searchAnItem(inputList.get(i)));
			System.out.println("Running testPhone test for " + i + " " + inputList.get(i));
			String actualTitle = driver.getTitle();
			String expectedTitle = 	localdata.get(inputList.get(i));
			System.out.println("actualTitle : " + actualTitle);
			System.out.println("expectedTitle : " + expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);


			
			Assert.assertTrue(dlObj.gotoHomePage());
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
