package ECPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;
  
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
   
    public void clickAddToCart(String productName) {
        driver.findElement(By.xpath("//h2[contains(text(),'" + productName + "')]//following::button[text()='Add to Cart'][1]")).click();
    }

    public void clickRemoveFromCart(String productName) {
        driver.findElement(By.xpath("//h2[contains(text(),'" + productName + "')]//following::button[text()='Remove'][1]")).click();
    }

    public int getTotalItemsInCart() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='cart-item']"));
        return items.size();
    }

    public void clickProceedToCheckout() {
        driver.findElement(By.id("proceed-to-checkout")).click();
    }
}

