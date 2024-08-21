package com.web.application.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePagePO {

    public static WebDriver driver;
    private WebDriverWait wait;

    public BasePagePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,  Duration.ofSeconds(60)); // Wait for a maximum of 10 seconds
        PageFactory.initElements(driver, this);
    }

    public void sendKeys(WebElement webElement, String text) {
        waitUntilElementVisible(webElement);
        webElement.sendKeys(text);
    }
    public void click(WebElement webElement) {
        waitUntilElementClickable(webElement);
        webElement.click();
    }

    public void waitUntilElementClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private void waitUntilElementVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void quit() {
        // Close the browser
        driver.quit();
    }
}
