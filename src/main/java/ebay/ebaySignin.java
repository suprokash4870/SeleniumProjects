package ebay;

import Initialization.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ebaySignin extends Base {

    @FindBy(xpath = "//*[@id=\"gh-ug\"]/a")
    WebElement Signin;

    @FindBy(id= "userid")
    WebElement UserId;

    @FindBy(name= "pass")
    WebElement Password;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement SigninButton;

    public void SignInVerification(String uid,String pass){

        Signin.click();
        UserId.sendKeys("");
        Password.sendKeys("");
        SigninButton.click();
    }
}
