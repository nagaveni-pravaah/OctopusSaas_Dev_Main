package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GeneratorPortal {
	WebDriver driver;
	public GeneratorPortal(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy (xpath = "//button[@class='flex items-center gap-4 focus:outline-none']")
	private WebElement userprofileButton;
	@FindBy (xpath = "//a[contains (text(),'Transporter Settings')]")
	private WebElement transportesettings;
	@FindBy (xpath = "//a[contains (text(),'Log In to Generator Portal')]")
	private WebElement generatorportalLink;
	@FindBy (xpath = "//div[@class='w-full flex flex-col items-center max-w-md bg-white p-8 sm:p-10 rounded-2xl shadow-[0_8px_30px_rgb(0,0,0,0.04)] border border-gray-100']")
	private WebElement welcomepage;
	@FindBy (xpath = "//input[@type='email']")
	private WebElement emailtextfield;
	@FindBy (xpath = "//input[@type='password']")
	private WebElement passwordtextfield;
	@FindBy (xpath = "//button[contains (text(),'Login')]")
	private WebElement login;
	
	
	public WebElement getLogin() {
		return login;
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}
	
	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}


	public WebElement getWelcomepage() {
		return welcomepage;
	}


	public WebElement getGeneratorportalLink() {
		return generatorportalLink;
	}


	public WebElement getTransportesettings() {
		return transportesettings;
	}


	public WebElement getUserprofileButton() {
		return userprofileButton;
	}
}
