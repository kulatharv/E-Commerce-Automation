/* 
 * package pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	
	WebDriver driver;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack" )
	WebElement addToCartBtn;
	
	//@FindBy(className = "shopping_cart_badge")
	//WebElement cartBadge;
	
	public ProductsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart() {
		addToCartBtn.click();
	}
	
	public String getCartCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
		return cartBadge.getText();
	}
}
 */

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage{
	
	WebDriver driver;
    WebDriverWait wait;

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCartBtn;
	
	By cartBadge = By.className("Shopping_cart_bagde");
    //By inventoryContainer = By.id("inventory_container");

	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void waitForProductsPage() {
        wait.until(ExpectedConditions.urlContains("inventory"));
    }
	
	public void addProductToCart() {
        waitForProductsPage();
		addToCartBtn.click();
	}
	
	public String getCartCount() {
		 WebElement badge = wait.until(
	     ExpectedConditions.visibilityOfElementLocated(cartBadge)
	        
		);
		return badge.getText();
	}
	
	
	
}