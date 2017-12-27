package com.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.runners.model.FrameworkField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class Selenium1 {

	WebDriver firefox;

	public static void main(String[] args) throws InterruptedException {

		Selenium1 se = new Selenium1();
		se.CRM();

	}

	public static void CRM() throws InterruptedException {

		// Launch the browser
		FirefoxDriver firefox = new FirefoxDriver();
		Thread.sleep(2000);
		firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter the URL
		firefox.get("http://leaftaps.com/opentaps");
		Thread.sleep(2000);
		// Enter username
		firefox.findElementById("username").sendKeys("DemoSalesManager");
		// Enter password
		firefox.findElementById("password").sendKeys("crmsfa");
		Thread.sleep(3000);
		firefox.findElementByClassName("decorativeSubmit").click();
		// click on CRm, link
		firefox.findElementById("label").click();

		// **************CREATE
		// LEAD***********************************************************

		firefox.findElementByLinkText("Create Lead").click();
		firefox.findElementByClassName("inputBox").sendKeys("Moolya");
		Thread.sleep(2000);
		firefox.findElementById("createLeadForm_parentPartyId").sendKeys("parent");
		// ennter first name
		firefox.findElementById("createLeadForm_firstName").sendKeys("fghj");
		// enter last name
		firefox.findElementById("createLeadForm_lastName").sendKeys("qwe");

		// Source dropdown
		Select dropSelect = new Select(firefox.findElement(By.id("createLeadForm_dataSourceId")));

		dropSelect.selectByValue("LEAD_COLDCALL");

		// SELECT MARKET DROP DOWN

		Select marketing = new Select(firefox.findElementById("createLeadForm_marketingCampaignId"));
		marketing.selectByValue("CATRQ_AUTOMOBILE");

		// select birthdate

		firefox.findElementById("createLeadForm_birthDate").sendKeys("05/01/1996");

		// industry dripdown

		WebElement industry = firefox.findElementById("createLeadForm_industryEnumId");

		Select s1 = new Select(industry);
		s1.selectByVisibleText("Computer Hardware");

		// Enter Description

		firefox.findElementByXPath("//textarea[@id='createLeadForm_description']")
				.sendKeys("creating form for lead //////");

		// Important note

		firefox.findElementByXPath("//textarea[@id='createLeadForm_importantNote']")
				.sendKeys("Creating important notes////");

		// *******************Contact
		// Information**************************************

		// enter email address
		firefox.findElementByXPath("//input[@id='createLeadForm_primaryEmail']").sendKeys("vinay.sharmaa02@gmail.com");

		// ********primary address*******************************

		// Enter to name
		firefox.findElementByXPath("//input[@id='createLeadForm_generalToName']").sendKeys("abc");

		// select country

		Select country = new Select(firefox.findElementByXPath("//select[@id='createLeadForm_generalCountryGeoId']"));
		country.selectByVisibleText("Albania");
	}

}
