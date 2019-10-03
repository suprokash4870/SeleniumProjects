package ebay;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenShot {
    WebDriver driver;

    @BeforeTest
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://www.amazon.com");
    }

    @Test
    public void getScreenshot(){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("src\\main\\resources\\ScreenShot\\new.png"));
        }
        catch (IOException e){
            System.out.println("Show message: "+e.getMessage());
        }
    }

    @AfterTest
    public void CloseApp(){
        driver.quit();
    }
}
