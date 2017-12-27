package Training_Assignment_Friday;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		firefox.findElementById("label").click();
		firefox.findElementByXPath("//a[contains(text(),'Accounts')]").click();
		firefox.findElementByXPath("//a[contains(text(),'Create Account')]").click();
		firefox.findElementByXPath("//input[@id='accountName']").sendKeys("xyz");
		firefox.findElementByXPath("//input[@id='groupNameLocal']").sendKeys("qqq");

		firefox.findElementByXPath("//input[@id='annualRevenue']").sendKeys("qqq");

		firefox.findElementByXPath("//input[@id='sicCode']").sendKeys("qqq");

		firefox.findElementByXPath("//textarea[@name='description']").sendKeys("qqq");

		firefox.findElementByXPath("//textarea[@name='importantNote']").sendKeys("qqq");

		firefox.findElementByXPath("//input[@id='officeSiteName']").sendKeys("qqq");

		firefox.findElementByXPath("//input[@id='numberEmployees']").sendKeys("qqq");
		firefox.findElementByXPath("//input[@id='tickerSymbol']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryPhoneCountryCode']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryPhoneAreaCode']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryPhoneExtension']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryEmail']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryPhoneNumber']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryPhoneAskForName']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='primaryWebUrl']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalToName']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalAddress1']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalCity']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalPostalCode']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalPostalCodeExt']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalAttnName']").sendKeys("wer");

		firefox.findElementByXPath("//input[@id='generalAddress2']").sendKeys("wer");

		WebElement industryfrop = firefox.findElementByXPath("//select[@name='industryEnumId']");

		Select select = new Select(industryfrop);
		select.selectByVisibleText("Aerospace");

		WebElement ownership = firefox.findElementByXPath("//select[@name='ownershipEnumId']");

		Select select1 = new Select(ownership);
		select1.selectByVisibleText("Partnership");

		WebElement source = firefox.findElementByXPath("//select[@id='dataSourceId']");

		Select select2 = new Select(source);
		select2.selectByVisibleText("Cold Call");
		
		WebElement Initialteam = firefox.findElementByXPath("//select[@id='initialTeamPartyId']");

		Select select3 = new Select(Initialteam);
		select3.selectByVisibleText("Demo Sales Team No. 1");
		
		WebElement maeketingcampaign= firefox.findElementByXPath("//select[@id='marketingCampaignId']");

		Select select4 = new Select(maeketingcampaign);
		select4.selectByVisibleText("Affiliate Sites");
		
		WebElement country= firefox.findElementByXPath("//select[@id='generalCountryGeoId']']");

		Select select5 = new Select(country);
		select5.selectByVisibleText("India");
		
		WebElement state= firefox.findElementByXPath("//select[@id='generalStateProvinceGeoId']");

		Select select6 = new Select(state);
		select6.selectByVisibleText("KARNATAKA");


		
		

	}

}
