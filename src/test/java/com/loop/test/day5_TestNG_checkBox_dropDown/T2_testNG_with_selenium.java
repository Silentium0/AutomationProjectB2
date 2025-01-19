package com.loop.test.day5_TestNG_checkBox_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_testNG_with_selenium {
    WebDriver driver;
    String expected;
    String actual;


    @BeforeMethod
    public void setUPMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(500);
        driver.close();
    }

    @Test
    public void googleTitle(){
        driver.get("http://www.google.com/");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual= driver.getTitle();
        Assert.assertEquals(actual,expected,"Actual: "+actual+" Expected: "+expected);
    }

    @Test
    public  void docuportTitle(){
        driver.get("https://beta.docuport.app");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expected),"Actual does not batch expected");
    }






}
