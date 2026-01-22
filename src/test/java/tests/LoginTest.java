package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void validLoginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		Thread.sleep(3000); // DEBUG wait

	    System.out.println("Current URL after login: " + driver.getCurrentUrl());

		
		//Assertion
		Assert.assertTrue(
				driver.getCurrentUrl().contains("inventory"),
				"Login Failed : Inventory Page Not Loaded"				
		);
		
	}
	@Test
	public void invalidLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "wrong_password");
			
		String error = loginPage.getErrorMessage();
		
		Assert.assertTrue(
				error.contains("Epic sadface"), 
				"Expected error message not displayed"
				);
	}
	

}
