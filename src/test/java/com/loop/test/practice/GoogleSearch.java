package com.loop.test.practice;

import com.loop.test.utilities.Driver;
import org.testng.annotations.Test;

public class GoogleSearch {


    @Test
    public void testGoogleSearch() {
        Driver.getDriver().get("http://www.google.com");

    }
}
