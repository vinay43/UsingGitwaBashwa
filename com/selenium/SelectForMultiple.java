package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectForMultiple {

	public static void main(String[] args) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
		WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement item3 = driver.findElementByXPath("//ol[@id='selectable']/li[3]");
		WebElement item2 = driver.findElementByXPath("//ol[@id='selectable']/li[2]");
		WebElement item4 = driver.findElementByXPath("//ol[@id='selectable']/li[4]");
		WebElement item5 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']/li[7]");
		Actions select = new Actions(driver);
	
		//Select required item
	//	select.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).click(item7).perform();
		
		//select from item1 to item4
	//	select.clickAndHold(item1).release(item4).perform();
		
	//	driver.switchTo().defaultContent();
		
		//RightClick
		
	//	select.contextClick(driver.findElementByLinkText("Development")).perform();
		
		driver.findElementByLinkText("Sortable").click();
		
		
		//Sortable
		WebElement itemsort1 = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		
		WebElement itemsort2 = driver.findElementByXPath("//ul[@id='sortable']/li[2]");
		
		int y = driver.findElementByXPath("//ul[@id='sortable']/li[2]").getLocation().getY();

		
		select.dragAndDropBy(item1, 0, y).perform();

		
		
		
	}

}
