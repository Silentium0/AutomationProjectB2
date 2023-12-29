package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T3_Drag_drop {

        /*
    1- Open a chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
     */

    @Test
    public void dragDrop(){
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.drag"));
        WebElement bang = Driver.getDriver().findElement(By.xpath("//a[.=' BANK ']"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bang,debitAccount).perform();

        WebElement drugMoney = Driver.getDriver().findElement(By.xpath("//a[.=' 5000 ']"));
        WebElement amount = Driver.getDriver().findElement(By.xpath("//ol[@id='amt7']"));
        Actions actions2 = new Actions(Driver.getDriver());
        actions2.dragAndDrop(drugMoney,amount).perform();


        WebElement sales = Driver.getDriver().findElement(By.xpath("//a[.=' SALES ']"));
        WebElement amount5k = Driver.getDriver().findElement(By.xpath("//ol[@id='loan']"));
        actions.dragAndDrop(sales,amount5k).perform();

        WebElement creditAmount = Driver.getDriver().findElement(By.xpath(" //ol[@id='amt8']"));
        actions.dragAndDrop(drugMoney,creditAmount).perform();











    }




}
