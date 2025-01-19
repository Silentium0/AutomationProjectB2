package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T1_find_elements {


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.nba.com");

        List<WebElement> nbaLink = driver.findElements(By.tagName("a"));


        System.out.println("nbaLinks.size() = "+nbaLink.size());

        List<WebElement> nbalinkXpath = driver.findElements(By.xpath("//a"));
        System.out.println("nbalinkXpath : "+nbalinkXpath.size());


        for (WebElement nbaLinks : nbaLink){
            System.out.println("nbaLinks: "+nbaLinks.getText());
            System.out.println("nbaLinks: "+nbaLinks.getAttribute("href"));
        }

        for (int i = 0; i < nbaLink.size(); i++) {
            if (nbaLink.get(i).getText().equals("")){
                System.out.println("NBA Link = "+nbaLink.get(i).getText());
                System.out.println("NBA Link = "+nbaLink.get(i).getAttribute("href"));

            }

        }


    }
}
