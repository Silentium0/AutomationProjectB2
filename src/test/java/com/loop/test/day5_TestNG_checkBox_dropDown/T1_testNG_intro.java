package com.loop.test.day5_TestNG_checkBox_dropDown;

import org.testng.Assert;
import org.testng.annotations.*;

public class T1_testNG_intro {


    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running START ");
    }

    @AfterClass
    public  void setDown(){
        System.out.println("After class is running END");

    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before Methods is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Methods is running");
    }


    @Test (priority = 1)
    public void test1(){
        System.out.println("test1 is running");
        String actual = "Feyruz";
        String expected = "Feyruz";

        Assert.assertEquals(actual, expected, "Message from Assertion, it will show if test fails");
    }

    @Test (priority = 2)
    public void atest2(){
        System.out.println("test2 is running");
    }











}
