package com.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class SendKeyFunctions {

	public boolean enterTextByXpath(WebDriver dr, String xpath, String inputVal) {
		try {
			dr.findElement(By.xpath(xpath)).sendKeys(inputVal);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}

	public boolean enterTextById(WebDriver dr, String id, String inputVal) {
		try {
			dr.findElement(By.id(id)).sendKeys(inputVal);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}
	public boolean enterTextByName(WebDriver dr, String name, String inputVal) {
		try {
			dr.findElement(By.name(name)).sendKeys(inputVal);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}
	public boolean enterTextByTagname(WebDriver dr, String tagname, String inputVal) {
		try {
			dr.findElement(By.tagName(tagname)).sendKeys(inputVal);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}
	
	public boolean sendKeysOnlyByXpath(WebDriver dr, String xpath, Keys keyname) {
		try {
			dr.findElement(By.xpath(xpath)).sendKeys(keyname);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}

	public boolean enterTextById(WebDriver dr, String id, Keys keyname) {
		try {
			dr.findElement(By.id(id)).sendKeys(keyname);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}
	public boolean enterTextByName(WebDriver dr, String name, Keys keyname) {
		try {
			dr.findElement(By.name(name)).sendKeys(keyname);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}
	public boolean enterTextByTagname(WebDriver dr, String tagname, Keys keyname) {
		try {
			dr.findElement(By.tagName(tagname)).sendKeys(keyname);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;				
		}			
	
		return true;
	}
	
	
}
