package ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ebayTitleVerification {

    WebDriver driver;
    @BeforeTest
    public void setUp(){

        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\Driver\\chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.ebay.com");
    }

    @Test
    public void TitlePageVerification(){
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(actualTitle,expectedTitle);
        System.out.println("Test Passed");
        assertion.assertAll();

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Test is passed");
        }
        else{
            System.out.println("Test is failed");
        }

    }
}
