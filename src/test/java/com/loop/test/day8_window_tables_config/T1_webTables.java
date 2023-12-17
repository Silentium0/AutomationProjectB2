package com.loop.test.day8_window_tables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTablesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_webTables extends TestBase {


    @Test
    public void test_webTable() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTablesUtils.returnAnyField(driver,"alex.de.souza@gmail.com","Full name");
        System.out.println(("actual= " + actualFullName));
        Assert.assertEquals(expectedFullName,actualFullName,"TEST FAIL");


        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTablesUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
        Assert.assertEquals(actualUserName,expectedUserName,"Actual does not match expected");


    }




}
