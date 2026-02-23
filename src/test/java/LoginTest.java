import base.BaseWebTest;
import org.junit.jupiter.api.Test;
import pageobjects.logins.LoginPage;
import pageobjects.navigate.Navigate;

public class LoginTest extends BaseWebTest {

    @Test
    public void loginTest(){

        Navigate navigate = new Navigate(driver);
        navigate.navigateToHomePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

    }

    @Test
    public void loginInvalidTest(){

        Navigate navigate = new Navigate(driver);
        navigate.navigateToHomePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin();

    }
}
