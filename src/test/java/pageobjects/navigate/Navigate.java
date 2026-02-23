package pageobjects.navigate;

import org.openqa.selenium.WebDriver;

public class Navigate {

    private WebDriver driver;

    public  Navigate(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToHomePage(){
        this.driver.get("https://www.saucedemo.com/");
    }

}
