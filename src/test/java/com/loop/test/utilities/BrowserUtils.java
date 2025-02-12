package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Set;

public class BrowserUtils {
    /**
     * validate if driver switch to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @autor sergii
     * inmplement assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     *
     * switches to the new window bu the exact title
     * return to original window if the window with given title not found
     * @param driver
     * @param  targetTitle
     */


    public static  void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handel:driver.getWindowHandles()){
            driver.switchTo().window(handel);
            if (driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);

    }

    /**
     * @param driver
     * @param expectedTitle
     * return void, assertion is implement
     *
     */

    public static void validateTitle(WebDriver driver,String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }


    /**
     * Click any link from loop practice
     * @param nameOfPage
     */

    public static  void loopLinkClick  (String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    /**
     * Move the mouse to given element
     * @param element on witch to hover
     *
     */

    public static void hoverOver(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scroll down to on element using JavaScript
     * @param element
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Click on element using JavaScript
     * @param element
     *
     */

    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;", element);
    }

    /**
     * Perfrorms double click on the element
     * @param element
     */
    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }


    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nadir
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }
    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nadir
     */

    public static void  waitForInVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }


    public static  WebElement waitForClickable(WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * performs a pause
     * @param seconds
     *
     */
    public static void justWait (int seconds){
        try{
            Thread.sleep(seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static String returnFieldValue(WebDriver driver, String name, String field){
        String index = "";

        if(field.equalsIgnoreCase("Pizza Type")){
            index = "[1]";
        } else if (field.equalsIgnoreCase("Amount")) {
            index = "[2]";
        } else if (field.equalsIgnoreCase("Date")) {
            index = "[3]";
        } else if (field.equalsIgnoreCase("Street")) {
            index = "[4]";
        } else if (field.equalsIgnoreCase("City")) {
            index = "[5]";
        } else if (field.equalsIgnoreCase("State")) {
            index = "[6]";
        } else if (field.equalsIgnoreCase("Zip")) {
            index = "[7]";
        } else if (field.equalsIgnoreCase("Card")) {
            index = "[8]";
        } else if (field.equalsIgnoreCase("Card Number")) {
            index = "[9]";
        } else if (field.equalsIgnoreCase("Exp")) {
            index = "[10]";
        } else {
            System.out.println("There is not such a field: " + field);
        }
        WebElement element = driver.findElement(By.xpath("//td[.='"+name+"']//following-sibling::td"+index));
        return element.getText().trim();

    }

    public static String returnAnyField(WebDriver driver , String cardNumber, String field   ){

        WebElement element = null;
        String xpath = "";

        switch (field.toLowerCase()){
            case "name":
                xpath = "//td[text()='"+cardNumber+"']/preceding-sibling::td[9]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "pizza type":
                xpath = "//td[text()='"+cardNumber+"']/preceding-sibling::td[8]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "amount":
                xpath = "//td[text()='"+cardNumber+"']/preceding-sibling::td[7]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "date":
                xpath = "//td[text()='"+cardNumber+"']/preceding-sibling::td[6]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "street":
                xpath = "//td[text()='"+cardNumber+"']/preceding-sibling::td[5]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "city":
                xpath = "//td[text()='"+cardNumber+"']/preceding-sibling::td[4]";
                element = driver.findElement(By.xpath(xpath));
                break;

            default: throw new InputMismatchException("No such Row"+field);
        }


        return element.getText();
    }

    public static String returnAnyFieldNewSwitch(WebDriver driver, String emailAddress, String field) throws InterruptedException {
        String xpath = switch (field.toLowerCase()) {
            case "fullName" -> "//td[2][text()='" + emailAddress + "']/preceding-sibling::td//span[2]";
            case "username" -> "//td[2][text()='" + emailAddress + "']/following-sibling::td[1]";
            case "inviter" -> "//td[2][text()='" + emailAddress + "']/following-sibling::td[2]";
            case "phoneNumber" -> "//td[2][text()='" + emailAddress + "']/following-sibling::td[3]/span";
            case "role" -> "//td[2][text()='" + emailAddress + "']/following-sibling::td[4]/span/span";
            case "advisor" -> "//td[2][text()='" + emailAddress + "']/following-sibling::td[5]";
            default -> throw new InterruptedException("No such field exists: " + field);
        };

        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText().trim();
    }

    public static void click(String xpath){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[text()='"+xpath+"']"));
        element.click();
    }
    public static void waiteForViz(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public static void waiteForVIN(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }









}
