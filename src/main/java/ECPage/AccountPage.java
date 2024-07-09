package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnterAccountInformationVisible() {
        return driver.findElement(By.cssSelector("your_account_info_selector")).isDisplayed();
    }

    public void fillAccountDetails(String title, String name, String email, String password, String day, String month, String year) {
        driver.findElement(By.id("account-title")).sendKeys(title);
        driver.findElement(By.id("account-name")).sendKeys(name);
        driver.findElement(By.id("account-email")).sendKeys(email);
        driver.findElement(By.id("account-password")).sendKeys(password);
        driver.findElement(By.id("account-day")).sendKeys(day);
        driver.findElement(By.id("account-month")).sendKeys(month);
        driver.findElement(By.id("account-year")).sendKeys(year);
    }
    public void selectNewsletterCheckbox() {
        driver.findElement(By.id("newsletter")).click();
    }

    public void selectOffersCheckbox() {
        driver.findElement(By.id("offers")).click();
    }
    public void fillPersonalDetails(String firstName, String lastName, String company, String address1, String address2,
                                    String country, String state, String city, String zipCode, String mobileNumber) {
        driver.findElement(By.id("personal-firstname")).sendKeys(firstName);
        driver.findElement(By.id("personal-lastname")).sendKeys(lastName);
        driver.findElement(By.id("personal-company")).sendKeys(company);
        driver.findElement(By.id("personal-address1")).sendKeys(address1);
        driver.findElement(By.id("personal-address2")).sendKeys(address2);
        driver.findElement(By.id("personal-country")).sendKeys(country);
        driver.findElement(By.id("personal-state")).sendKeys(state);
        driver.findElement(By.id("personal-city")).sendKeys(city);
        driver.findElement(By.id("personal-zipCode")).sendKeys(zipCode);
        driver.findElement(By.id("personal-mobileNumber")).sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        driver.findElement(By.id("create-account")).click();
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(By.cssSelector("your_account_created_selector")).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    public boolean isLoggedInAsVisible(String userName) {
        return driver.findElement(By.xpath("//b[contains(text(),'" + userName + "')]")).isDisplayed();
    }
}

