package com.selenium;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.gecko.driver", "C:\\softwares\\selenium
		// jars\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// maximize the Browser
		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("DemoSalesManager");
		// Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		Thread.sleep(3000);
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByPartialLinkText("CRM/SF").click();
		Thread.sleep(5000);
		driver.findElementByPartialLinkText("Leads").click();

		// click on merge lead

		driver.findElementByPartialLinkText("Merge Leads").click();

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();
		Thread.sleep(1000);
		System.out.println("the parent window id " + driver.getWindowHandle());
		String parentWindowId = driver.getWindowHandle();

		Set<String> windowsIDs = driver.getWindowHandles();
		System.out.println("the size of set " + windowsIDs.size());

		for (String windowID : windowsIDs) {
			System.out.println(windowID);
			driver.switchTo().window(windowID);
			System.out.println("the current title is " + driver.getTitle());

			if (driver.getTitle().contains("Find Leads")) {
				System.out.println("came to child window");
				// Perform action
				break;

			}
		}
		driver.findElementByLinkText("10050").click();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();

		Set<String> windowsIDtolead = driver.getWindowHandles();
		System.out.println("the size of set " + windowsIDs.size());

		for (String windowIDtolead1 : windowsIDtolead) {
			System.out.println(windowIDtolead1);
			driver.switchTo().window(windowIDtolead1);
			System.out.println("the current title is " + driver.getTitle());

			if (driver.getTitle().contains("Find Leads")) {
				System.out.println("came to child window");
				// Perform action
				break;

			}

		}
		driver.findElementByLinkText("10051").click();
		driver.switchTo().window(parentWindowId);
		
	// write code click on merge
		
		driver.findElementByLinkText("Merge").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
