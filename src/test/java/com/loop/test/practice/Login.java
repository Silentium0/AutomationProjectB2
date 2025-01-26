package com.loop.test.practice;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login {

    @Test
    public void ligin(){
        Driver.getDriver().get("https://beta.docuport.app/login?redirect=%2F");
        WebElement userName = Driver.getDriver().findElement(By.xpath("//label[text()='Username or email']/following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
        WebElement login = Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='Log in']"));

        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
        password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
        login.click();
    }
}
