package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By cartIcon = By.className("shopping_cart_link");
	By checkoutBtn = By.id("checkout");
	
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By continueBtn = By.id("continue");
	
	By finishBtn = By.id("finish");
	By successMsg = By.className("complete-header");
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void goToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}
	
	public void startCheckout() {
	    wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
	    wait.until(ExpectedConditions.urlContains("checkout-step-one"));
	}
	
	public void enterCheckoutDetails(String fName, String lName, String zip) {

		 // FIRST NAME
	    wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
	    driver.findElement(firstName).click();
	    driver.findElement(firstName).sendKeys(fName);

	    // LAST NAME
	    wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).clear();
	    driver.findElement(lastName).click();
	    driver.findElement(lastName).sendKeys(lName);

	    // POSTAL CODE (KEY FIX)
	    wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode)).clear();
	    driver.findElement(postalCode).click();
	    driver.findElement(postalCode).sendKeys(zip);

	    // 🔴 WAIT UNTIL ZIP IS REALLY ENTERED
 

	    // CONTINUE
	    wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

		/*
	    // FIRST NAME
	    WebElement fNameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
	    fNameEl.click();
	    fNameEl.clear();
	    fNameEl.sendKeys(fName);

	    // LAST NAME (MUST COME BEFORE POSTAL CODE)
	    WebElement lNameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
	    lNameEl.click();
	    lNameEl.clear();
	    lNameEl.sendKeys(lName);

	    // POSTAL CODE
	    WebElement zipEl = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode));
	    zipEl.click();
	    zipEl.clear();
	    zipEl.sendKeys(zip);

	    // SAFETY CHECK (VERY IMPORTANT)
	    if (zipEl.getAttribute("value").isEmpty()) {
	        throw new RuntimeException("Postal Code not entered properly");
	    }

	    // CONTINUE
	    wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
*/
	}




	
	public void finishCheckout() {

	    // Wait until Step Two page is loaded
	    wait.until(ExpectedConditions.urlContains("checkout-step-two"));

	    wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
	}

	
	public String getSuccessMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
	}
}
