package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ExcelDataDrivenTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "src\\main\\resources\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }


    @Test(dataProvider = "AmazonData")
    public void AmazonSignIn(String userName,String passWord) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span")).click();
        Thread.sleep(5);
        driver.findElement(By.name("email")).sendKeys(userName);
        Thread.sleep(5);
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
        Thread.sleep(5);
        driver.findElement(By.name("password")).sendKeys(passWord);
        Thread.sleep(5);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));

    }

    @AfterMethod
    public void tearDown(){
        // driver.close();
        driver.quit();

    }
    @DataProvider(name="AmazonData")
    public Object[][] passData() throws IOException {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\SSANYALASHOK\\Desktop\\AmazonDataDrivenTest.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data = new Object[rows][2];

        for(int i=1;i<rows;i++){

        data [i][0] = config.getData(0,i,0);
        data [i][1] = config.getData(0,i,1);
        }

        return data;
    }
}
