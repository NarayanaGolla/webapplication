package com.web.application.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage  {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailTextBox = By.id("username");

    private final By passwordTextBox = By.id("password");

    private final By signInButton = By.cssSelector(".btn__primary--large");

    public void setEmail(String email) {
        sendKeys(emailTextBox, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignIn();
    }

}
