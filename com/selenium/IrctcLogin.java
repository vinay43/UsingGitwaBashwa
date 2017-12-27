package com.selenium;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.commands.FireEvent;

import selenium.utility.SeleniumUtiltiy;

public class IrctcLogin{
	
	public static void main(String[] args) {
		SeleniumUtiltiy utility = new SeleniumUtiltiy();
		utility.launchBrowserAndApp("firefox", "https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		utility.textBoxHandling("xpath", "//input[@id='usernameId']", "vinay");
		utility.buttonHandling("xpath", "//*[@id='loginbutton']");
	
		
		String alerttext=utility.alertHandling("ok");
		System.out.println(alerttext);
	}

}
