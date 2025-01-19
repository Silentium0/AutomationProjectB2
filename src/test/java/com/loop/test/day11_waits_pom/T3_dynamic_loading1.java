package com.loop.test.day11_waits_pom;

import com.loop.pages.LoopPracticeDynamicLoading1;
import com.loop.pages.LoopPracticeDynamicLoading1;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T3_dynamic_loading1 {

    LoopPracticeDynamicLoading1 loopPracticeDynamicLoading1;

    @BeforeMethod
    public void setUpMethod(){
        loopPracticeDynamicLoading1 = new LoopPracticeDynamicLoading1();
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
    }




    @Test
    public void dynamic_loading_1(){
        BrowserUtils.loopLinkClick("Dynamic Loading");
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1.dynamicLoading, 5).click();
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1.startButton, 5).click();
        BrowserUtils.waitForInVisibility(loopPracticeDynamicLoading1.loadingBar, 10);
        Assert.assertTrue(loopPracticeDynamicLoading1.username.isDisplayed());
        loopPracticeDynamicLoading1.username.sendKeys(ConfigurationReader.getProperty("dynamicLoading.username"));
        loopPracticeDynamicLoading1.password.sendKeys(ConfigurationReader.getProperty("dynamicLoading.incorrectPassword"));
        loopPracticeDynamicLoading1.submit.click();
        loopPracticeDynamicLoading1.errorMessage.isDisplayed();
    }


}
