package com.loop.test.day5_checkBox_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_dropDownOption {

    /*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. go old style select menu
    4. Select Yellow and validate
    5. Select Red and validate
    6. Select White and validate
    Use all Select options. (visible text, value, index)
     */


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @AfterMethod
    public void tearDownMethod()  {
       // driver.close();

    }


    @Test
    public void colorTest(){
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        dropDown.selectByIndex(3);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"Yellow");

        dropDown.selectByValue("red");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"Red");

        dropDown.selectByVisibleText("White");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"White");



    }



}
