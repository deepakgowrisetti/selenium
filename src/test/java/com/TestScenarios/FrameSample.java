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

public class FrameSample extends StaticVaraibles {
	// WebDriver driver;

	// create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test // 2
	public void login() throws IOException, Exception {
		// get the data from property file

		String path = "./testData/TD.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		driver.get(p.getProperty("FrameURL"));
		
		//move cursor point to default page
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(1);
		cfn.loopAllframesAndReturnCountofElement(obj.zonal_Link);
		Thread.sleep(2000);
		
		cfn.clickByanyLocater(obj.zonal_Link);
		
		Thread.sleep(2000);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);
		cfn.loopAllframesAndReturnCountofElement(obj.lastUpdate);
		Thread.sleep(2000);
		
		String lastUpdte = driver.findElement(obj.lastUpdate).getText();
		System.out.println(lastUpdte);	
		

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
