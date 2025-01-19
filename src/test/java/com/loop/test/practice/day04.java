package com.loop.test.practice;

import com.loop.test.base.TestBase;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class day04 extends TestBase {





    @Test
    public void test() {
        driver.get("https://www.nba.com/");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());

        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='nav-ul']/li"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
    }

    @Test
    public void radioButton() {

        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());

        WebElement red = driver.findElement(By.xpath("//label[text()='Red']/../input"));
        WebElement Green = driver.findElement(By.xpath("//label[text()='Green']/../input"));
        red.click();
        Assert.assertTrue(red.isSelected());
        Green.click();
        //Assert.assertTrue(Green.isEnabled());


    }
          /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */


    @Test
    public void checkbox() {


        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 2')]/preceding-sibling::input/following-sibling::input"));
        checkbox1.click();
        //checkbox2.click();
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        //input[@type='checkbox' and following-sibling::text()[contains(., ' checkbox 1')]]




    }
            /*1. Open Chrome browser
          2. Go to http://the-internet.herokuapp.com/add_remove_elements/
          3. Click to “Add Element” button
          4. Verify “Delete” button is displayed after clicking.
          5. Click to “Delete” button.
          6. Verify “Delete” button is NOT displayed after clicking.
          USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

         */


    @Test
    public void clickbutton(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();
        WebElement delete = driver.findElement(By.xpath("//button[text()='Delete']"));
        Assert.assertTrue(delete.isDisplayed());
        Assert.assertTrue(delete.isDisplayed());
        delete.click();
        try {

        }catch (StaleElementReferenceException s){
            Assert.assertTrue(delete.isDisplayed());
            System.out.println("Not Displayed");
        }






    }


}
