package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
	private WebDriver driver;
	public Checkout(WebDriver driver) {
		this.driver = driver;
	}
	public void checkout() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));

		 WebElement shopApp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("shop-app")));
	        SearchContext shopAppShadow = shopApp.getShadowRoot();
	        WebElement ironPages =  wait.until(driver -> shopAppShadow.findElement(By.cssSelector("iron-pages")));
	        WebElement shopCart = wait.until(driver -> ironPages.findElement(By.cssSelector("shop-cart")));
	        SearchContext shopCartShadow = shopCart.getShadowRoot();
	        WebElement shopButton = wait.until(driver -> shopCartShadow.findElement(By.cssSelector("shop-button")));
	        WebElement checkout = wait.until(driver -> shopButton.findElement(By.cssSelector("a[href=\"/checkout\"]")));
	        checkout.click();
	}
	
}
