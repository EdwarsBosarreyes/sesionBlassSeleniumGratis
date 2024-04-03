package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.BaseTest;
import utilities.Logs;

public class ShoppingTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @BeforeMethod
    public void setUp() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        loginPage.rellenarFormulario("standard_user", "secret_sauce");
    }

    @Test
    public void verifyShoppingTest() {
        shoppingPage.verifyPage();
    }
}
