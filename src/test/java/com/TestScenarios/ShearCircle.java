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

public class ShearCircle extends StaticVaraibles {
	// WebDriver driver;

	// create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test // 2
	public void login() throws IOException, Exception {
		// get the data from property file

		String path = "./testData/ShearCir.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		driver.get(p.getProperty("URL"));
		driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-info']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[contains(@class, 'btn-primary')])[3]")).click();
		//Thread.sleep(2000);
		//click on the submit button without entering values
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		
		 String a = driver.findElement(By.xpath("((//*[@class ='invalid'])[1])")).getText();
		 //System.out.println(a);
		 //driver.navigate().refresh();
		 
        driver.findElement(By.id("firstname")).sendKeys("Deepak");
        driver.findElement(By.id("lastname")).sendKeys("Gowrisetti");
        driver.findElement(By.id("uname")).sendKeys("dgowrisetti@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("9083100351");
        driver.findElement(By.id("password")).sendKeys("45641654");
        driver.findElement(By.id("cnf_password")).sendKeys("45664666");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        
        //Thread.sleep(2000);
        System.out.println("Success");
         String b = driver.findElement(By.xpath("((//*[@class ='invalid'])[1])")).getText();
        System.out.println(b);
		

	}

	@AfterMethod // 3
	public void afterMethod(ITestResult res) throws Exception {
		// cfn.takescreenhot("fbLogin");
		cfn.takescreenshotPassorFail(res);

	}

	@Parameters("browser")
	@BeforeClass // 1
	public void beforeClass(@Optional("chrome") String browser) {
		cfn.browserLaunch(browser);

	}

	@AfterClass // 4
	public void afterClass() {
		driver.quit();
	}

}
