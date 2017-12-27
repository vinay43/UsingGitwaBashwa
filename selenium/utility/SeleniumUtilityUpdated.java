package selenium.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtilityUpdated {

	WebDriver driver = null;
	WebElement element = null;
	

	/**
	 * This method launch the respective browser and load the rewquested URL
	 * @param browserName  - firefox or chrome or ie
	 * @param appURL
	 */
	public void launchBrowserAndApp(String browserName, String appURL){
		
		try {
			if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", "C:\\softwares\\selenium jars\\geckodriver-v0.19.1-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browserName.equals("chrome")){
				System.setProperty("webdriver.ie.driver", "C:\\softwares\\selenium jars\\chromedrive\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browserName.equals("ie")){
				System.setProperty("webdriver.ie.driver", "C:\\softwares\\selenium jars\\chromedrive\\iexplorer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
			driver.get(appURL);
			driver.manage().window().maximize();
		} catch (WebDriverException e) {
			
			System.out.println("error in launching browser "+e.getMessage());
		}
	}
	
	
	public WebElement locateTheElement(String locatorType, String locatorValue){
		try {
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
		} catch (NoSuchElementException e) {
			System.out.println("element not found");
			e.printStackTrace();
		}catch (WebDriverException e) {
			
			e.printStackTrace();
		}
		return element;
		
	}
	
	/**
	 * This method helps to send the text to text box
	 * 
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue - the value of above locotor type u have chosen
	 * @param textToBePassed - text needs to be passed to the text box 
	 */
	public void textBoxHandling(String locatorType, String locatorValue, String textToBePassed){

		
		try {
			locateTheElement(locatorType, locatorValue);
			element.clear();
			element.sendKeys(textToBePassed);
		} catch (InvalidElementStateException e) {
			// TODO Auto-generated catch block
			System.out.println("the element is not ready to interact due to "+e.getMessage());
		}catch (WebDriverException e) {
			System.out.println("error in text box handling with locator as "+locatorValue);
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue - 
	 */
	public void buttonHandling(String locatorType, String locatorValue){

		try {
			locateTheElement(locatorType, locatorValue);
			element.click();
		} catch (InvalidElementStateException e) {
			System.out.println("the element "+element+" is not interactable");
		} catch (WebDriverException e) {
			System.out.println("error in handling button "+e.getMessage());
		} 
	}
	/**
	 * this method will click the link based on input link text
	 * @param linkText - text on the link
	 */
	public void linkhandling( String linkText){
		try {
			driver.findElement(By.partialLinkText(linkText)).click();
		} catch (InvalidElementStateException e) {
			System.out.println("the element "+element+" is not interactable");
		} catch (WebDriverException e) {
			System.out.println("error in handling link "+e.getMessage());
		} 
		
	}
	
	/**
	 * This method selects the value from the drop down list
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue
	 * @param valueToBeSelected
	 */
	public void dropDownHandling(String locatorType, String locatorValue,String valueToBeSelected)
	{
		try {
			locateTheElement(locatorType, locatorValue);
			Select sel=new Select(element);
			sel.selectByVisibleText(valueToBeSelected);
		} catch (WebDriverException e) {
			System.out.println("error in dropdown handling "+e.getMessage());
		}
		
	}
	/**
	 * This method will take screen shot and save it in local drive 
	 * @throws IOException
	 */
	public void takeScreenShot() throws IOException{
		
		
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Random ran = new Random();
			int randonNumber = ran.nextInt(10000);
			String ranNunmberAsString = String.valueOf(randonNumber);
			
			File dest=new File("C:\\Users\\scrn"+ranNunmberAsString+".png");
			FileUtils.copyFile(src, dest);
			System.out.println("screen shot has been saved in following location "+"C:\\Users\\njayapal\\scrn"+ranNunmberAsString+".png");
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
	}
	
	/**
	 * this method will handle alert based on the user input 
	 * @param okorcancel - ok/cancel
	 * @return
	 */
	public String alertHandling(String okorcancel){
		String textOnAlert=null;
		try {
			Alert alert = driver.switchTo().alert();
			textOnAlert = alert.getText();
			if(okorcancel.equals("ok")){
				alert.accept();
			}else if(okorcancel.equals("cancel")){
				alert.dismiss();
			}
		} catch (WebDriverException e) {
			System.out.println("error in alert handling "+e.getMessage());
			e.printStackTrace();
		}
		return textOnAlert;
	}
	
	public void switchToFrame(String locatorType, String locatorValue) {
		try {
			
			driver.switchTo().frame(locateTheElement(locatorType, locatorValue));
			System.out.println("switch In to the Frame ");
		} catch (NoSuchFrameException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());	
		} 
	}
	public void switchBackFromFrame() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("brought the control out of frame");
		} catch (NoSuchFrameException e) {
			System.out.println("no such frame available  : "+e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());	
		} 
	}
	/**
	 * This method switch the control to child window
	 * @param index 0 means parent window & 1 means first child window
	 */
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("number of windows "+allWindowHandles.size());
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index "+index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
	}
	/**
	 * This method will return you the text available in the element (means text in between the tags)
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public String getText(String locatorType, String locatorValue){
		String text = null;
		try {
			 text = locateTheElement(locatorType, locatorValue).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	/**
	 * this method will return you the value of attribute that have been passed
	 * @param locatorType
	 * @param locatorValue
	 * @param attribute
	 * @return
	 */
	public String getAtrribute(String locatorType, String locatorValue,String attribute){
		String text = null;
		try {
			 text = locateTheElement(locatorType, locatorValue).getAttribute(attribute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	
	/**
	 * this method will close the browser
	 */
	public void closeBrowser(){
		try {
			driver.close();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("error in closing browser "+e.getMessage());
		}
	}
	
	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The opened browsers are closed");
		} catch (WebDriverException e) {
			System.out.println("The browsers could not be closed");
		}
	}
	
}
