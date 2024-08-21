package com.training.springboot.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class AmazonWebDriverTest {

    //  ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF.
    private static final Logger logger = LoggerFactory.getLogger(AmazonWebDriverTest.class);

    WebDriver driver = null;

    @Test(priority = 1 )
    public void loadSeleniumDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91998\\OneDrive\\Desktop\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(priority = 2)
    public void loadWebsiteURL() {
        driver.get("https://www.amazon.com/");
    }

    @Test(priority = 3 , enabled = true )
    public void verifySearchAmazonOptions() throws InterruptedException {
        //Maximizing window
        driver.manage().window().maximize();
        Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));

      drpCountry.selectByIndex(2);

//        if(drpCountry.isMultiple()){
//            drpCountry.selectByVisibleText("Baby");// Get all the options of the dropdown
//            List<WebElement> options = drpCountry.getOptions();
//
//            // Get the first selected option of the dropdown
//            WebElement firstSelectedOption = drpCountry.getFirstSelectedOption();
//
//            // Get all the selected option of the dropdown
//            List<WebElement> selectedOptions = drpCountry.getAllSelectedOptions();
//
//            //Deselect all the options
//            drpCountry.deselectAll();
//
//        }

        Thread.sleep(5000);

    }


    @Test(priority = 4 , enabled = true)
    public void maximiseWindow() throws InterruptedException {

       /// driver.manage().window().maximize();

        String title = driver.getTitle();
        logger.info("The page title is {}: " , title);
      //  Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //Adding wait
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Hello ' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Signin' from Menu");

        //Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
        WebElement signInWebElement = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span"));
        signInWebElement.click();
        Thread.sleep(5000);
        //Mouse hover menuOption 'Rock'
       // actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on 'Rock' from Menu");
    }

    @Test(priority = 5 , enabled = true)
    public void very_signin_page() throws Exception {


        WebElement emailorphoneNumber = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        emailorphoneNumber.sendKeys("narayana.golla.aws@gmail.com");

        WebElement continueWebElement = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continueWebElement.click();

        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.sendKeys("JanInfy@2023");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        submit.click();
        Thread.sleep(5000);
        takeSnapShot(driver, "C:\\Users\\91998\\OneDrive\\Desktop\\test.png") ;


    }



    @Test(priority = 6)
    public void closeSeleniumDriver() {

        //Closing browser session
        driver.quit();

    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

}
