package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    WebDriver driver;
    public Checkout(WebDriver driver) {
        this.driver = driver;
    }
    public void fillShippingAddress(String firstName, String lastName, String address1, String address2,
                                     String country, String state, String city, String zipCode, String phone) {
        driver.findElement(By.id("shipping-first-name")).sendKeys(firstName);
        driver.findElement(By.id("shipping-last-name")).sendKeys(lastName);
        driver.findElement(By.id("shipping-address1")).sendKeys(address1);
        driver.findElement(By.id("shipping-address2")).sendKeys(address2);
        driver.findElement(By.id("shipping-country")).sendKeys(country);
        driver.findElement(By.id("shipping-state")).sendKeys(state);
        driver.findElement(By.id("shipping-city")).sendKeys(city);
        driver.findElement(By.id("shipping-zip-code")).sendKeys(zipCode);
        driver.findElement(By.id("shipping-phone")).sendKeys(phone);
    }

    public void selectShippingMethod(String method) {
        driver.findElement(By.xpath("//label[contains(text(),'" + method + "')]")).click();
    }

    public void clickProceedToPayment() {
        driver.findElement(By.id("proceed-to-payment")).click();
    }
    public void fillPaymentDetails(String cardNumber, String expiry, String cvv) {
        driver.findElement(By.id("card-number")).sendKeys(cardNumber);
        driver.findElement(By.id("card-expiry")).sendKeys(expiry);
        driver.findElement(By.id("card-cvv")).sendKeys(cvv);
    }

    public void clickPlaceOrder() {
        driver.findElement(By.id("place-order")).click();
    }

    public boolean isOrderConfirmationVisible() {
        return driver.findElement(By.xpath("//div[contains(text(),'Order confirmed')]")).isDisplayed();
    }
}

