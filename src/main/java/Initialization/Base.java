package Initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

   public static WebDriver driver;

    public static WebDriver setUpDriver(String platform, String url, String browser){
        if(platform.equalsIgnoreCase("mac")&& browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver");
        }else {
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get(url);

        return driver;
    }
}
