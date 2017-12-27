package selenium.basics;

import selenium.utility.SeleniumUtilityUpdated;

public class WindowsHandlingUsingUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		SeleniumUtilityUpdated utility = new SeleniumUtilityUpdated();
		utility.launchBrowserAndApp("firefox", "http://leaftaps.com/opentaps");
		utility.textBoxHandling("id", "username", "DemoSalesManager");
		utility.textBoxHandling("name", "PASSWORD", "crmsfa");
		utility.buttonHandling("className", "decorativeSubmit");
		utility.linkhandling("CRM/SF");
		utility.linkhandling("Leads");
		utility.linkhandling("Merge Leads");
		utility.buttonHandling("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]");
		utility.switchToWindow(1);
		utility.linkhandling("10056");
		utility.switchToWindow(0);
		utility.linkhandling("(//img[@src='/images/fieldlookup.gif'])[2]");
		utility.switchToWindow(1);
		utility.linkhandling("10058");
		utility.switchToWindow(0);
		
		
	}

}
