package com.loop.test.practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day7iframe extends TestBase {


    @Test
    public  void frame(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement middle =driver.findElement(By.xpath("//div[text()='MIDDLE']"));
        Assert.assertEquals(middle.getText(),"MIDDLE");


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement right =driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        Assert.assertEquals(right.getText(),"RIGHT");


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom =driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        Assert.assertEquals(bottom.getText(),"BOTTOM");



















        





    }






}
