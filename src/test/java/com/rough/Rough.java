package com.rough;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.backend.Options;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {
	public void b() throws InterruptedException, AWTException {
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get("https://adactinhotelapp.com/");
	WebElement findElement2 = driver.findElement(By.id("username"));
	findElement2.sendKeys("Naveenaso");
	WebElement findElement = driver.findElement(By.id("password"));
	findElement.sendKeys("Naveenmech1!");
	Actions a = new Actions(driver);
	//a.contextClick(sh).perform();
	a.doubleClick(findElement2).perform();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_C);
	r.keyRelease(KeyEvent.VK_C);
	r.keyRelease(KeyEvent.VK_CONTROL);
	Alert alert = driver.switchTo().alert();
	alert.accept();
	Actions ac = new Actions(driver);
	Set<String> windowHandles = driver.getWindowHandles();
	for (String string : windowHandles) {
		if (!string.equals(windowHandles)) {
			System.out.println(string);
		}
	}
	//Wait w = new FluentWait(driver).withTimeout(Duration.ofSeconds(20).poll;
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//WebDriverWait driverwait = new WebDriverWait(findElement,45);
	WebElement findElementd = driver.findElement(By.xpath("//div[@class='auth_error']"));
	String text = findElement.getText();
	Thread.sleep(5000);}
	////WebElement findElement = driver.findElement(By.xpath("//div[@class='auth_error']"));
//	String text = findElement.getText();
	//System.out.println(text);
	//*/
	/*boolean contains = text.contains("Invalid Login details or Your Password might have expired");
	System.out.println(contains);
	Assert.assertTrue(contains);*/
/*	WebElement location = driver.findElement(By.id("location"));
	Select s = new Select(location);
	s.selectByVisibleText("London");*/
	/*String attribute = location.getAttribute("value");
	System.out.println(attribute);
	WebElement sh = driver.findElement(By.xpath("//a[text()='Search Hotel']"));
	String text = sh.getText();
	System.out.println(text);
Actions a = new Actions(driver);
a.contextClick(sh).perform();
a.doubleClick(sh).perform();*/
/*	WebElement hotel = driver.findElement(By.id("hotels"));
	Actions a = new Actions(driver);
	a.click(hotel).perform();
	a.keyDown(Keys.DOWN).perform();
	a.keyDown(Keys.DOWN).perform();
	//a.click().perform();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_DOWN);*/
	
	/*WebElement hotel = driver.findElement(By.id("hotels"));
	Select s1 = new Select(hotel);
	s1.selectByVisibleText("Hotel Sunshine");
	WebElement roomType = driver.findElement(By.id("room_type"));
	Select s2 = new Select(roomType);
	s2.selectByVisibleText("Standard");
	WebElement roomNos = driver.findElement(By.id("room_nos"));
	Select s3 = new Select(roomNos);
	s3.selectByVisibleText("5 - Five");
	WebElement checkIn = driver.findElement(By.xpath("//input[@name='datepick_in']"));
	checkIn.clear();
	checkIn.sendKeys("20/11/2022");
	WebElement checkOut = driver.findElement(By.xpath("//input[@name='datepick_out']"));
	checkOut.clear();
	checkOut.sendKeys("18/11/2022");
	WebElement adultRoom = driver.findElement(By.id("adult_room"));
	Select s4 = new Select(adultRoom);
	s4.selectByVisibleText("2 - Two");
	WebElement childRoom = driver.findElement(By.xpath("//select[@name='child_room']"));
	Select s5 = new Select(childRoom);
	s5.selectByVisibleText("2 - Two");
	WebElement searchBtn = driver.findElement(By.id("Submit"));
	searchBtn.click();
	WebElement sucMsg = driver.findElement(By.className("login_title"));
	String text = sucMsg.getText();
	//Assert.assertEquals("verify the search success message", "Select Hotel",text);
	System.out.println(text);
	String text2 = driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();
	System.out.println("in"+text2);// ok
	//String text3 = checkOut.getText();
	String text3 = driver.findElement(By.xpath("//*[@id=\"checkout_span\"]")).getText();
	System.out.println("out"+text3);// ok*/
	
}
	public static void main(String[] args) throws InterruptedException, AWTException {
		Rough r = new Rough();
		r.b();
	}

}
