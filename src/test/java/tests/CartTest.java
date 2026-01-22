package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
            loginPage.isLoginSuccessful(),
            "Login failed, inventory page not loaded"
        );

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        String count = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(count, "1");
    }
}
