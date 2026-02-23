import base.BaseWebTest;
import org.junit.jupiter.api.Test;
import pageobjects.logins.LoginPage;
import pageobjects.navigate.Navigate;
import pageobjects.shoppingcar.CheckoutPage;
import pageobjects.shoppingcar.ShoppingCarPage;

public class ShoppingCarTest extends BaseWebTest {

    @Test
    public void shoopingCartWorkflowTest(){

        Navigate navigate = new Navigate(driver);
        navigate.navigateToHomePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        ShoppingCarPage shoppingCarPage = new ShoppingCarPage(driver);
        shoppingCarPage.addItemShoppingCar();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutYorInformation();

        checkoutPage.checkoutFinish();

    }

}
