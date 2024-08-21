package com.web.application.junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestingDemo {

    WebDriver driver = null;

    @Test
    public void car_loan() {
        // Setup WebDriverManager to handle WebDriver binaries
     //   WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91998\\OneDrive\\Desktop\\chrome\\chromedriver.exe");
       driver = new EdgeDriver();
      //  driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.quit();
    }
}
