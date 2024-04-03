package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void ErrorMessageTest() {
        loginPage.rellenarFormulario("locked_out_user", "secret_sauce");
        loginPage.verificandoMensajeError("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void verifyingLoginPageTest() {
        loginPage.verifyPage();
    }
}
