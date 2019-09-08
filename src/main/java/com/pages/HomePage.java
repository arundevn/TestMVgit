package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.commonFunctions;

public class HomePage {

	WebDriver driver;
	commonFunctions objCommon;
	String popclosebuttonXpath;
	String searchIconXpath;
	List<WebElement> urlList;
	String urlAtagIdentifier;
	String urlImgtagIdentifier;
	String searchBoxName;
	String cartXpath;
	String filterXpath;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		objCommon = new commonFunctions();
		popclosebuttonXpath = "//button[@class='_2AkmmA _29YdH8']";
		searchIconXpath = "//button[@class='vh79eN']";
		urlAtagIdentifier = "a";
		urlImgtagIdentifier = "img";
		searchBoxName = "q";
		cartXpath = "//span[contains(text(),'Cart')]";
		filterXpath = "//span[contains(text(),'Filters')]";

		
	}
	
	public boolean closePopup() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
			objCommon.clickByIdentifier(driver, "xpath", popclosebuttonXpath);
//			System.out.println("I could reach");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return objCommon.findElementByIdentifier(driver, "xpath", searchIconXpath).isEnabled();
//			return felemObj.findElementByIdentifier(driver, "xpath", searchIconXpath).isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		

	}
	
	public List<WebElement> linkcount() {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		urlList = objCommon.findElementsListByIdentifier(driver, "tagName", urlAtagIdentifier);
		System.out.println("number of a tags are :" + urlList.size());
		urlList.addAll(objCommon.findElementsListByIdentifier(driver, "tagName", urlImgtagIdentifier));
		System.out.println("number of a & img tags are :" + urlList.size());	
		return urlList;
		
//		for(WebElement li : liList) {
//			System.out.println(li.getAttribute("href"));
//			if(!li.getAttribute("href").equals(null)) {
//				System.out.println("good");
//				hrList.add(li);
//				System.out.println(hrList.size());
//			}
//		}
//		
	}
	
	public boolean searchAnItem(String searchItem) {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		objCommon.findElementByIdentifier(driver, "name", searchBoxName);
		if (objCommon.sendTextByIdentifier(driver, "name", searchBoxName, searchItem)) {
			objCommon.sendKeysOnlyByIdentifier(driver, "name", searchBoxName, Keys.ARROW_DOWN);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objCommon.sendKeysOnlyByIdentifier(driver, "name", searchBoxName, Keys.ENTER);
			return objCommon.findElementByIdentifier(driver, "xpath", filterXpath).isDisplayed();
		}else {
			System.out.println("Not able to locate the textbox");
			return false;
		}
		
	}
	
	public boolean gotoCart() {
		objCommon.findElementByIdentifier(driver, "xpath", cartXpath).click();
		try {
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			return driver.getTitle().equalsIgnoreCase("Shopping Cart | Flipkart.com");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
}
