package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssessmentAutoFill10Page {
	
	public WebDriver driver;
	
	public AssessmentAutoFill10Page(WebDriver driver) {
		this.driver = driver;
	}
	
	// All objects should be defined here
	private By studentName = By.xpath("//input[@class='whsOnd zHQkBf']");
	private By fathersName = By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input");
	
	// All methods should be defined here
	public WebElement getStudentName(){ return driver.findElement(studentName);}
	public WebElement getFathersName(){ return driver.findElement(fathersName);}


}
