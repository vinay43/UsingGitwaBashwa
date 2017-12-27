package com.selenium;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Set;

import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandleNew {

	public static void main(String[] args) {
		 
		FirefoxDriver driver = new FirefoxDriver();
		//Enter Url
		
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		
		System.out.println(driver.getWindowHandles());
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String eachWind:allWindows){
			
		System.out.println(eachWind);
		
		driver.switchTo().window(eachWind);
	}
		// Store Second Window Title
		String SecondTitle = driver.getTitle();
		System.out.println(SecondTitle);
		
		

		driver.findElementByLinkText("View Offer»").click();
		 allWindows = driver.getWindowHandles();
		 for (String eachWind : allWindows) {
			 System.out.println(eachWind);
			 driver.switchTo().window(eachWind);
			 
			 if(!driver.getTitle().equals(SecondTitle)){
				 driver.close();
			 }
			
		}

		} 
	}



