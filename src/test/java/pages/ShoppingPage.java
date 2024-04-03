package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {
    private final By title = By.xpath("//span[text()='Products']");
    private final By itemSelect = By.cssSelector("select[data-test='product_sort_container']");
    private final By itemList = By.className("inventory_item");

    @Override
    public void verifyPage() {
        final var softAssert = new SoftAssert();

        Logs.info("Verificando la UI de shoppping");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(itemSelect).isDisplayed());
        softAssert.assertEquals(findAll(itemList).size(), 6);
        softAssert.assertAll();
    }
}
