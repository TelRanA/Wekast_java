package ru.telran.sel;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AT10Tests extends ru.telran.home.pages.TestBase {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testAT10() throws Exception {
		openPage();
		clickContactUs();
		fillFeedback(new FillFeedbackParameter("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "dddddddddddddddddddddddddddddddddd@ddddddddddd.dd", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111", "test"));
		clickSend();
		verification();

	}

	public void verification() throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By
						.xpath("//div[@id='wpcf7-f5-p14-o1']/form/div[7]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	public void clickSend() {
		driver.findElement(By.xpath("//input[@value='Send']")).click();
	}

	public void fillFeedback(FillFeedbackParameter parameterObject) {
		driver.findElement(By.name("your-name")).clear();
		driver.findElement(By.name("your-name"))
				.sendKeys(
						parameterObject.name);
		driver.findElement(By.name("your-email")).clear();
		driver.findElement(By.name("your-email")).sendKeys(
				parameterObject.email);
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone"))
				.sendKeys(
						parameterObject.phone);
		driver.findElement(By.name("your-message")).clear();
		driver.findElement(By.name("your-message")).sendKeys(parameterObject.text);
	}

	public void clickContactUs() throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 180)
				fail("timeout");
			try {
				if (isElementPresent(By.linkText("Contact Us")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(3000);
		}

		driver.findElement(By.linkText("Contact Us")).click();
	}

	public void openPage() {
		driver.get(baseUrl + "/");
		try {
			isPageOpen();
			}
		catch(Exception e){};
	}
	
	public void isPageOpen() throws Exception{
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.linkText("Contact Us"))) break; } 
	    	catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
