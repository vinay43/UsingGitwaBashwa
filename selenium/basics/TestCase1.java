package selenium.basics;

import java.io.IOException;

import selenium.utility.SeleniumUtiltiy;

public class TestCase1 {

	public static void main(String[] args) throws IOException {
		
		SeleniumUtiltiy utility = new SeleniumUtiltiy();
		utility.launchBrowserAndApp("firefox", "http://www.leaftaps.com/opentaps");

		utility.textBoxHandling("id", "username", "DemoSalesManager");
		utility.textBoxHandling("name", "PASSWORD", "crmsfa");
		utility.buttonHandling("className", "decorativeSubmit");
		utility.linkhandling("CRM/SF");
//		***********Create lead************************************
		utility.linkhandling("Create Lead");
		utility.textBoxHandling("xpath", "//input[@id='createLeadForm_companyName']", "abc");
		utility.textBoxHandling("xpath", "//input[@id='createLeadForm_parentPartyId']", "abc1");
		utility.textBoxHandling("xpath", "//input[@id='createLeadForm_firstName']", "abc2");
		
		
		
//		utility.takeScreenShot();
//		utility.closeBrowser();
		
		
	}

}
