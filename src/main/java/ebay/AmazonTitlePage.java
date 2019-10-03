package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AmazonTitlePage {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "src\\main\\resources\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void TitleVerification(){
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
       String expectedTitle =  "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(actualTitle,expectedTitle);
        System.out.println("Test is passed");
        assertion.assertAll();

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }

    //@Test(dataProvider = "AmazonData")
    public void AmazonSignIn(String userName,String password){
       driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span")).click();
       driver.findElement(By.name("email")).sendKeys(userName);
       driver.findElement(By.xpath("//*[@type = 'submit']")).click();
       driver.findElement(By.name("password")).sendKeys(password);
       driver.findElement(By.xpath("//*[@type='submit']")).click();
       Assert.assertTrue(driver.getTitle().contains("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));

    }

    @AfterMethod
        public void tearDown(){
       // driver.close();
        driver.quit();

        }
   // @DataProvider(name="AmazonData")
        public Object[][] passData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "admin@hotmail.com";
        data[0][1] = "admin123";

        data[1][0] = "suprokashsanyal@yahoo.com";
        data[1][1] = "ashok4870";

        return data;
        }
    }

