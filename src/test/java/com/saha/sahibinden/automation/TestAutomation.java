package com.saha.sahibinden.automation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestAutomation {
	BaseTest basetest = new BaseTest();
	WebDriver driver;

	@Test
	public void loginAndSearchTest() {
		basetest.setup();
		basetest.login("melihkaracomak91@hotmail.com", "melih1991");
		basetest.click(By.cssSelector(".user-info-campaign-dialog [ng-hide]"));
		basetest.click(By.cssSelector(".sahibinden-logo"));
		basetest.sendKey(By.id("searchText"), "Ford Mustang");
		basetest.click(By.cssSelector("button"));
		basetest.sendKey(By.name("a5_min"), "2010");
		basetest.sendKey(By.name("a5_max"), "2017");
		basetest.click(By.cssSelector("[tabindex=\"3\"]"));
		basetest.click(By.cssSelector("[tabindex=\"10\"]"));
		basetest.click(By.cssSelector("closeCookiePolicy"));
		basetest.click(By.cssSelector(".search-submit"));
	}
}
