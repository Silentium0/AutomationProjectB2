package com.loop.test.practice;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DocuportPayment {


    @Test
    public void testDocuportPayment() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("DocpPay"));
        Assert.assertEquals(Driver.getDriver().getTitle(), "Docuport");
        WebElement radioCorp = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Corporation')]/../div/i/following-sibling::div"));
        radioCorp.click();
        WebElement formState = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Virginia')]/../div/i/following-sibling::div"));
        formState.click();
        WebElement compName = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Legal Company Name  *')]/following-sibling::input"));
        compName.sendKeys("Sunnto");
        WebElement dBa = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'DBA (Doing Business As)')]/following-sibling::input"));
        dBa.sendKeys("Manager");
        WebElement industry = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Indus')]/../div[2]"));
        industry.click();
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@role='listbox']/../div/div"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals("Food Services")) {
                list.get(i).click();
            }
        }
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//div[@class='pb-3 border-bottom mb-4']/following-sibling::div/div/div/div/div/div/label/following-sibling::input"));
        firstName.sendKeys("Proctor");
        WebElement lasttName = Driver.getDriver().findElement(By.xpath("//div[@class='pb-3 border-bottom mb-4']/following-sibling::div/div[2]/div/div/div/div/label/following-sibling::input"));
        lasttName.sendKeys("Gambler");
        WebElement email = Driver.getDriver().findElement(By.xpath("//div[@class='pb-3 border-bottom mb-4']/following-sibling::div/div[3]/div/div/div/div/label/following-sibling::input"));
        email.sendKeys("P&G@gmail.com");
        WebElement phone = Driver.getDriver().findElement(By.xpath("//div[@class='pb-3 border-bottom mb-4']/following-sibling::div/div[4]/div/div/div/div/label/following-sibling::input"));
        phone.sendKeys("123456789");
        WebElement fax = Driver.getDriver().findElement(By.xpath("//div[@class='pb-3 border-bottom mb-4']/following-sibling::div/div[5]/div/div/div/div/label/following-sibling::input"));
        fax.sendKeys("987654321");
        WebElement next1 = Driver.getDriver().findElement(By.xpath("//div[@class='v-stepper__items mt-3']/div[1]/div/div/form/div/div[6]/div/button/span"));
        next1.click();
        //Thread.sleep(500);
        //   WebElement companyRadio = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../following-sibling::div/div/div/div/div/div/following-sibling::div/div/div"));
        //  companyRadio.click();
        WebElement firstName2 = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[2]/div/div[1]/div/div/div/div/label/following-sibling::input"));
        firstName2.sendKeys("Bob");
        WebElement lastName2 = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[2]/div/div[2]/div/div/div/div/label/following-sibling::input"));
        lastName2.sendKeys("Smith");
        WebElement middleName = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[2]/div/div[3]/div/div/div/div/label/following-sibling::input"));
        middleName.sendKeys("John");
        WebElement address = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[3]/div/div/div/div/label/following-sibling::input"));
        address.sendKeys("3445 Howard street");
        WebElement city = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[5]/div/div/div/div/label/following-sibling::input"));
        city.sendKeys("London");
        WebElement juristiction = Driver.getDriver().findElement(By.xpath("//label[text()='Jurisdiction *']/following-sibling::div[2]"));
        juristiction.click();
        WebElement amelia = Driver.getDriver().findElement(By.xpath("//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']/div/div[5]"));
        amelia.click();
        WebElement zipp = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[7]/div/div/div/div/label/following-sibling::input"));
        zipp.sendKeys("12345");
        WebElement email2 = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[8]/div/div/div/div/label/following-sibling::input"));
        email2.sendKeys("john@gmail.com");
        WebElement phone2 = Driver.getDriver().findElement(By.xpath("//h4[text()=' Agent type ']/../../../div[9]/div/div/div/div/label/following-sibling::input"));
        phone2.sendKeys("987654321");
        WebElement next2 = Driver.getDriver().findElement(By.xpath("//h4[text()=' Choose Business Address ']/../../following-sibling::div/div/button[2]/span"));
        next2.click();
        Thread.sleep(1000);
        WebElement dropDown = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Title *')]/../div/following-sibling::div[2]/div/i"));
        dropDown.click();
        WebElement vicePdesident = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Vice President')]/../../div/div/div/i"));
        vicePdesident.click();
        WebElement cross = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Title *')]/../div/following-sibling::div[2]/div/i"));
        cross.click();
        WebElement firsName2 = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/div/form/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/input"));
        firsName2.sendKeys("Bob");
        WebElement lsName2 = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/div/form/div/div[2]/div[2]/div[1]/div/div[3]/div/div/div[1]/div/input"));
        lsName2.sendKeys("Smith");
        WebElement midName2 = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/div/form/div/div[2]/div[2]/div[1]/div/div[3]/div/div/div[1]/div/input"));
        midName2.sendKeys("John");
        WebElement owner = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Owner')]/following-sibling::input"));
        owner.sendKeys("4");
        WebElement director = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Are you the director?')]/../div/i/following-sibling::input/following-sibling::div"));
        director.click();
        WebElement ssn = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'SSN of an Organizing Member *')]/following-sibling::input"));
        ssn.sendKeys("123455678");
        WebElement firName = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/div/form/div/div[3]/div/div[2]/div/div/div/div/input"));
        firName.sendKeys("John");
        WebElement lasrName = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/div/form/div/div[3]/div/div[3]/div/div/div[1]/div/input"));
        lasrName.sendKeys("John");
         WebElement goPay = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/div/form/div/div[5]/div/button[2]"));
        goPay.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/div/div/div[2]/div/div[1]/div/div/iframe")));
        WebElement cardNum = Driver.getDriver().findElement(By.xpath("/html/body/div/form/span[2]/div/div/div[2]/span/input"));
        cardNum.sendKeys("1234567890");
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div/div/iframe")));
        WebElement monthDate = Driver.getDriver().findElement(By.xpath("//input[@placeholder='MM/YY']"));
        monthDate.sendKeys("0111");
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/main/main/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/div/div/div[2]/div/div[3]/div/div/iframe")));
        WebElement cvc = Driver.getDriver().findElement(By.xpath("//input[@placeholder='CVC']"));
        cvc.sendKeys("123");
        Driver.getDriver().switchTo().defaultContent();

        WebElement pey = Driver.getDriver().findElement(By.xpath("//span[contains(text(), 'Pay')]"));
        pey.click();





















    }
}
