package com.loop.test.day6_alearts_iframes;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_iframe extends TestBase {
    /*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed

     */



    @Test
    public void iframeTest(){
        Driver.getDriver().get("https://loopcamp.vercel.app/iframe.html");
//        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//        driver.switchTo().frame(iframe);

        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        //driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Driver.getDriver().switchTo().frame(0);


        WebElement text = Driver.getDriver().findElement(By.xpath("//*[@id='tinymce']"));
        text.clear();
        text.sendKeys("loop Academy");
        Driver.getDriver().switchTo().defaultContent();
        // driver.switchTo().parentFrame();


        WebElement header = Driver.getDriver().findElement(By.xpath("//h3[contains(text(),'An iFrame containing')]"));
        //String actual = header.getText();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(header.getText(),expected,"TEST FAIL");




        WebElement text2 = Driver.getDriver().findElement(By.xpath("//div[(text()='Powered by ')]"));
        System.out.println(text2.getText());










    }


}


