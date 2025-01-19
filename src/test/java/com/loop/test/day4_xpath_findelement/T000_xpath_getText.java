package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_xpath_getText {

         /*
    1. Open Chrome browser
    2. Go to docuport
    3. Click on forgot password
    4. validate URL contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate cancel button is displayed
    8. validate send button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://app.docuport.app/login?redirect=%2F");
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        String actualURLForResetPassword = driver.getCurrentUrl();

        if (actualURLForResetPassword.contains(DocuportConstants.RESET_PASSWORD_URL)){
            System.out.println("Actual URL: "+actualURLForResetPassword+" expected URL: "+DocuportConstants.RESET_PASSWORD_URL+" TEST PASS");
        }else {
            System.out.println("Actual URL: "+actualURLForResetPassword+" expected URL: "+DocuportConstants.RESET_PASSWORD_URL+" TEST FAIL");

        }

        WebElement validateMassage = driver.findElement(By.xpath("//div[@class='v-messages__message']"));
        String actualValidateMassage = validateMassage.getText();

        if (actualValidateMassage.contains(DocuportConstants.RESET_PASSWORD_MASSAGE)){
            System.out.println("Actual MASSAGE: \""+actualValidateMassage+"\": expected MASSAGE: "+DocuportConstants.RESET_PASSWORD_MASSAGE+" TEST PASS");

        }else {
            System.out.println("Actual MASSAGE: \""+actualValidateMassage+"\": Expected MASSAGE: "+DocuportConstants.RESET_PASSWORD_MASSAGE+" TEST FAIL");

        }

        WebElement emailInputBox = driver.findElement(By.xpath("//input [contains(@id,'input')] "));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        WebElement cancelButton = driver.findElement(By.xpath("//span[text()=' Cancel '] "));
        WebElement sendButton = driver.findElement(By.xpath("//span[text()=' Send '] "));

        if (cancelButton.isDisplayed()){
            System.out.println("TEST PASS: CANCEL BUTTON  IS DISPLAYED");
        }else {
            System.out.println("TEST FAIL: CANCEL BUTTON  IS NOT DISPLAYED");

        }


        if (sendButton.isDisplayed()){
            System.out.println("TEST PASS: SEND BUTTON  IS DISPLAYED");
        }else {
            System.out.println("TEST FAIL: SEND BUTTON  IS NOT DISPLAYED");

        }

        Thread.sleep(1000);

        sendButton.click();

        Thread.sleep(2000);



        WebElement successMassage = driver.findElement(By.xpath("//span[@class='body-1']"));
        System.out.println(successMassage.getText());



//        try {
//
//        }catch (StaleElementReferenceException e ){
//            System.out.println("Element is not there");
//        }















    }
}
