package com.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FrameHandling {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		
		
	//	FirefoxDriver driver = new FirefoxDriver();
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
	//	dc.setVersion(version);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.16.2.208:4444/wd/hub/"), dc);
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_frame_cols");
		
		WebElement grandFrame = driver.findElementByXPath("//iframe[@name='iframeResult']");
		driver.switchTo().frame(grandFrame);
		
		
		WebElement parentFrame = driver.findElementByXPath("//frame[@src='frame_a.htm']");
		
		driver.switchTo().frame(parentFrame);
		System.out.println(driver.findElementByXPath("//p[contains(text(),'frame, and noframes elements are not')]").getText());
		
		driver.switchTo().defaultContent();
		
		
		driver.switchTo().frame(grandFrame);
		
		
		
		
		
		
	}

}
