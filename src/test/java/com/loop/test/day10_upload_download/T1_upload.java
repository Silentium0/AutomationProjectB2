package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_upload {

        /*
    1. Go to “http://demo.guru99.com/test/upload”
    2. Upload file into Choose File
    3. Click terms of service check box
    4. Click Submit File button
    5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
     */


    @Test
    public void uploadFile(){
        Driver.getDriver().get(ConfigurationReader.getProperty("quru.url"));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
        String path = "C:\\Users\\sergi\\OneDrive\\Desktop\\note2.0.txt";
        chooseFile.sendKeys(path);
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement submit = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submit.click();
        WebElement seccesMessage = Driver.getDriver().findElement(By.id("res"));
        String expected = "1 file\nhas been successfully uploaded.";
        Assert.assertEquals(seccesMessage.getText(),expected);



    }










}
