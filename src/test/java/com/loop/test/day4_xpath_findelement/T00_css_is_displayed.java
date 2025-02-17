package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T00_css_is_displayed {

    /*
    http://the-internet.herokuapp.com/forgot_password
     */


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgetPasswordHeading  = driver.findElement(By.cssSelector("div[class='example']>h2"));



        if (forgetPasswordHeading.isDisplayed()){
            System.out.println("Forgot password is Displayed: "+forgetPasswordHeading.isDisplayed());
        }else {
            System.out.println("Forgot password  is NOT Displayed: "+forgetPasswordHeading.isDisplayed());
        }






    }
}
