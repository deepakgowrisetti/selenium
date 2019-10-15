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

public class AakruthiCollections extends StaticVaraibles {
	// WebDriver driver;

	// create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test // 2
	public void TC_001_login() throws IOException {
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

	}

	@Test // 2
	public void TC_002_viewAddress() throws IOException {
		// get the data from property file

		String path = "./testData/aakruthi.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		
	  // cfn.clickByanyLocater(locater);
		
		
		
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
