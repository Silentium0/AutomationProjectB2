package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_JSExecutor_scroll {

    @Test
    public void etsy_scroll_test() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("loop"));
        WebElement linc = Driver.getDriver().findElement(By.xpath("//a[@href='https://www.loopcamp.io/']"));


        // how to scroll to element
        // #1 use actions move to element

        Actions action = new Actions(Driver.getDriver());
        // action.moveToElement(emailBox).perform();
        // action.scrollToElement(emailBox).perform();

        // #2 just use Key press
        // action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // #3 move horizontally or vertically
        // js.executeScript("window.scroll(0, 5000)");

        // #4
        js.executeScript("arguments[0].scrollIntoView(true)", linc);
        js.executeScript("arguments[0].click", linc);
        Thread.sleep(5000);
       // js.executeScript("window.scroll(0, 0)");



    }


}
