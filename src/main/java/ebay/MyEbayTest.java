package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyEbayTest {
    WebDriver driver;


    @BeforeMethod
    public void driverSetUp(){

        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com");
    }

    @Test
    public void LinkTest(){

        driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();

    }

    @AfterMethod
    public void closeApp(){
        driver.quit();

    }
}
