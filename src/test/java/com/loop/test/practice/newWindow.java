package com.loop.test.practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class newWindow extends TestBase {


    @Test
    public void test_new_methods_TAB() {


         driver.get("https://www.google.co.uk/");

        // open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.loopcamp.io");

        // open a new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.etsy.com");

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle1 : windowHandles) {
            System.out.println(windowHandle1);
            driver.switchTo().window(windowHandle1);
            System.out.println(driver.getTitle());

            if (driver.getTitle().toLowerCase().contains("amazon")) { // this way we specify witch window we want to stop
                break;
            }
        }
        //BrowserUtils.switchToWindow(driver,"Google");



    }

    @Test
    public void test_new_methods_Window() {


        driver.get("https://www.google.co.uk/");

        // open a new tab
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.loopcamp.io");

        // open a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.etsy.com");

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle1 : windowHandles) {
            System.out.println(windowHandle1);
            driver.switchTo().window(windowHandle1);
            System.out.println(driver.getTitle());

            if (driver.getTitle().equals("Google")) { // this way we specify witch window we want to stop
                break;
            }
        }
    }
}
