package com.loop.test.day5_checkBox_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class T5_multi_dropDown {





    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @AfterMethod
    public void tearDownMethod()  {
      driver.close();
    }


    @Test
    public void multiSelect() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        Assert.assertTrue(dropdown.isMultiple());
//        dropDown.selectByIndex(0);
//        Thread.sleep(3000);
//        dropDown.selectByIndex(1);
//        Thread.sleep(3000);
//        dropDown.selectByIndex(2);
//        Thread.sleep(3000);
//        dropDown.selectByValue("saab");
//        Thread.sleep(3000);
//        dropDown.selectByVisibleText("Opel");
//        Thread.sleep(3000);
//        dropDown.selectByIndex(3);

        List <WebElement> options = new ArrayList<>();
        options = dropdown.getOptions();

        options.forEach( option ->{
            option.getText();
            System.out.println("option = " + option.getText());
        });

        for (WebElement option : options) {
            option.click();
            System.out.println(option.getText());
        }

        dropdown.deselectAll();
    }



}
