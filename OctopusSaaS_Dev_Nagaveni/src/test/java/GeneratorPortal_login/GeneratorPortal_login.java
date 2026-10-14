package GeneratorPortal_login;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.FileUtility.FileUtility;
import com.Octopussaas.ObjectRepository.GeneratorPortal;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

import io.reactivex.rxjava3.functions.Action;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class GeneratorPortal_login extends BaseClassForGEneratorContacts{
	GeneratorPortal gpn;
	ExcelUtility elib ;
	
	
	@Test
	public void TC_001VerifyGeneratorportalloginlink() throws InterruptedException
	{
		gpn = new GeneratorPortal(driver);
		elib = new ExcelUtility();
		gpn.getUserprofileButton().click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(gpn.getTransportesettings()).click().perform();
		Thread.sleep(2000);
		act.scrollToElement(gpn.getGeneratorportalLink()).perform();
		System.out.println("Log In to Generator Portal link is present");
		utilityclassobject.gettest().log(Status.PASS,"Log In to Generator Portal link is present");
		
	}
	
	@Test(dependsOnMethods = "TC_001VerifyGeneratorportalloginlink")
	public void TC_002VerifyGeneratorportalloginisClickable() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.scrollToElement(gpn.getGeneratorportalLink()).click().perform();
		Thread.sleep(2000);
		System.out.println("User is able to click on Login to Generator portal");
		utilityclassobject.gettest().log(Status.PASS,"User is able to click on Login to Generator portal");
	}
	
	
	@Test(dependsOnMethods = "TC_002VerifyGeneratorportalloginisClickable")
	public void TC_003Generatorportallogin_Newtab() throws InterruptedException
	{
		 String parentWindow = driver.getWindowHandle();

		    WebElement generatorPortal = gpn.getGeneratorportalLink();

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", generatorPortal);
		    Thread.sleep(1000);

		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", generatorPortal);

		    Thread.sleep(3000);

		    Set<String> allWindows = driver.getWindowHandles();

		    System.out.println("Window Count: " + allWindows.size());

		    for (String window : allWindows) {
		        if (!window.equals(parentWindow)) {
		            driver.switchTo().window(window);
		            break;
		        }
		    }

		    System.out.println("Title: " + driver.getTitle());
		    System.out.println("URL: "+ driver.getCurrentUrl());

		    utilityclassobject.gettest().log(Status.PASS,"Generator Portal opened successfully");
	}
	
	@Test(dependsOnMethods = "TC_003Generatorportallogin_Newtab")
	public void TC_004VerifyGeneratorContacts_welcomepage()
	{
		gpn.getWelcomepage().isDisplayed();
		System.out.println("Successfully displayed welcome page");
	    utilityclassobject.gettest().log(Status.PASS,"Successfully displayed welcome page");		
	}
	
	@Test(dependsOnMethods = "TC_004VerifyGeneratorContacts_welcomepage")
	public void TC_005VerifyGeneratorPortal_textfields()
	{
		gpn.getEmailtextfield().isDisplayed();
		gpn.getPasswordtextfield().isDisplayed();
		gpn.getLogin().isDisplayed();
		System.out.println("Welcom page is displayed along with Enter email text field and password and Login button");
	    utilityclassobject.gettest().log(Status.PASS,"Successfully displayed welcome page");		
		
	}
	
	@Test(dependsOnMethods = "TC_005VerifyGeneratorPortal_textfields")
	public void TC_006VerifyGeneratorPortal_URLlink() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException
	{
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currenturl);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(1000);

		String copiedUrl = (String) Toolkit.getDefaultToolkit()
		        .getSystemClipboard()
		        .getData(DataFlavor.stringFlavor);

		System.out.println("Copied URL: " + copiedUrl);
		
		if(currenturl.equals(copiedUrl))
		{
			System.out.println("Able to copy Link");
		}
		else {
			System.out.println("not able to copy Link");
		}

		System.out.println("Able to copy Link");
	    utilityclassobject.gettest().log(Status.PASS,"Able to copy Link");			
		
	}
	
	@Test
	public void TC_007VerifyGeneratorcontacts_EmailwithAlphabets()
	{
		gpn.getEmailtextfield().click();
	}
	
	

}
