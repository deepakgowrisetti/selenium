package com.Objectrepository;

import org.openqa.selenium.By;

public class Locaters {

	public static final By Email_EditBox = By.id("CustomerEmail");
	public static final By Password_EditBox = By.id("CustomerPassword");
	public static final By Login_Button = By.id("loginbutton");
	public static final By signin_icon = By.xpath("//a[@href='/account/login']");
	public static final By Login_Button_1 = By.id("customer_login");
	public static final By Login_Button_2 = By.xpath("//*[@value = 'Sign In']");
	public static final By View_address = By.xpath("//a[contains(text(),'View Addresses')]");
	public static final By delete_address = By.xpath("(//*[contains(@class,'address-delete')])[1]");
	public static final By edit_address = By.xpath("(//*[contains(@class,'edit-toggle')])[1]");
	//*[@class ='btn' ] 
	
	//for Contact screen
	
	public static final By contact_name = By.id("ContactForm-name");
	public static final By Contact_email= By.id("ContactForm-email");
	public static final By contact_phone = By.id("ContactForm-phone");
	public static final By contact_message = By.id("ContactForm-message");
	
	//*[@id="MainContent"]/div[2]/div/div/div[2]/p[1]/text()[1]
	
	

	public static final By first_Name = By.id("firstname");
	public static final By last_Name = By.id("lastname");
	public static final By email_1 = By.id("uname");
	public static final By mobile = By.id("mobile");
	public static final By pwd = By.id("password");
	public static final By cnf_Pwd = By.id("cnf_password");
	public static final By submit = By.xpath("(//*[@type='submit'])[1]");
	
	//Frame URL
	public static final By zonal_Link = By.name("P-24Alist");
	public static final By lastUpdate = By.xpath("/html/body/table/tbody/tr[8]/td[2]/span");
	
	
	
	
	
	
}
