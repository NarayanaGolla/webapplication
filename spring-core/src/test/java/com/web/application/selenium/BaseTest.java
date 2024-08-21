package com.web.application.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.web.application.selenium.DriverHolder.getDriver;
import static com.web.application.selenium.DriverHolder.setDriver;
import static com.web.application.selenium.PropertyFileReader.getProperty;


public class BaseTest {

    @BeforeMethod
    public void before() {
        setDriver(DriverFactory.getNewDriverInstance(getProperty("browser")));
        getDriver().manage().window().maximize();
        getDriver().get(getProperty("application_url"));
    }

    @AfterMethod
    public void after() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
