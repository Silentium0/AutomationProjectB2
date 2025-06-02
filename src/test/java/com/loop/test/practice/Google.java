package com.loop.test.practice;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Google {


    @Test
    public void testGoogle() {
        Driver.getDriver().get("http://www.google.com");
        WebElement  googleSearch  = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement  Search  = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(googleSearch).perform();
        actions.moveToElement(Search).perform();
        actions.sendKeys(Keys.F12).perform();
        actions.sendKeys(Keys.F5).perform();


    }
}
