package com.loop.test.day5_checkBox_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T0_RadioButton {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        // isSelected()

        System.out.println(red.isSelected() + " before clicking");
        red.click();
        Thread.sleep(5000);
        System.out.println(red.isSelected() + " after clicking");
        green.click();

        // isEnabled
        System.out.println(red.isEnabled() + " checking if enabled");
        System.out.println(green.isEnabled() + " checking if enabled");









    }
}
