package com.loop.test.practice;

import com.loop.pages.LoopPracticeDynamicLoading1;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dynamic_Loading {

    LoopPracticeDynamicLoading1 practiceDynamicLoading1;

    @BeforeMethod
            public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
        practiceDynamicLoading1 = new LoopPracticeDynamicLoading1();


    }
    @Test
    public void dynamic_loading_1(){

        BrowserUtils.click("Dynamic Loading");
        BrowserUtils.waitForClickable(practiceDynamicLoading1.dynamicLoading,10).click();
        BrowserUtils.waitForInVisibility(practiceDynamicLoading1.loadingBar, 10);
        Assert.assertTrue(practiceDynamicLoading1.username.isDisplayed());
        practiceDynamicLoading1.username.sendKeys(ConfigurationReader.getProperty("dynamicLoading.username"));
        practiceDynamicLoading1.password.sendKeys(ConfigurationReader.getProperty("dynamicLoading.incorrectPassword"));
        practiceDynamicLoading1.submit.click();
        practiceDynamicLoading1.errorMessage.isDisplayed();
        Assert.assertEquals(practiceDynamicLoading1.errorMessage.getText(),"Your username or password is invalid!");



    }
}
