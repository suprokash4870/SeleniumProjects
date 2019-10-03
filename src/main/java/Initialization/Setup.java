package Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Setup {

  public static WebDriver driver = null;
    public static String  OS = null;

    //@BeforeTest

    public static WebDriver SetupDriver(String platform, String url,String browser) {

        if (platform.equalsIgnoreCase("mac")&& browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Driver\\chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Driver\\chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

        return driver;

    }

    //@AfterTest
    public void CloseApp() {

        driver.quit();
    }

    //@Test
    public void faceBookLogInVerificationTest() {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        //driver.findElement(By.xpath("//*[@value='Log In']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void faceBookTitleTest() throws InterruptedException {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(2000);
        Assert.assertEquals(title, "Facebook - Log In or Sign Up");
    }

    //@Test
    public void messangerLinkTest() {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");
        driver.findElement(By.linkText("Messenger")).click();
    }

    //@Test
    public void findFriendsLinkTest() {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");
        driver.findElement(By.linkText("Find Friends")).click();
    }

    //@Test
    public void faceBookLogoTest() {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");
        boolean b = driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i")).isDisplayed();
        Assert.assertTrue(b);
    }

    //@Test
    public void verifyValidUsersCanAbleToSignIn() throws InterruptedException {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");

        driver.findElement(By.name("firstname")).sendKeys("L");
        driver.findElement(By.name("lastname")).sendKeys("Robinson");
        driver.findElement(By.name("reg_email__")).sendKeys("lrobinson@gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("lrobinson123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    //@Test
    public void verifyInvalidUsersWillNotBeAbleToSignIn() throws InterruptedException {
        SetupDriver("Windows", "https://www.facebook.com", "Chrome");
        driver.findElement(By.name("firstname")).sendKeys("abc");
        driver.findElement(By.name("lastname")).sendKeys("******");
        driver.findElement(By.name("reg_email__")).sendKeys("abc@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("abc123456");

        Thread.sleep(2000);



    }

}



