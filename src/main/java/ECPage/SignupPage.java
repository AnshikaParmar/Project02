package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewUserSignupVisible() {
        return driver.findElement(By.cssSelector("your_signup_page_selector")).isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(By.id("signup-button")).click();
    }
    public boolean isEmailAlreadyExistVisible() {
        return driver.findElement(By.xpath("//div[contains(text(), 'Email already exists')]")).isDisplayed();
    }
}

