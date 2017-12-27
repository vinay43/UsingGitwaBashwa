package selenium.utility;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtiltiy {

	WebDriver driver = null;
	WebElement element = null;
	

	/**
	 * This method launch the respective browser and load the rewquested URL
	 * @param browserName  - firefox or chrome or ie
	 * @param appURL
	 */
	public void launchBrowserAndApp(String browserName, String appURL){
		
	
		
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\Selenium_Complete_Training\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")){
			System.setProperty("webdriver.ie.driver", "D:\\selenium\\Selenium_Complete_Training\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\softwares\\selenium jars\\chromedrive\\iexplorer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(appURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	/**
	 * This method helps to send the text to text box
	 * 
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue - the value of above locotor type u have chosen
	 * @param textToBePassed - text needs to be passed to the text box 
	 */
	public void textBoxHandling(String locatorType, String locatorValue, String textToBePassed){

		
		if(locatorType.equals("id")){
			element = driver.findElement(By.id(locatorValue));
		}else if(locatorType.equals("name")){
			element = driver.findElement(By.name(locatorValue));
			
		}else if(locatorType.equals("className")){
			element = driver.findElement(By.className(locatorValue));
		}else if(locatorType.equals("xpath")){
			element = driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equals("tagName")){
			element = driver.findElement(By.tagName(locatorValue));
		}else if(locatorType.equals("css")){
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		element.clear();
		element.sendKeys(textToBePassed);
	}
	/**
	 * 
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue - 
	 */
	public void buttonHandling(String locatorType, String locatorValue){

		
		if(locatorType.equals("id")){
			element = driver.findElement(By.id(locatorValue));
		}else if(locatorType.equals("name")){
			element = driver.findElement(By.name(locatorValue));
			
		}else if(locatorType.equals("className")){
			element = driver.findElement(By.className(locatorValue));
		}else if(locatorType.equals("xpath")){
			element = driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equals("tagName")){
			element = driver.findElement(By.tagName(locatorValue));
		}else if(locatorType.equals("css")){
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		
		element.click();
	}
	/**
	 * this method will click the link based on input link text
	 * @param linkText - text on the link
	 */
	public void linkhandling( String linkText){
		driver.findElement(By.partialLinkText(linkText)).click();
		
	}
	
	
	/**
	 * This method selects the value from the drop down list
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue
	 * @param valueToBeSelected
	 */
	public void dropDownHandling(String locatorType, String locatorValue,String valueToBeSelected)
	{
		if(locatorType.equals("id")){
			element = driver.findElement(By.id(locatorValue));
		}else if(locatorType.equals("name")){
			element = driver.findElement(By.name(locatorValue));
			
		}else if(locatorType.equals("className")){
			element = driver.findElement(By.className(locatorValue));
		}else if(locatorType.equals("xpath")){
			element = driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equals("tagName")){
			element = driver.findElement(By.tagName(locatorValue));
		}else if(locatorType.equals("css")){
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		
		Select sel=new Select(element);
		sel.selectByVisibleText(valueToBeSelected);
		
	}
	/**
	 * This method will take screen shot and save it in local drive 
	 * @throws IOException
	 */
	public void takeScreenShot() throws IOException{
		
		//take screen shot and store it in file object
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//generate random to append with fileName to make sure file name is unique
		Random ran = new Random();
		int randonNumber = ran.nextInt(10000);
		String ranNunmberAsString = String.valueOf(randonNumber);

		//create file object for dest file
		File dest=new File("D:\\selenium\\Selenium_Office\\SeleniumUtility\\sle"+ranNunmberAsString+".png");
		
		//copy file
		FileUtils.copyFile(src, dest);
		System.out.println("screen shot has been saved in following location "+"C:\\Users\\njayapal\\scrn"+ranNunmberAsString+".png");
	}
	
	public String alertHandling(String okorcancel){
		Alert alert = driver.switchTo().alert();
		String textonalert = alert.getText();
		
		if(okorcancel.equals("ok")){
			alert.accept();
		}else if(okorcancel.equals("cancel")){
			alert.dismiss();
		}
		
		return textonalert;
	}
		
		
	
	/**
	 * this method will close the browser
	 */
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
