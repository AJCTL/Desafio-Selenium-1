import base.BaseWebTest;
import org.junit.jupiter.api.Test;
import pageobjects.logins.LoginPage;
import pageobjects.navigate.Navigate;
import pageobjects.shoppingcar.ShoppingCarPage;

public class ItemShoppingCarTest extends BaseWebTest {

    @Test
    public void addItemShoppingCarTest(){

        Navigate navigate = new Navigate(driver);
        navigate.navigateToHomePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        ShoppingCarPage shoppingCarPage = new ShoppingCarPage(driver);
        shoppingCarPage.addItemShoppingCar();

    }
}
