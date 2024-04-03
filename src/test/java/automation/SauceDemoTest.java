package automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;
import utilities.Logs;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginUITest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

//        final var usernameLocator = By.id("user-name");
//        final var passwordLocator = By.id("password");
//        final var loginButtonLocator = By.id("login-button");

        final var softAssert = new SoftAssert();

        Logs.info("Verificando la UI de la pagina");
        softAssert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void LockedUserTest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        Logs.info("Escribiendo en el username");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

        Logs.info("Escribiendo en el password");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Logs.info("Clickeando Login button");
        driver.findElement(By.id("login-button")).click();

        final var errorWebElement = driver.findElement(By.cssSelector("h3[data-test='error']"));

        final var softAssert = new SoftAssert();

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(errorWebElement.isDisplayed());

        Logs.info("Verificando que el texto este bien");
        softAssert.assertEquals(errorWebElement.getText(), "Epic sadface: Sorry, this user has been locked out.");

        softAssert.assertAll();
    }

    @Test
    public void noExistingCredentialsTest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        Logs.info("Escribiendo en el username");
        driver.findElement(By.id("user-name")).sendKeys("test");

        Logs.info("Escribiendo en el password");
        driver.findElement(By.id("password")).sendKeys("test");

        Logs.info("Clickeando Login button");
        driver.findElement(By.id("login-button")).click();

        final var errorWebElement = driver.findElement(By.cssSelector("h3[data-test='error']"));

        final var softAssert = new SoftAssert();

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(errorWebElement.isDisplayed());
        softAssert.assertEquals(errorWebElement.getText(), "Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();
    }

    @Test
    public void verifyShoppingPageTest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        Logs.info("Escribiendo en el username");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Logs.info("Escribiendo en el password");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Logs.info("Clickeando Login button");
        driver.findElement(By.id("login-button")).click();

        final var softAssert = new SoftAssert();

        Logs.info("Verificando la UI de shoppping");
        softAssert.assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")).isDisplayed());
        softAssert.assertEquals(driver.findElements(By.className("inventory_item")).size(), 6);
        softAssert.assertAll();
    }

    @Test
    public void addToCartTest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        Logs.info("Escribiendo en el username");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Logs.info("Escribiendo en el password");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Logs.info("Clickeando Login button");
        driver.findElement(By.id("login-button")).click();

        final var buttonList = driver.findElements(By.className("btn_inventory"));

        Logs.info("Hacer click en los 6 botones de add to cart");
        for (var boton : buttonList) {
            boton.click();
        }

        //Obteniendo el numero como String y lo convierto a int usando Integer.parseInt
        final var numeroActual = Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());


        Logs.info("Verificando que sean 6 elementos");
        Assert.assertEquals(numeroActual, 6);
    }
}
