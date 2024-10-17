package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.time.Duration;

public class DataProviders {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider="dp")
    public void logIn(String email, String password) {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean status = driver.findElement(By.xpath("//a[normalize-space()='Account']")).isDisplayed();
        if (status == true) {
            driver.findElement(By.xpath("//a[normalize-space()='Account']")).click();
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
@AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name="dp",indices = 0)
    Object[][] loginData(){

        Object s[][]={{"pavanol123@gmail.com","test@123"},
                {"pavanol123@gmail.com","test@123"},
                {"pavanol123@gmail.com","tes@123"}};
        return s;
    }
}
