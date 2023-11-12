package com.loop.test.day1_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        //Thread.sleep(5000); // will open after 5 sec

        driver.manage().window().maximize(); // will open full screen

        driver.navigate().to("https://www.google.com");
        driver.get("https://www.cvs.com");


        driver.navigate().back(); // will come back to the first page

        //driver.navigate().forward();
        driver.navigate().refresh(); // refresh page
        //driver.quit();// will close chrome  after loading
        driver.close();






    }
}
