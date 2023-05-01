package test.saucedemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    @Test
    public void test_01_successLogin() {
        page.navigate("https://www.saucedemo.com/");
        Assert.assertEquals(page.title(), "Swag Labs");

        LoginPage loginPage = new LoginPage(page);
        loginPage.validatePageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.validatePageUrl("https://www.saucedemo.com/inventory.html");
        productsPage.chooseItemByTitle("Sauce Labs Bolt T-Shirt");
        productsPage.validateCartNumber(1);
        productsPage.chooseItemByTitle("Sauce Labs Bike Light");
        productsPage.validateCartNumber("2");
    }
}
