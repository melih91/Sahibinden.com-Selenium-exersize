package com.sahabt.automation.testmasters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sahibinden {
	WebDriver driver;

	@Before
	public void SahibindenComTesti() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.sahibinden.com");
		driver.findElement(By.cssSelector(".login-text [rel]")).click();
		driver.findElement(By.cssSelector(".qr-login-promotion .close")).click();
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void sendKey(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	@Test
	public void EmptyEPosta() {
		sendKey(By.id("username"), "");
		sendKey(By.id("password"), "12345");
		click(By.id("userLoginSubmitButton"));
		System.out.println("Eposta adresinizi veya kullanici adinizi giriniz.");
		driver.close();
	}

	@Test
	public void EmptyPassword() {
		sendKey(By.id("username"), "melihkaracomak91@hotmail.com");
		sendKey(By.id("password"), "");
		click(By.id("userLoginSubmitButton"));
		System.out.println("Sifrenizi giriniz.");
		driver.close();
	}

	@Test
	public void EmptyEPostaEmptyPassword() {
		sendKey(By.id("username"), "");
		sendKey(By.id("password"), "");
		click(By.id("userLoginSubmitButton"));
		System.out.println("Eposta adresinizi veya kullanici adinizi giriniz.");
		System.out.println("Sifrenizi giriniz.");
		driver.close();
	}

	@Test
	public void FailureEPosta() {
		sendKey(By.id("username"), "asdasdasd");
		sendKey(By.id("password"), "12345");
		click(By.id("userLoginSubmitButton"));
		System.out.println("E-Posta adresiniz, kullanıcı adınız veya şifreniz hatalı.");
		driver.close();
	}

	@Test
	public void FailurePassword() {
		sendKey(By.id("username"), "melihkaracomak91@hotmail.com");
		sendKey(By.id("password"), "12345");
		click(By.id("userLoginSubmitButton"));
		System.out.println("E-Posta adresiniz, kullanıcı adınız veya şifreniz hatalı.");
		driver.close();
	}

	@Test
	public void TrueEPostaTruePassword() {
		sendKey(By.id("username"), "melihkaracomak91@hotmail.com");
		sendKey(By.id("password"), "melih1991");
		click(By.id("userLoginSubmitButton"));
		System.out.println("Sisteme basarili sekilde giris yaptiniz.");
		driver.close();
	}

	@After
	public void quit() {
		driver.quit();
	}
}
