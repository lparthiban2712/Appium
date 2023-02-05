package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	
	AndroidDriver<MobileElement>driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("noReset", true);
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
	}
	
	@Test(priority=0)
	public void VerifyAdditionProcess()
	{
		driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElement(By.id("com.miui.calculator:id/digit_6")).click();
		driver.findElementByAccessibilityId("equals").click();
		String Result=driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		System.out.println(Result);
		String arr[]=Result.split(" ");
		System.out.println(arr[1]);
		Assert.assertEquals("15", arr[1]);
	}
	
	@Test(priority=1)
	public void VerifyMultiplicationProcess()
	{
		driver.findElement(By.id("com.miui.calculator:id/digit_4")).click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
		driver.findElementByAccessibilityId("equals").click();
		String Result=driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		System.out.println(Result);
		String arr[]=Result.split(" ");
		System.out.println(arr[1]);
		Assert.assertEquals("20", arr[1]);
	}

	@Test(priority=2)
	public void VerifyDeletebutton()
	{
		Assert.assertEquals(true, driver.findElementByAccessibilityId("delete").isDisplayed());
	}
	
	@AfterTest
	public void CloseSetup()
	{
		driver.quit();
	}
}
