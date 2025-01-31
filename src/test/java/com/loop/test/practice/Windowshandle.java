package com.loop.test.practice;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.Assertion;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class Windowshandle extends TestBase {

        /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

    @Test
    public void testWindowshandle() {
        driver.get("http://the-internet.herokuapp.com/windows");
        assertEquals(driver.getTitle(), "The Internet");


        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        String windowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle1 : windowHandles) {
            System.out.println(windowHandle1);
            driver.switchTo().window(windowHandle1);
            System.out.println(driver.getTitle());

            if (driver.getTitle().equals("The Internet")) { // this way we specify witch window we want to stop
                break;
            }
        }
    }

















}
