package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeDemo {
	
	AndroidDriver<MobileElement>driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platForm", "ANDROID");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		cap.setCapability("noReset", true);
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
	}
	
	@Test
	public void swipeLeftToRight()
	{
		TouchAction ta=new TouchAction(driver);
		ta.press(PointOption.point(296,694)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(765,690)).release().perform();
	}
	
	@Test
	public void ZoomOut() throws InterruptedException
	{
		Thread.sleep(5000);
		//swipe from right to left
		TouchAction ta1=new TouchAction(driver);
		ta1.press(PointOption.point(1056, 855)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(611,913)).release();
		
		//swipe from left to right
		TouchAction ta2=new TouchAction(driver);
		ta2.press(PointOption.point(100, 921)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(453,870)).release();
		
		
		MultiTouchAction mt=new MultiTouchAction(driver);
		mt.add(ta1).add(ta2).perform();
		
		
		
		
	}
	
}

