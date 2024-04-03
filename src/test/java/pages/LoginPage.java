package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    public void verifyPage() {

        Logs.info("Verificando la pagina del login");
        final var softAssert = new SoftAssert();

        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    public void rellenarFormulario(String username, String password) {
        Logs.info("Escribiendo en el username");
        find(usernameInput).sendKeys(username);

        Logs.info("Escribiendo en el password");
        find(passwordInput).sendKeys(password);

        Logs.info("Clickeando Login button");
        find(loginButton).click();
    }

    public void verificandoMensajeError(String texto) {
        final var softAssert = new SoftAssert();

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(find(errorMessage).isDisplayed());
        softAssert.assertEquals(find(errorMessage).getText(), texto);

        softAssert.assertAll();
    }

}
