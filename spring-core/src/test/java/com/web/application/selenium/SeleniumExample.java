package com.web.application.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {
    public static void main(String[] args) {

        // C:\Users\91998\OneDrive\Desktop\chrome
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91998\\OneDrive\\Desktop\\chrome\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\91998\\OneDrive\\Desktop\\chrome\\geckodriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
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

