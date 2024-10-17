package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParamTest {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browse) {

        switch (browse.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "edge": driver = new InternetExplorerDriver(); break;
            default:System.out.println("Invalid browser");return;
        }

      //  driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testCurrentUrl() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @Test(priority = 2)
    public void testTitle() {

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
