package com.common;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonFunctions {

	clickFunctions cfObj;
	SendKeyFunctions skfObj;;
	FindElement felemObj;
	ExcelUtilities exlObj;
	
	String filePath;
	String fileName;
	String sheetName;
	HashMap<String, String> testdataMap = null;
	List<String> phoneItems;
	
	public HashMap<String, String> getTestdataMap() {
		return testdataMap;
	}
	
	public List<String> getphoneItems() {
		return phoneItems;
	}
	
	public commonFunctions() {
		filePath = "C:\\OCE\\kevin";
		fileName = "testdata.xlsx";
		sheetName = "phones";

		cfObj = new clickFunctions();
		skfObj = new SendKeyFunctions();
		felemObj = new FindElement();
		exlObj = new ExcelUtilities(filePath, fileName, sheetName);
		testdataMap = exlObj.getTestvals();
		phoneItems = exlObj.getPhoneItems();
		
	}
	public boolean clickByIdentifier(WebDriver dr, String identifierType, String identifierVal) {
//		System.out.println(dr);
//		System.out.println(identifierType);
//		System.out.println(identifierVal);
		if(identifierType.equalsIgnoreCase("id")) {
			return cfObj.clickById(dr, identifierVal);			
		}else if(identifierType.equalsIgnoreCase("name")) {
			return cfObj.clickByName(dr, identifierVal);			
		}else if(identifierType.equalsIgnoreCase("linkText")) {
			return cfObj.clickByLinkText(dr, identifierVal);			
		}else if(identifierType.equalsIgnoreCase("partialLinkText")) {
			return cfObj.clickByPartialLinkText(dr, identifierVal);			
		}else if(identifierType.equalsIgnoreCase("xpath")) {
			System.out.println("calling by xpath");
			return cfObj.clickByXpath(dr, identifierVal);					
		}else {
			System.out.println("givien identifier type is not recognized");
			return false;
		}
	}
	
	public boolean sendTextByIdentifier(WebDriver dr, String identifierType, String identifierVal, String inputVal) {
		
		if(felemObj.findElementByIdentifier(dr, identifierType, identifierVal) != null) {
			felemObj.findElementByIdentifier(dr, identifierType, identifierVal).sendKeys(inputVal);
			return true;
		}else {
			System.out.println("givien identifier is not recognized");
			return false;
		}
		
	}
	
	public boolean sendKeysOnlyByIdentifier(WebDriver dr, String identifierType, String identifierVal, Keys keyName) {
			if(felemObj.findElementByIdentifier(dr, identifierType, identifierVal) != null) {
				felemObj.findElementByIdentifier(dr, identifierType, identifierVal).sendKeys(keyName);
				return true;
			}else {
				System.out.println("givien identifier is not recognized");
				return false;
			}
						
	}	
	
	
	public WebElement findElementByIdentifier(WebDriver dr, String identifierType, String identifierVal) {
		if(identifierType.equalsIgnoreCase("id") || identifierType.equalsIgnoreCase("name") 
				|| identifierType.equalsIgnoreCase("xpath")	|| identifierType.equalsIgnoreCase("tagname") 
				|| identifierType.equalsIgnoreCase("linkText") || identifierType.equalsIgnoreCase("partialLinkText")) {
			return felemObj.findElementByIdentifier(dr, identifierType, identifierVal);		
		}else {
			System.out.println("givien identifier type is not recognized");
			return null;
		}
	}
	
	
	public List<WebElement> findElementsListByIdentifier(WebDriver dr, String identifierType, String identifierVal) {
		if(identifierType.equalsIgnoreCase("id")) {
			return felemObj.findElementsListByIdentifier(dr, identifierType, identifierVal);	
		}else if(identifierType.equalsIgnoreCase("name")) {
			return felemObj.findElementsListByIdentifier(dr, identifierType, identifierVal);	
		}else if(identifierType.equalsIgnoreCase("linkText")) {
			return felemObj.findElementsListByIdentifier(dr, identifierType, identifierVal);
		}else if(identifierType.equalsIgnoreCase("partialLinkText")) {
			return felemObj.findElementsListByIdentifier(dr, identifierType, identifierVal);
		}else if(identifierType.equalsIgnoreCase("tagname")) {
			return felemObj.findElementsListByIdentifier(dr, identifierType, identifierVal);		
		}else if(identifierType.equalsIgnoreCase("xpath")) {
			return felemObj.findElementsListByIdentifier(dr, identifierType, identifierVal);			
		}else {
			System.out.println("givien identifier type is not recognized");
			return null;
		}
	}	
	
	
}
