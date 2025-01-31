package com.loop.test.practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends TestBase {

    @Test
    public void login(){
        Driver.getDriver().get("https://beta.docuport.app/login?redirect=%2F");
        WebElement userName = Driver.getDriver().findElement(By.xpath("//label[text()='Username or email']/following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
        WebElement login = Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='Log in']"));

        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
        password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
        login.click();
    }
    @Test
    public void liginAndOut() throws InterruptedException {
        DocuportUtils.login(driver,"advisor");
        DocuportUtils.logOut(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DocuportUtils.login(driver,"supervisor");
        DocuportUtils.logOut(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DocuportUtils.login(driver,"employee");
        DocuportUtils.logOut(driver);


    }
}
