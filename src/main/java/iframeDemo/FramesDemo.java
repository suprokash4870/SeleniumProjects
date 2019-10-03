package iframeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesDemo {


    @Test
    public void testFrames(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("www.ebay.com");
        driver.switchTo().frame("-1");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().defaultContent();
    }
}
