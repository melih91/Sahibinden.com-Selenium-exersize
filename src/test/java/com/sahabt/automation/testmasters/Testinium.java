package com.sahabt.automation.testmasters;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testinium {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://46.101.63.20:8080/testinium/");
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void sendKey(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	@Test
	public void TestiniumTest() throws InterruptedException {

		click(By.className("btn"));

		Thread.sleep(1000);

		sendKey(By.id("firstName"), "Melih");
		sendKey(By.id("lastName"), "Karaçomak");
		sendKey(By.id("email"), "melihkaracomak91@hotmail.com");
		sendKey(By.id("password"), "12345");

		click(By.id("uploadPhotoButton"));

		String title = driver.getTitle();
		Assert.assertTrue("PAGE_2 içermiyor", title.contains("PAGE-2"));

		Thread.sleep(1000);

		sendKey(By.id("exampleSelect1"), "4");

		// Select select = new Select(find(By.id("exampleSelect1")));
		// select.selectByValue("3");

		click(By.id("exampleInputFile"));
		File file = new File("C:\\Users\\Melih\\Desktop\\test.txt");
		driver.findElement(By.id("exampleInputFile")).sendKeys(file.getAbsolutePath());

		Thread.sleep(3000);
		click(By.id("uploadPhotoButton"));

		Thread.sleep(3000);
		String fN = driver.findElement(By.id("firstName")).getText();
		Assert.assertEquals(fN, "Melih");
		String lN = driver.findElement(By.id("lastName")).getText();
		Assert.assertEquals(lN, "Karaçomak");
		String email = driver.findElement(By.id("email")).getText();
		Assert.assertEquals(email, "melihkaracomak91@hotmail.com");
		String pW = driver.findElement(By.id("password")).getText();
		Assert.assertEquals(pW, "12345");
		Thread.sleep(6000);

	}

	@After
	public void quit() {
		driver.quit();
	}
}
