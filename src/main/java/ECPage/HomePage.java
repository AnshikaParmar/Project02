package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        
    }
    public void navigateToHomePage() {
        driver.get("https://automationexercise.com");
    }

    public boolean isHomePageVisible() {
        return driver.findElement(By.cssSelector("home-page-identifier")).isDisplayed();
    }

    public void clickSignupLogin() {
        driver.findElement(By.id("signup-login-link")).click();
    }
    public void clickTestCases() {
        driver.findElement(By.cssSelector("#test-cases-link")).click();
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(By.cssSelector("#subscription-email")).sendKeys(email);
    }

    public void clickSubscribeButton() {
        driver.findElement(By.cssSelector("#subscribe-button")).click(); // Update with the correct selector for the subscribe button
    }

    public boolean isSubscriptionSuccessMessageDisplayed() {
        return driver.findElement(By.cssSelector("#subscription-success-message")).isDisplayed(); // Update with the correct selector for the success message
    }
}

