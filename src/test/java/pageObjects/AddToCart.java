package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	private WebDriver driver;
	public AddToCart(WebDriver driver){
		this.driver = driver;
		
	}
	public  String addToCart() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//click on Men's Tech Shell Full-Zip
				WebElement link = wait.until(driver1 -> (WebElement) js.executeScript(
				    "return document.querySelector('shop-app').shadowRoot.querySelector('iron-pages').querySelector('shop-list').shadowRoot.querySelector('ul.grid li a');"
				));
				link.click();
				

		//add to cart Men's Tech Shell Full-Zip
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement addcart = (WebElement) js.executeScript("return document.querySelector('shop-app').shadowRoot.querySelector('iron-pages').querySelector('shop-detail').shadowRoot.querySelector('button[aria-label=\"Add this item to cart\"]')");
		wait.until(ExpectedConditions.elementToBeClickable(addcart)).click();
		//This is a Java Lambda Expression.
		 String label = wait.until(driver1 -> {
             String text = (String) js.executeScript(
                 "return document.querySelector('shop-app').shadowRoot" +
                 ".querySelector('shop-cart-modal').shadowRoot" +
                 ".querySelector('.label').innerText;"
             );
             return(text!=null&& !text.trim().isEmpty())?text:null;
         });
		 return label;
	}
public void goToCart() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    // Find shop-app element and get shadow root
    WebElement shopApp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("shop-app")));
    SearchContext shopAppShadow = shopApp.getShadowRoot();

    // Inside shop-app shadow root, find app-header
    WebElement appHeader = shopAppShadow.findElement(By.cssSelector("app-header"));

  
    WebElement appToolbar = appHeader.findElement(By.cssSelector("app-toolbar"));
   
    WebElement cartLink = appHeader.findElement(By.cssSelector("a[href='/cart']"));


    cartLink.click();

    
    
		
	}
public void closeWindow() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement shopapp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("shop-app")));
	SearchContext shopAppShadow = shopapp.getShadowRoot();
	WebElement shpCart = shopAppShadow.findElement(By.cssSelector("shop-cart-modal"));
	SearchContext shpCartshadow = shpCart.getShadowRoot();
	WebElement shpButton = shpCartshadow.findElement(By.cssSelector("paper-icon-button"));
	shpButton.click();
	 js.executeScript("window.scroll(0,0)");
}

	
	
}
