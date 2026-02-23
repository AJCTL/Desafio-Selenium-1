import base.BaseWebTest;
import org.junit.jupiter.api.Test;
import pageobjects.logins.LoginPage;
import pageobjects.navigate.Navigate;
import pageobjects.products.ProductPage;

public class ProductTest extends BaseWebTest {

    @Test
    public void orderProductTest(){

        Navigate navigate = new Navigate(driver);
        navigate.navigateToHomePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        ProductPage productPage = new ProductPage(driver);
        productPage.orderProduct();

    }
}
