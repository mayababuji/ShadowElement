package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MensOuterwearPage {
	private  WebDriver driver;
	//Because Selenium cannot locate Shadow DOM elements with @FindBy,
	//we use getShadowRoot() to traverse shadow boundaries and interact with such elements.”
	
	public MensOuterwearPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	public  void selectMensWear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement shopApp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("shop-app")));
		//WebElement shadowHost = driver.findElement(By.cssSelector("shop-app"));	
		SearchContext shadowRoot = shopApp.getShadowRoot();
		WebElement appHeader = wait.until(driver -> shadowRoot.findElement(By.cssSelector("app-header")));
		SearchContext shpTabs =  wait.until(driver ->appHeader.findElement(By.cssSelector("shop-tabs")));
		WebElement mensOutwearHeader =  wait.until(driver ->shpTabs.findElement(By.linkText("Men's Outerwear")));
		mensOutwearHeader.click();
		
		
	}

}
