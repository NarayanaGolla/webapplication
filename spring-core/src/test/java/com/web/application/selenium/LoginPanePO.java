package com.web.application.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Listeners;

//@Listeners({ReportPortalTestNGListener.class})
public class LoginPanePO extends BasePagePO {


    public LoginPanePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement emailTextBox;


    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(css = "#inbContinueWithPersonalAccount > span")
    private WebElement continueWithPersonalAccountButton;

    public void setUsername(String username) {
        sendKeys(emailTextBox, username);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public void clickContinueWithPersonalAccount() {
        click(continueWithPersonalAccountButton);
    }

    public void login(String email, String password) throws InterruptedException {
        setUsername(email);
        setPassword(password);
        clickSignIn();
        clickContinueWithPersonalAccount();
        quit();
    }
}
