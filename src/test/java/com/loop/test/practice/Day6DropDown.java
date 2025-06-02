package com.loop.test.practice;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6DropDown {
     /*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. go old style select menu
    4. Select Yellow and validate
    5. Select Red and validate
    6. Select White and validate
    Use all Select options. (visible text, value, index)
     */

    @Test
    public void DripDown() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/select-menu");
        Select options = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='oldSelectMenu']")));
        options.selectByIndex(3);
        Assert.assertEquals(options.getFirstSelectedOption().getText(), "Yellow");

        Thread.sleep(1000);
        options.selectByVisibleText("Red");
        Assert.assertEquals(options.getFirstSelectedOption().getText(), "Red");

        Thread.sleep(1000);
        options.selectByValue("5");
        Assert.assertEquals(options.getFirstSelectedOption().getText(), "Black");

//        List<WebElement> list = options.getOptions();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getText());
//        }
//        Assert.assertEquals(list.get(3).getText(),"Yellow");

        for (WebElement option : options.getOptions()){
            System.out.println(option.getText());
            if (option.getText().equals("Green")){
                option.click();
                Assert.assertEquals(option.getText(),"Green");
            }
        }






    }





}
