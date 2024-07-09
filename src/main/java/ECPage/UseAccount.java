package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UseAccount {
    WebDriver driver;
    public UseAccount(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoggedInAsVisible(String userName) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + userName + "')]")).isDisplayed(); // Update with your actual locator
    }

    public void clickLogoutButton() {
        driver.findElement(By.cssSelector("#logout-button")).click(); // Ensure this is the correct locator
    }

    public void clickDeleteAccountButton() {
        driver.findElement(By.id("delete-account-button")).click();
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(By.xpath("//div[contains(text(), 'ACCOUNT DELETED!')]")).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(By.id("continue-button")).click();
    }
}
