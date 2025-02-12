package com.loop.test.practice;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Upload {

          /*
    1. Go to “http://demo.guru99.com/test/upload”
    2. Upload file into Choose File
    3. Click terms of service check box
    4. Click Submit File button
    5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
    */

    @Test
    public void upload() {
        Driver.getDriver().get("https://demo.guru99.com/test/upload/");
        WebElement upload = Driver.getDriver().findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));
        String file = "C:\\Users\\sergi\\OneDrive\\Desktop\\Replite.txt";
        upload.sendKeys(file);
        WebElement checkBOx = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        checkBOx.click();
        WebElement submit = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submit.click();
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//h3[@id='res']"));
        String expected = "1 filehas been successfully uploaded.";
        assertEquals(expected, successMessage.getText());


    }
}
