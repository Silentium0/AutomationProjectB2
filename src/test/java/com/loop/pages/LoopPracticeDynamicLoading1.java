package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoading1 {



    @FindBy(xpath = "//a[@href='dynamic_loading/1.html']")
    public WebElement dynamicLoading;


    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "pwd")
    public WebElement password;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[contains(text(),'Your username or password is invalid!')]")
    public WebElement errorMessage;

    public LoopPracticeDynamicLoading1() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
