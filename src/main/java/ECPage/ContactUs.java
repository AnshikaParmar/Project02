package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {
    WebDriver driver;
    WebDriverWait wait;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
        
    }

    public void fillContactForm(String name, String email, String message) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-name")));
        nameField.sendKeys(name);

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-email")));
        emailField.sendKeys(email);

        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-message")));
        messageField.sendKeys(message);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("contact-submit")));
        submitButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));
            return successMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
            return errorMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}

