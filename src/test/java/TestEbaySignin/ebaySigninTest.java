package TestEbaySignin;

import Initialization.Base;
import ebay.ebaySignin;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ebaySigninTest extends Base {

    ebaySignin ebaySignin;

@ BeforeMethod
    public void init(){
    ebaySignin = PageFactory.initElements(driver,ebaySignin.class);

    //driver.get("https://www.ebay.com");
}

@Test
    public void SignInVerificationTest(){
    ebaySignin.SignInVerification("ssanyalashok","suprokash8071");
}

@AfterMethod
    public void CloseApp()
{
    driver.quit();
}
}
