package automation;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class PrimerosTests extends BaseTest {
    @Test
    public void primerTest() {
        Logs.info("navegar a la pagina");
        driver.get("https://www.saucedemo.com/");

        final var url = driver.getCurrentUrl();

        Logs.info("Verificando la url");
        Assert.assertEquals(url, "https://www.saucedemo.com/");

    }

    @Test
    public void segundoTest() {
        Logs.info("Navegar a internet heroku app");
        driver.get("https://the-internet.herokuapp.com/");

        Logs.info("Navego a github");
        driver.get("https://github.com/");

        Logs.info("Regresando a la pagina anterior");
        driver.navigate().back();

        final var url = driver.getCurrentUrl();

        Logs.info("Verificando la url");
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/");
    }
}
