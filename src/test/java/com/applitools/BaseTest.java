package com.applitools;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected Eyes eyes;
    private String testName;
    private EyesRunner runner;

    @BeforeEach
    void setup(TestInfo testInfo) {
        // Automatically downloads and configures the correct ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        testName = testInfo.getTestClass().orElseThrow().getName() + "." + testInfo.getTestMethod().orElseThrow().getName();
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.open(driver, "Demo App", testName, new RectangleSize(800, 800));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
        try {
            // End visual testing. Validate visual correctness.
            if (eyes.getIsOpen()) {
                eyes.close(true);
            }
        } finally {
            testName = null;
            // Abort test in case of an unexpected error.
            eyes.abortIfNotClosed();
            runner.getAllTestResults();
        }
    }
}
