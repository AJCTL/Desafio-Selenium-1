package pageobjects.shoppingcar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCarPage {

    private By shoppingCar = By.id("shopping_cart_container");
    private By inventoryItem = By.className("inventory_item");
    private By inventoryItemName = By.className("inventory_item_name");
    private By btnAddToCart = By.tagName("button");
    private By titleYourCart = By.xpath("//span[@class='title' and text()='Your Cart']");

    private WebDriver driver;

    String productName = "Sauce Labs Bike Light";

    public ShoppingCarPage(WebDriver driver){
        this.driver = driver;
    }

    public void addItemShoppingCar(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> products = driver.findElements(inventoryItem);

        for(WebElement product : products){

            String name = product.
                    findElement((inventoryItemName))
                    .getText();

            if(name.equals(productName)){
                product.findElement(btnAddToCart).click();
                break;
            }
        }

        this.driver.findElement(shoppingCar).click();

        WebElement titleCar = wait.until(ExpectedConditions.visibilityOfElementLocated(titleYourCart));
        assertEquals("Your Cart",titleCar.getText());

        WebElement productInCar = wait.
                until(ExpectedConditions.visibilityOfElementLocated(inventoryItemName));
        assertEquals(productName, productInCar.getText());

    }
}
