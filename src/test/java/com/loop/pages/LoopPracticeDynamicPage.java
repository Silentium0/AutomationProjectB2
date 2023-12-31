package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoopPracticeDynamicPage {
    @FindBy(xpath = "//div[@id='alert']")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement Image;


    public LoopPracticeDynamicPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


}
