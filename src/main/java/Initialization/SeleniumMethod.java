package Initialization;

public class SeleniumMethod extends Setup{
    public static void main(String[] args) {
        SetupDriver("windows","https://www.ebay.com","Chrome");

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay" ;
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("pass");
        }
        else{
            System.out.println("fail");
        }
    }


}




