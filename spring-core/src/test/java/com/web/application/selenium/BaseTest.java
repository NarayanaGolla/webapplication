package com.training.springboot.selenium;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.driver.DriverFactory;

import static util.driver.DriverHolder.getDriver;
import static util.driver.DriverHolder.setDriver;
import static util.driver.PropertyFileReader.getProperty;

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
