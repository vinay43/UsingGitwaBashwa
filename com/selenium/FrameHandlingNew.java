package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandlingNew {

	public static void main(String[] args) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		driver.manage().window().maximize();
		driver.findElementByXPath("//button[contains(text(),'Close Me')]").click();
//		driver.findElementByXPath("(//button[contains(text(),'Close Me')])[2]").click();
//
//		driver.switchTo().frame(driver.findElementById("childIframe"));
//		driver.findElementByXPath("//button[contains(text(),'Close Me')]").click();
//		driver.findElementByXPath("(//button[contains(text(),'Close Me')])[2]").click();
//
//		driver.switchTo().defaultContent();

	}

}
