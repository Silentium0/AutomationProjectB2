package com.loop.test.day9_config_driver;

import org.testng.annotations.Test;

public class T00_singleton_practice {


    @Test
    public void practice(){
        String str = T00_singleton_pattern_example.getWord();
        System.out.println("str1 = "+str);

        System.out.println("________________");
        String str2 = T00_singleton_pattern_example.getWord();
        System.out.println("str2 = "+str2);
    }
}
