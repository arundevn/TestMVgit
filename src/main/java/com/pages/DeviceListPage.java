package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.common.commonFunctions;

public class DeviceListPage {

	WebDriver driver;
	String sortCriteriaXpath;
	String sortRelevanceXpath;
	String sortCriteriaAfterClickXpath;
	String sortColorAfterCLick;
	String availabilityXpath; 
	String excludeXpath;
	String clearAllXpath;
	String homeXpath;
	
	
	com.common.commonFunctions objCom;
	
	public DeviceListPage(WebDriver driver) {
		this.driver = driver;		
		objCom = new commonFunctions();
		sortCriteriaXpath = "//div[@class='_1xHtJz' and contains(text(),'Popularity')]";
		sortCriteriaAfterClickXpath = "//div[@class='_1xHtJz xufquN'and contains(text(),'Popularity')]";
		sortRelevanceXpath = "//div[@class='_1xHtJz' and contains(text(),'Relevance')]";
		availabilityXpath = "//section[@class='_1gjf4c D_NGuZ']/div[@class='_3xglSm _1iMC4O']/div[@class='_2yccxO D0YrLF' and contains(text(),'Availability')]";
		sortColorAfterCLick = "rgba(40, 116, 240, 1)";
		excludeXpath = "//div[@class='_1GEhLw' and contains(text(),'Exclude Out of Stock')]";
		clearAllXpath = "//span[contains(text(),'Clear all')]";
		homeXpath = "//a[@href='/']/img[@title='Flipkart']";
	}
	
//	public boolean sortItems() {
	public boolean sortItems() {
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		System.out.println("driver here sortItems : " + driver);
		objCom.findElementByIdentifier(driver, "xpath", sortCriteriaXpath).click();
		
		return objCom.findElementByIdentifier(driver, "xpath", sortCriteriaAfterClickXpath).getCssValue("color").equalsIgnoreCase(sortColorAfterCLick);
//		System.out.println("Popularity is selected " + objCom.findElementByIdentifier(driver, "xpath", sortCriteriaXpath).isSelected());
//		System.out.println("Popularity is enabled " + objCom.findElementByIdentifier(driver, "xpath", sortCriteriaXpath).isEnabled());	
//		System.out.println("Relevance is selected " + objCom.findElementByIdentifier(driver, "xpath", sortRelevanceXpath).isSelected());
//		System.out.println("Relevance is enabled " + objCom.findElementByIdentifier(driver, "xpath", sortRelevanceXpath).isEnabled());
//		System.out.println("Popularity color is " + objCom.findElementByIdentifier(driver, "xpath", sortCriteriaAfterClickXpath).getCssValue("color"));
//		System.out.println("Relevance color is " + objCom.findElementByIdentifier(driver, "xpath", sortRelevanceXpath).getCssValue("color"));
				
	}
	
	
	public boolean sortByAvailability() {
		
		objCom.findElementByIdentifier(driver, "xpath", availabilityXpath).click();
		objCom.findElementByIdentifier(driver, "xpath", excludeXpath).click();
		return objCom.findElementByIdentifier(driver, "xpath", clearAllXpath).isEnabled();		
		
	}
	
	public boolean gotoHomePage() {
		driver.manage().timeouts().pageLoadTimeout(9, TimeUnit.SECONDS);
		return objCom.clickByIdentifier(driver, "xpath", homeXpath);
		
	}
	
}
