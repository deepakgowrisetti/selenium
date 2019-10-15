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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class AC_ContactPage extends StaticVaraibles {
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//cfn.clickByanyLocater(By.xpath("(//*[@class = 'site-nav__label'])[7]"));
		//cfn.clickByJSE(By.xpath("//*[contains(text(),'Contact us')])[1]"));
		cfn.clickByJSE(By.xpath("(//a[contains(@class,'site-nav')]/span)[10]"));
		
		//cfn.sendKeysByanyLocater(By.id('ContactForm-name'), inputData);(By.id("ContactForm-name"));
		Thread.sleep(5000);
		cfn.sendKeysByanyLocater(obj.contact_name, p.getProperty("contact_name"));
		
		//driver.findElement(By.id("ContactForm-name")).sendKeys("Deepak");
		driver.findElement(By.id("ContactForm-email")).sendKeys("sabitha@gmail.com");
        driver.findElement(By.id("ContactForm-phone")).sendKeys("9083130351");
        driver.findElement(By.id("ContactForm-message")).sendKeys("hello");
		cfn.clickByanyLocater(By.id("(//*[contains (@class, 'btn')])[1]"));
		System.out.println("address modified");
		//cfn.sendKeysByanyLocater("ContactForm-email","Deepak" );
		
	}
		
		
		// cfn.sendKeysByanyLocater(obj.signin_icon, p.getProperty("icon"));
		
		
		
	@AfterMethod // 3
	public void afterMethod(ITestResult res) throws Exception {
		// cfn.takescreenhot("fbLogin");
		cfn.takescreenshotPassorFail(res);

	}

	@Parameters("browser")
	@BeforeClass // 1
	public void beforeClass(@Optional("Chrome") String browser) {
		cfn.browserLaunch(browser);

	}

	@AfterClass // 4
	public void afterClass() {
		driver.quit();
	}

}
