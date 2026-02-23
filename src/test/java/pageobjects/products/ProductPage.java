package pageobjects.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPage {

    private WebDriver driver;
    private By filter = By.className("product_sort_container");
    private By inventoryItemPrice = By.className("inventory_item_price");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void orderProduct(){

        WebElement filterProduct = this.driver.findElement(filter);
        Select select = new Select(filterProduct);
        select.selectByValue("hilo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItemPrice));

        List<WebElement> priceElements = driver.findElements(inventoryItemPrice);

        String firstPriceText = priceElements.get(0).getText().replace("$", "");
        double firstPrice = Double.parseDouble(firstPriceText);

        String lastPriceText = priceElements.get(priceElements.size() - 1)
                .getText()
                .replace("$", "");
        double lastPrice = Double.parseDouble(lastPriceText);

        assertTrue(firstPrice > lastPrice,
                "El primer producto NO es más caro que el último");

    }

}
