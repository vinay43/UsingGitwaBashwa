package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover
{
	WebDriver firefox;
	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver firefox = new FirefoxDriver();	
		firefox.manage().window().maximize();
		firefox.get("https://www.amazon.in/?ref=gw_intl_in&pf_rd_p=4c740c5e-7140-40f3-8386-f749c0cf29ca&pf_rd_r=1YY95ZQW06N9HHZD8CB6");
		firefox.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		WebElement ele=firefox.findElement(By.xpath("//span[text()='Category']"));
		
		
		Actions mousehover=new Actions(firefox);
		mousehover.moveToElement(ele).perform();
		
		Thread.sleep(5000);
		WebElement keb=firefox.findElement(By.xpath("//span[text()='Kindle eReaders & eBooks']"));
		mousehover.moveToElement(keb).perform();
		
		
		Thread.sleep(5000);
		WebElement kpw=firefox.findElement(By.xpath("//span[text()='Kindle Paperwhite']"));
		mousehover.moveToElement(kpw).perform();
		kpw.click();
		
	}

}
