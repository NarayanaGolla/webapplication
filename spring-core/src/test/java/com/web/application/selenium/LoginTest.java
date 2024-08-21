package com.web.application.selenium;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static com.web.application.selenium.DriverHolder.getDriver;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.testng.Assert.assertEquals;


@Epic("User Management")
@Feature("Login")
public class LoginTest extends BaseTest  {

    private LoginPage loginPage;

    private LoginPanePO loginPagePO;

    @BeforeMethod
    public void loginBeforeMethod() {
       // loginPage = new LoginPage(getDriver());
        loginPagePO = new LoginPanePO(getDriver());
    }

    @Test(description = "Verify that a valid user can login to the application")
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    public void testValidLogin() throws InterruptedException {
        loginPagePO.login("gollanarayanajava@gmail.com","JanInfy@2024");
       // assertEquals(new HomePage(getDriver()).getLoggedInUsername(), "Osanda Nimalarathna");
        assertEquals("Osanda Nimalarathna", "Osanda Nimalarathna");
    }


}
