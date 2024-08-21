package com.web.application.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;


public class RemoteWebDriverExample {
    public static void main(String[] args) {

        WebDriver driver = null;
        try {
            // URL to the Selenium Grid hub
            URL remoteURL = new URL("http://localhost:4444/wd/hub");

            // Chrome options
            ChromeOptions options = new ChromeOptions();

            // Initialize RemoteWebDriver
            driver = new RemoteWebDriver(remoteURL, options);

            // Navigate to a website
            driver.get("https://www.google.com");

            // Perform your test actions here

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

