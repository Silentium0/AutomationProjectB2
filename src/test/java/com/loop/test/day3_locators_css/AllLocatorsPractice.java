package com.loop.test.day3_locators_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://loopcamp.vercel.app/registration_form.html");

        driver.manage().window().maximize();


        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("loop");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Academy");


        WebElement gender = driver.findElement(By.name("gender"));
        gender.click();









    }
}
