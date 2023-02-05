package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContextSwitchingDemo {
	
	AndroidDriver<AndroidElement>driver;
	@BeforeTest
	public void launchbrowser() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities cs=new DesiredCapabilities();
		cs.setCapability("deviceName", "emulator-5554");
		cs.setCapability("platformName", "ANDROID");
		cs.setCapability("chromedriverExecutable", "C://Users//admin//node_modules//appium//bin//chromedriver.exe");
		cs.setCapability("browserName", "Chrome");
		cs.setCapability("noReset", true);
		driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cs);
		driver.get("https://www.ebay.com/");
	}

	@Test
	public void addShortcutToHomeScreen()
	{
		
		Set<String> contexts = driver.getContextHandles();

		for (String context : contexts) {
			System.out.println(context);
		}
		System.out.println(driver.getContext());

		// switch to native app
		driver.context("NATIVE_APP");
		System.out.println(driver.getContext());

		// click on 3 dots
		driver.findElement(By.id("com.android.chrome:id/menu_button")).click();

		// click on Add to Home
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Add to Home screen\"]")).click();

		// wait for pop up to appear + button 

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.chrome:id/positive_button")));
		driver.findElement(By.id("com.android.chrome:id/positive_button")).click();

		// Click on Add to Home screen button
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Add to Home screen']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Add to Home screen']")).click();
		 
	}
	
	@AfterTest
	public void closeSetup()
	{
		//driver.close();
	}
}
