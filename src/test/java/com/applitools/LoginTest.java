package com.applitools;

import com.applitools.eyes.selenium.fluent.Target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest{
    @Test
    public void loginTest() {
        //Open browser
        driver.get("https://demo.applitools.com/loginBefore.html");
        //driver.get("https://demo.applitools.com/loginAfter.html");

        //Click on the Login button
        driver.findElement(By.id("log-in")).click();

        //eyes.check(Target.window());

        // Assert the error text
        assertEquals("Please enter username and password",
                driver.findElement(By.id("alert")).getText());

        // Assert if username field exists
        assertInstanceOf(WebElement.class, driver.findElement(By.id("username")));

        // Assert username placeholder text
        assertEquals("Enter your username",
                driver.findElement(By.id("username")).getAttribute("placeholder"));

        // Assert username label exists
        assertEquals("Username", driver.findElement(By.xpath("(//label)[1]")).getText());

        // Assert if password field exists
        assertInstanceOf(WebElement.class, driver.findElement(By.id("password")));

        // Assert password placeholder text
        assertEquals("Enter your password",
                driver.findElement(By.id("password")).getAttribute("placeholder"));

        // Assert password label exists
        assertEquals("Password", driver.findElement(By.xpath("(//label)[2]")).getText());

        // Assert if SignIn button field exists
        assertInstanceOf(WebElement.class, driver.findElement(By.id("log-in")));

        // Assert if SignIn button label is "Sign In"
        assertEquals("Sign in", driver.findElement(By.id("log-in")).getText());

        // Assert Remember Me checkbox exists
        assertInstanceOf(WebElement.class, driver.findElement(By.xpath("//input[@class='form-check-input']")));

        // Assert if Remember Me text exists
        assertEquals("Remember Me", driver.findElement(By.xpath("(//label)[3]")).getText());

        // Assert if Twitter button exists
        assertInstanceOf(WebElement.class, driver.findElement(By.xpath("//form/div[3]/div[3]/a[1]/img")));

        // Assert if Facebook button exists
        assertInstanceOf(WebElement.class, driver.findElement(By.xpath("//a[2]//img[1]")));
    }
}
