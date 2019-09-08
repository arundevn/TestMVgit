package com.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {

	WebDriver driver;
	WebElement element;
	
	public WebElement findElementByIdentifier(WebDriver dr, String identifierType, String identifierVal) {
//		System.out.println(dr);
		
//		WebDriverWait wait = new WebDriverWait(driver, 15);		
//		try {
//			if(identifierType.equalsIgnoreCase("id")) {
//				return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifierVal)));			
////				dr.findElement(By.id(identifierVal));			
//			}else if(identifierType.equalsIgnoreCase("name")) {
//				return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(identifierVal)));			
//			}else if(identifierType.equalsIgnoreCase("linkText")) {
//				return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(identifierVal)));
//			}else if(identifierType.equalsIgnoreCase("partialLinkText")) {
//				return wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(identifierVal)));
//			}else if(identifierType.equalsIgnoreCase("tagName")) {
//				return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(identifierVal)));
//			}else if(identifierType.equalsIgnoreCase("xpath")) {
////				System.out.println("finding element by xpath");
//				return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifierVal)));
//			}else {
//				System.out.println("givien identifier type is not recognized");
//				return null;
//			}
//			
//		} catch (Exception e) {
//			System.out.println("some error ocurred while trying to identify element");
//			return null;
//		}
		
		
		if(identifierType.equalsIgnoreCase("id")) {
			return dr.findElement(By.id(identifierVal));			
		}else if(identifierType.equalsIgnoreCase("name")) {
			return dr.findElement(By.name(identifierVal));			
		}else if(identifierType.equalsIgnoreCase("linkText")) {
			return dr.findElement(By.linkText(identifierVal));
		}else if(identifierType.equalsIgnoreCase("partialLinkText")) {
			return dr.findElement(By.partialLinkText(identifierVal));
		}else if(identifierType.equalsIgnoreCase("tagName")) {
			return dr.findElement(By.tagName(identifierVal));
		}else if(identifierType.equalsIgnoreCase("xpath")) {
//			System.out.println("finding element by xpath");
			return dr.findElement(By.xpath(identifierVal));
		}else {
			System.out.println("givien identifier type is not recognized");
			return null;
		}
	}
	
	public List<WebElement> findElementsListByIdentifier(WebDriver dr, String identifierType, String identifierVal) {
//		System.out.println(dr);
		if(identifierType.equalsIgnoreCase("id")) {
			return dr.findElements(By.id(identifierVal));			
		}else if(identifierType.equalsIgnoreCase("name")) {
			return dr.findElements(By.name(identifierVal));			
		}else if(identifierType.equalsIgnoreCase("linkText")) {
			return dr.findElements(By.linkText(identifierVal));
		}else if(identifierType.equalsIgnoreCase("tagName")) {
			return dr.findElements(By.tagName(identifierVal));
		}else if(identifierType.equalsIgnoreCase("partialLinkText")) {
			return dr.findElements(By.partialLinkText(identifierVal));
		}else if(identifierType.equalsIgnoreCase("xpath")) {
			System.out.println("finding element by xpath");
			return dr.findElements(By.xpath(identifierVal));
		}else {
			System.out.println("givien identifier type is not recognized");
			return null;
		}
	}
	
}
