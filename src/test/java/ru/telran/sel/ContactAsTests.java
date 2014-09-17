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

import ru.telran.home.pages.TestBase;


public class ContactAsTests extends TestBase {
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer () ;
@Test
public void testContactAs () throws Exception {
	
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Вопросы и ответы")).click();
    driver.findElement(By.linkText("Связаться с Нами")).click();
    driver.findElement(By.name("your-name")).clear();
    driver.findElement(By.name("your-name")).sendKeys("alextest");
    driver.findElement(By.name("your-email")).clear();
    driver.findElement(By.name("your-email")).sendKeys("alexsnear.test@gmail.com");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("0587777777");
    driver.findElement(By.name("your-message")).clear();
    driver.findElement(By.name("your-message")).sendKeys("qwertyuiop");
    driver.findElement(By.xpath("//input[@value='Отправить']")).click();
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='wpcf7-f5-p14-o1']/form/div[7]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
}

private boolean isElementPresent (By by) {
try {
driver.findElement (by);
return true;
} catch (NoSuchElementException e) {
return false;
}
}

private String closeAlertAndGetItsText() {
try {
Alert alert = driver.switchTo().alert();
String alertText = alert.getText ();
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