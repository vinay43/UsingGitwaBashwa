package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop 
{
	public static void main(String[] args) throws InterruptedException {
		 
		FirefoxDriver firefox = new FirefoxDriver();
		
		
		 
		 firefox.get("http://demoqa.com/droppable/");
		 
	//	driver.findElement(By.xpath(".//*[@id='box1']")).click();
		 
		WebElement element= firefox.findElement(By.xpath("//div[@id='draggableview']"));
		
		Thread.sleep(2000);
		
		WebElement target= firefox.findElement(By.xpath("//div[@id='droppableview']"));
		
		Thread.sleep(3000);
		
		Actions drag = new Actions(firefox);
		drag.dragAndDrop(element, target).perform();
		
		
//		Actions builder = new Actions(firefox);		 
//		Action dragAndDrop = builder.clickAndHold(element)
//		 
//		.moveToElement(target)
//		 
//		.release(target)
//		 
//		.build();
//		 
//		dragAndDrop.perform();
	}
}
		