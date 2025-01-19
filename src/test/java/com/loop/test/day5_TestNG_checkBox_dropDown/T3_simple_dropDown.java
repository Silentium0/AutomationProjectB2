package com.loop.test.day5_TestNG_checkBox_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T3_simple_dropDown {

    //1. Open Chrome browse
    //2. Go to http://the-internet.herokuapp.com/dropdown
    //3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”


    WebDriver driver;
    String actual;
    String expected = "Please select an option";

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public  void tearDownMethod(){
        driver.close();
    }

    @Test
    public void dropDownMethod(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected,"Actual does not mach expected");
    }






}
