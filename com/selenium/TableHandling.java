package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\softwares\\selenium jars\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MS",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("SBC",Keys.TAB);
		
		
	
		
		Thread.sleep(5000);
		WebElement table = driver.findElementByXPath("(//table[contains(@class,'TrainList')])[2]");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("the no of rows "+rows.size());
		
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		System.out.println("number of columns "+columns.size());

		//loop through all the rows in the table and apply findElements for each row to find all the columns in each row.
		//then get the second column and apply the getText method to get the taxt.
		for(WebElement ele:rows){
			
			if(ele.findElements(By.tagName("td")).size()>0){
				System.out.println(ele.findElements(By.tagName("td")).get(1).getText());
			}
		}
		
	}

}
