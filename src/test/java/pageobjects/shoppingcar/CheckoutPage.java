package pageobjects.shoppingcar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutPage {

    private WebDriver driver;
    private By btnCheckout = By.id("checkout");
    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputPostalCode = By.id("postal-code");
    private By btnContinue = By.id("continue");
    private By checkoutOverview = By.xpath("//span[@class='title' and text()='Checkout: Overview']");
    private By btnFinish = By.id("finish");
    private By msgConfirm = By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']");

    private String firstName = "Alejandro";
    private String lastName = "Contreras";
    private String postalCode= "454454";

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkoutYorInformation(){

        this.driver.findElement(btnCheckout).click();
        this.driver.findElement(inputFirstName).sendKeys(firstName);
        this.driver.findElement(inputLastName).sendKeys(lastName);
        this.driver.findElement(inputPostalCode).sendKeys(postalCode);
        this.driver.findElement(btnContinue).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement title_chekout = wait.
                until(ExpectedConditions.visibilityOfElementLocated(checkoutOverview));
        assertEquals("Checkout: Overview", title_chekout.getText());

    }

    public void checkoutFinish(){

        this.driver.findElement(btnFinish).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement msg_confirm = wait.
                until(ExpectedConditions.visibilityOfElementLocated(msgConfirm));

        assertEquals("Thank you for your order!", msg_confirm.getText());
    }


}
