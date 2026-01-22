package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.urlContains("inventory"));
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
