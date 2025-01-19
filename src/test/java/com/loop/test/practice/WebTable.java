package com.loop.test.practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebTable extends TestBase {


    @Test
    public void test(){
        driver.get("https://www.nba.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement togle = driver.findElement(By.xpath("//span[@class='Toggle_labelText__XEXij t7']/.."));
        System.out.println(togle.getAttribute("data-is-active"));
        Assert.assertEquals(togle.getAttribute("data-is-active"), "false");


    }
    @Test
    public void radio(){
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        WebElement  yelowButton = driver.findElement(By.xpath("//label[text()='Yellow']/../input"));
        yelowButton.click();
        if (yelowButton.isSelected()){
            System.out.println("Test Pass");
        }else {
            System.out.println("TEst Fail");
        }

    }
    @Test
    public void checkBox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement  yelowButton = driver.findElement(By.xpath("//form[@id='checkboxes']/input/following-sibling::input/preceding-sibling::input"));
        yelowButton.click();
        if (yelowButton.isSelected()){
            System.out.println("Test Pass");
        }else {
            System.out.println("TEst Fail");
        }

    }

    @Test
    public void dropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        List<WebElement> listoption = new ArrayList<>();
        listoption = dropDown.getOptions();

        for (int i = 0; i < listoption.size(); i++) {
            System.out.println(listoption.get(i).getText());
            if (listoption.get(i).getText().equals("Option 1")){
                listoption.get(i).click();
            }
        }


    }


    @Test
    public void alert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }
    @Test
    public void alert2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        alert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
    }
    @Test
    public void alert3(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        alert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Loop");
        alert1.accept();
        Assert.assertEquals(result.getText(),"You entered: Loop","Pass");
    }
    @Test
    public void iframe(){
        driver.get("https://loopcamp.vercel.app/iframe.html");
        driver.switchTo().frame(0);
        WebElement frame = driver.findElement(By.xpath("//body[@id='tinymce']"));
        frame.clear();
        frame.sendKeys("I will Find Job as SDET remote");
    }


    @Test
    public void Window(){
        driver.get("https://www.etsy.com/");
        driver.get("https://www.google.com/");
        driver.get("https://www.amazon.com/");

        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through each window handle
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            String currentUrl = driver.getCurrentUrl();

            // Check if the current URL contains "etsy"
            if (currentUrl.contains("etsy")) {
                break;
            }
        }


    }

    @Test
    public void upload() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement upload = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        upload.sendKeys("C:\\Users\\sergi\\OneDrive\\Desktop\\AWS2.0.txt");
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='terms']"));
        checkBox.click();
        WebElement sublmit = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        sublmit.click();
        WebElement massage = driver.findElement(By.id("res"));
        Thread.sleep(2000);
        Assert.assertEquals(massage.getText(), "1 file\nhas been successfully uploaded.");

        JavascriptExecutor js = (JavascriptExecutor) driver;

    }

    @Test
    public void dropDown1 (){

        driver.get("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select each = new Select(dropdown);
        List<WebElement> listEach = new ArrayList<>();
        listEach = each.getOptions();

        for (int i = 0; i < listEach.size(); i++) {
            if (listEach.get(i).getText().equals("Voilet")){
                listEach.get(i).click();
            }
        }

        each.selectByVisibleText("Black");




    }
    @Test
    public void OnOffButton (){

        driver.get("https://www.nba.com/");
        WebElement button = driver.findElement(By.xpath("//span[@data-pos='true']"));
        Assert.assertEquals(button.getAttribute("data-pos"), "true");

    }

    @Test
    public void webTable (){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String actualName = BrowserUtils.returnAnyField(driver,"777888777888","name");
        System.out.printf(actualName);
        Assert.assertEquals(actualName, "Ned Stark");
    }

    @Test
    public void webTable1 (){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String actualAmount  = BrowserUtils.returnAnyField(driver,"980077987700","amount");
        System.out.printf(actualAmount);
        Assert.assertEquals(actualAmount, "3");
    }

    @Test
    public void webTable2 (){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String actuaStreet = BrowserUtils.returnAnyField(driver,"555743242342","street");
        System.out.printf(actuaStreet);
        Assert.assertEquals(actuaStreet, "13, Owl st.");
    }


    @Test
    public void upload1(){
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement inputField = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        inputField.sendKeys("C:\\Users\\sergi\\OneDrive\\Desktop\\GIT.txt");
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/");
        WebElement scroll = driver.findElement(By.xpath("//a[text()='Web Tables']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
    }











}
