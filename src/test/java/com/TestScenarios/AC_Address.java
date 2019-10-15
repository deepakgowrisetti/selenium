package com.TestScenarios;

import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class AC_Address extends StaticVaraibles {
	// WebDriver driver;

	// create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test // 2
	public void TC_001_login() throws IOException, Exception {
		// get the data from property file

		String path = "./testData/aakruthi.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		driver.get(p.getProperty("URL"));
		cfn.clickByanyLocater(obj.signin_icon);
		// cfn.sendKeysByanyLocater(obj.signin_icon, p.getProperty("icon"));
		cfn.sendKeysByanyLocater(obj.Email_EditBox, p.getProperty("CustomerEmail"));
		cfn.sendKeysByanyLocater(obj.Password_EditBox, p.getProperty("CustomerPassword"));
		cfn.clickByanyLocater(obj.Login_Button_2);
		System.out.println("button Clicked");
		Thread.sleep(5000);
	}

	/*@Test // 2
	public void TC_002_DeleteAlert() throws IOException {
		// get the data from property file

		String path = "./testData/aakruthi.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);

		cfn.clickByanyLocater(obj.View_address);
		// click on delete button
		cfn.clickByanyLocater(obj.delete_address);

		// confirmation alert will present and click on cancel button
		// get the text from the alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}*/

	@Test // 2
	public void TC_003_EditAddress() throws IOException {
		// get the data from property file

		String path = "./testData/aakruthi.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);

		 cfn.clickByanyLocater(obj.View_address);
		// Before edit the address, get name of element data
		String beforeEditText = driver
				.findElement(By.xpath("//*[@id='MainContent']/div[2]/div/div/div[2]/p[1]/text()[1]")).getText();
		// click on edit

		cfn.clickByanyLocater(obj.edit_address);

		// change lastname
		driver.findElement(By.name("address[last_name]")).sendKeys("Gowrisetty");

		cfn.clickByanyLocater(By.xpath("(//*[@value = 'Update Address'])[1]))"));
		
		

		String afterEditText = driver
				.findElement(By.xpath("//*[@id='MainContent']/div[2]/div/div/div[2]/p[1]/text()[1]")).getText();

		// compare before and after
		if (beforeEditText.contentEquals(afterEditText)) {
			System.out.println("Edit functionality is NOT working ");
		} else {
			System.out.println("Edit functionality is working  as expected");
		}

	}

	@AfterMethod // 3
	public void afterMethod(ITestResult res) throws Exception {
		// cfn.takescreenhot("fbLogin");
		cfn.takescreenshotPassorFail(res);

	}

	@Parameters("browser")
	@BeforeClass // 1
	public void beforeClass(@Optional("firefox") String browser) {
		cfn.browserLaunch(browser);

	}

	@AfterClass // 4
	public void afterClass() {
		driver.quit();
	}

}
