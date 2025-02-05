package com.loop.test.practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTablesUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DocuportWebTable  {



    @Test
    public void webTable() throws InterruptedException {
        DocuportUtils.login(Driver.getDriver(),"advisor");
        WebElement user = Driver.getDriver().findElement(By.xpath("//span[text()='Users']"));
        user.click();
        Assert.assertEquals(DocuportWebTablesUtils.returnAnyField(Driver.getDriver(),"aldo@gmail.com","phone number"), "1234567890");
        DocuportUtils.logOut(Driver.getDriver());
    }



}
