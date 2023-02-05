package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SpinnerDemo {
	
	AndroidDriver<MobileElement>driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		cap.setCapability("noReset", true);
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
	}
	
	@Test(priority=0)
	public void SelectColorAndDateFromSpinner()
	{
		// click on API Demos
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();

		// click on views
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

		// scroll and click on spinner
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))")
				.click();

		// click yellow in 1st drop down
		driver.findElementById("com.touchboarder.android.api.demos:id/spinner1").click();// click on dropdown
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='yellow']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='yellow']")).click();

		// click jupiter in 2nd drop down
		driver.findElementById("com.touchboarder.android.api.demos:id/spinner2").click();// click on dropdown
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Jupiter']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Jupiter']")).click();
	       
		
	}
	
}

