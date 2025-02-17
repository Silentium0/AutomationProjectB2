package com.loop.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {
        }

    /*
    making driver instance private
    static - run before everything else and also use in static method
     */

        private static WebDriver driver;

    /*
    reusable method that will return the same driver instance every time called
     */

        /**
         * singleton pattern
         *
         * @return driver
         */
        public static WebDriver getDriver() {
            if (driver == null) {
                String browserType = ConfigurationReader.getProperty("browser");
                switch (browserType.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
            return driver;
        }

        /**
         * closing driver
         *
         *
         */
        public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

