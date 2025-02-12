package com.loop.test.day6_alearts_iframes;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T01_alert extends TestBase {

     /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed


     */





    @Test
    public  void javaAlert(){
        Driver.getDriver().get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJS = Driver.getDriver().findElement(By.xpath(" //button[text()='Click for JS Alert']"));
        clickForJS.click();


        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        WebElement successMassageForInformation = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String actual = "You successfully clicked an alert";
        String expected = successMassageForInformation.getText();
        Assert.assertEquals(actual,expected,"TEST FAIL");

    }


    @Test
    public void confirmationAlert(){
        Driver.getDriver().get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickFroJSConfirm = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickFroJSConfirm.click();
        Driver.getDriver().switchTo().alert().accept();
        WebElement successMassageForInformation = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual =  successMassageForInformation.getText();
        Assert.assertEquals(actual,expected,"TEST FAIL");

        clickFroJSConfirm.click();
        Driver.getDriver().switchTo().alert().accept();
        actual = successMassageForInformation.getText();
        expected = "You clicked: Ok";
        Assert.assertEquals(actual,expected,"TEST FAIL");


        clickFroJSConfirm.click();
        Driver.getDriver().switchTo().alert().dismiss();
        actual = successMassageForInformation.getText();
        expected = "You clicked: Cancel";
        Assert.assertEquals(actual,expected,"TEST FAIL");



    }


    @Test
    public void promptAlert() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSPrompt = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        clickJSPrompt.click();
        String text = "Loop Academy";
//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessagePromptAlert = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String actual = successMessagePromptAlert.getText();
        String expected = "You entered: " + text;
        Assert.assertEquals(actual, expected, "actual does not match the expected");

    }
















}
