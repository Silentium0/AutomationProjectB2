package com.loop.test.day5_TestNG_checkBox_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Arrays;

public class T0_RadioButton {

    public static void main(String[] args) throws InterruptedException {





        String [] arr = {"loop", "api"};
        String [] arrrr = new String[3];
        arrrr[0] = "Loop";
        arrrr[1] = "java";
        arrrr[2] = "ipa";

        String [] rever = new String[3];

        System.out.println(Arrays.toString(arrrr));
        for (int i = arrrr.length -1 ; i >=0 ; i--) {
            rever[i] = arrrr[arrrr.length -1 - i];

        }
        System.out.println(Arrays.toString(rever));











    }
}
