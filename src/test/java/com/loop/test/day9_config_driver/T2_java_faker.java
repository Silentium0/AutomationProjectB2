package com.loop.test.day9_config_driver;

import com.github.javafaker.Faker;
import com.loop.test.utilities.Driver;
import org.testng.annotations.Test;

public class T2_java_faker {

    @Test
    public void java_faker(){
        Faker faker = new Faker();
        System.out.println("faker.name().fullName()= "+faker.name().fullName());
        System.out.println(faker.numerify("202-###-###"));
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.chuckNorris().fact());
        System.out.println("faker.letterify(\"?????\") = " + faker.letterify("?????"));


    }
}
