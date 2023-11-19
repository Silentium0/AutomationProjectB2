package com.loop.test.day3_locators_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");
        driver.manage().window().maximize();

        // locate element


        WebElement searchBoxWithId = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement searchLink = driver.findElement(By.linkText("About"));

        //searchLink.click();
        // string with what we want to search
        searchBoxWithId.sendKeys("Amazon is cool");
        searchBoxWithId.clear();
        String textToSearch = "Loop Academy";
        searchBoxWithId.sendKeys(textToSearch + Keys.ENTER);


        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains("Loop")){
            System.out.println("contains URL \"Loop\" ");
        }else {
            System.out.println("Not contains URL  \"Loop\" ");
        }











    }
}
