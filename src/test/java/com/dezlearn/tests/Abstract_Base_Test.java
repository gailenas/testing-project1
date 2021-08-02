package com.dezlearn.tests;

import com.dezlearn.lib.App_Lib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Abstract_Base_Test {
    WebDriver driver;
    private App_Lib app;

    @Parameters({"browser", "driverexe"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String driverexe) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverexe);
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverexe);
            driver = new FirefoxDriver();
        }
        app = new App_Lib(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    public App_Lib App() {
        return app;
    }
}
