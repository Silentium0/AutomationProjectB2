package com.loop.test.practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Login {

    Set<Cookie> cookies;
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginFirst() {
        driver.get("https://beta.docuport.app/login?redirect=%2F");

        WebElement userName = driver.findElement(By.xpath("//label[text()='Username or email']/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
        WebElement login = driver.findElement(By.xpath("//span[normalize-space(text())='Log in']"));

        userName.sendKeys("b1g3_advisor@gmail.com");
        password.sendKeys("Group3");
        login.click();


        cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
    }

    @Test(dependsOnMethods = "loginFirst")
    public void loginWithCookie() {
        driver.get("https://beta.docuport.app/login?redirect=%2F");

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        driver.navigate().refresh();
        // Validate user is logged in (optional)
    }








}
