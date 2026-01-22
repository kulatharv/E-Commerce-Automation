package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.LoginPage;
import base.BaseTest;


public class CheckoutTest extends BaseTest {
	@Test
	public void completeCheckoutTest() {
		
		//Step 1 : Login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user","secret_sauce");
		
		Assert.assertTrue(
				loginPage.isLoginSuccessful(), 
				"Login Failed, Inventory page not loaded"
		);
		
		//Step 2 : Add Product to Cart
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		//Step 3 : Checkout Flow
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.goToCart();
		
		checkoutPage.startCheckout();
		
		checkoutPage.enterCheckoutDetails("Atharv", "Atharv", "410401");
		
		checkoutPage.finishCheckout();
		
		//Step 4 : Verify Order Success
		String successMsg = checkoutPage.getSuccessMessage();
		Assert.assertTrue(
			    successMsg.contains("Thank you for your order"),
			    "Order was not completed successfully"
			);

		
	}
}
