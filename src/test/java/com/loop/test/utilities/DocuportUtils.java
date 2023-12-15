package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Locale;

public class DocuportUtils {


    /**
     * Login to the Docuport App
     * @param driver , witch initialized int test base
     * @param role,  comes from docuport constants
     * @author Sergii
     */

    public static  void login(WebDriver driver,String role) throws InterruptedException {
        driver.get("https://beta.docuport.app/");
        WebElement userName = driver.findElement(By.xpath("//label[contains(text(), 'Username or email')]/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));


        switch (role.toLowerCase()){
            case "client":
                userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                WebElement loginBUtton = driver.findElement(By.xpath("//button[@type='submit']"));
                loginBUtton.click();
                Thread.sleep(3000);
                WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
                continueButton.click();
                Thread.sleep(3000);
                break;
            case "supervisor":
                userName.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            case "advisor":
                userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            case "employee":
                userName.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            default: throw new InputMismatchException("There are no such Element" + role);

        }
        loginButton.click();


    }

    /**
     * logs out from app
     * @param driver
     * @author sergii
     */


    public static void logOut(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


}
