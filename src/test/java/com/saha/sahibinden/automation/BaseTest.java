package com.saha.sahibinden.automation;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver driver;

	public String driverName = "webdriver.chrome.driver";
	public String driverPath = "driver/chromedriver.exe";
	public String url = "http://www.sahibinden.com";

	@Before
	public void setup() {
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	public void login(String username, String password) {
		click(By.cssSelector(".login-text [rel]"));
		click(By.cssSelector(".qr-login-promotion .close"));
		sendKey(By.id("username"), username);
		sendKey(By.id("password"), password);
		click(By.id("userLoginSubmitButton"));
		System.out.println("Sisteme basarili sekilde giris yaptiniz.");
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void sendKey(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void submit(By by) {
		driver.findElement(by).submit();
	}

	public WebElement find(By by) {
		WebElement x = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", x);
		return x;
	}

	public void thread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
