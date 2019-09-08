package com.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class clickFunctions {

	public boolean clickByXpath(WebDriver dr, String xpath) {
			try {
//				System.out.println("calling inner xpath fn");
//				System.out.println("driver here is " + dr);
				dr.findElement(By.xpath(xpath)).click();
			}catch(Exception e){
				e.printStackTrace();
				return false;				
			}			
		
		return true;
	}
	
	public boolean clickById(WebDriver dr, String id) {
			try {
				dr.findElement(By.id(id)).click();
			}catch(NoSuchElementException e){
				e.printStackTrace();
				return false;				
			}			
		
		return true;
	}
	
	public boolean clickByName(WebDriver dr, String name) {

			try {
				dr.findElement(By.name(name)).click();
			}catch(NoSuchElementException e){
				e.printStackTrace();
				return false;				
			}			
		
		return true;
	}
	
	public boolean clickByClass(WebDriver dr, String classnam) {
			try {
				dr.findElement(By.className(classnam)).click();
			}catch(NoSuchElementException e){
				e.printStackTrace();
				return false;				
			}			
		
		return true;
	}
	
	public boolean clickByLinkText(WebDriver dr, String linkText) {
			try {
				dr.findElement(By.linkText(linkText)).click();
			}catch(NoSuchElementException e){
				e.printStackTrace();
				return false;				
			}			

		return true;
	}
	
	public boolean clickByPartialLinkText(WebDriver dr, String plinkText) {
			try {
				dr.findElement(By.name(plinkText)).click();
			}catch(NoSuchElementException e){
				e.printStackTrace();
				return false;				
			}			
	
		return true;
	}
}
