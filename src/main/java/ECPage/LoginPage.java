package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUser(String email, String password) {
        driver.findElement(By.id("login-email")).sendKeys(email);
        driver.findElement(By.id("login-password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElement(By.id("welcome-message")).isDisplayed();
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElement(By.id("login-error-message")).isDisplayed();
    }
    public boolean isLoginButtonVisible() {
        return driver.findElement(By.id("login-button")).isDisplayed();
    }
}
