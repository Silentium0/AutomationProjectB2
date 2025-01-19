package com.loop.test.day8_window_tables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_webTables extends TestBase {


    @Test
    public void test_webTable() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        DocuportUtils.login(Driver.getDriver(), DocuportConstants.ADVISOR);
        WebElement users = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTablesUtils.returnAnyField(Driver.getDriver(),"alex.de.souza@gmail.com","Full name");
        System.out.println(("actual= " + actualFullName));
        Assert.assertEquals(actualFullName, expectedFullName,"TEST FAIL");


        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTablesUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
        Assert.assertEquals(actualUserName,expectedUserName,"Actual does not match expected");


    }
    @Test
    public void validation() throws InterruptedException {
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        WebElement password =  driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton =  driver.findElement(By.xpath("//button[@type='submit']"));

        userName.sendKeys("b1g3_advisor@gmail.com");
        password.sendKeys("Group3");
        loginButton.click();
        WebElement user = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        user.click();
        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTablesUtils.returnAnyField(driver,"alex.de.souza@gmail.com","Full name");
        System.out.println(("actual= " + actualFullName));
        Assert.assertEquals(actualFullName, expectedFullName,"TEST FAIL");


        String expectedUserName = "maryanna.vonrueden@hotmail.com";
        String actualUserName = DocuportWebTablesUtils.returnAnyField(driver,"maryanna.vonrueden@hotmail.com", "username");
        Assert.assertEquals(actualUserName,expectedUserName,"Actual does not match expected");

        String expected = "+994512060042";
        String actual = DocuportWebTablesUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "phone number");
        System.out.println(actual);
        Assert.assertEquals(expected,actual , "Actual does not match expected");


    }

    @Test
    public void test_webTable1() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));


    }

}
