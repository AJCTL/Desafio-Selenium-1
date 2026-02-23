package pageobjects.logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By buttonLogin = By.id("login-button");
    private By titleProducts = By.xpath("//span[@class='title' and text()='Products']");
    private By mesaggeError = By.xpath("//h3[@data-test='error']");

    private String username = "standard_user";
    private String password = "secret_sauce";
    private String invalidUsername = "locked_out_user";



    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(){
        this.driver.findElement(usernameInput).sendKeys(username);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(buttonLogin).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleProductWait = wait.
                until(ExpectedConditions.visibilityOfElementLocated(titleProducts));

        assertEquals("Products", titleProductWait.getText());

    }

    public void invalidLogin(){
        this.driver.findElement(usernameInput).sendKeys(invalidUsername);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(buttonLogin).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement waitMsgError = wait.until(ExpectedConditions.visibilityOfElementLocated(mesaggeError));
        assertEquals("Epic sadface: Sorry, this user has been locked out.", waitMsgError.getText());

    }


}
