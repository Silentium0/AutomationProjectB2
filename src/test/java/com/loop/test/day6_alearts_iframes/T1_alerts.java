package com.loop.test.day6_alearts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class T1_alerts extends TestBase {


    @Test
    public void start(){
        driver.navigate().to("https://loopcamp.vercel.app/radio-buttons.html");
        WebElement radio = driver.findElement(By.xpath("//input[@id='red']"));
        Assert.assertTrue(radio.isEnabled());
    }

    @Test
    public void dropDown(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByVisibleText("Option 2");
    }


    @Test
    public void dropDown2(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.getFirstSelectedOption().getText();

        List <String> list = new ArrayList<>();


        List <WebElement> listWebElements = dropDown.getOptions();

        for (WebElement listWebElement : listWebElements) {
            System.out.println(list.add(listWebElement.getText()));
        }
    }









}
