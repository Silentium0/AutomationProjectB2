package com.loop.test.day3_locators_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {


    public static void main(String[] args) {


        // set up driver
        WebDriverManager.chromedriver().setup();


        // driver object
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //driver.quit();
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual Title "+actualTitle+", match expected title "+expectedTitle+" => TEST PASS");
        }else {
            System.out.println("Actual Title " +actualTitle+ " does not match expected title "+expectedTitle+"=> TEST FAIL");
        }


        String expectedURL = "https://www.google.com/";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("Actual Title "+actualURL+", match expected title "+expectedURL+" => TEST PASS");
        }else {
            System.out.println("Actual Title " +actualURL+ " does not match expected title "+expectedURL+"=> TEST FAIL");
        }








        driver.close();












    }


}
