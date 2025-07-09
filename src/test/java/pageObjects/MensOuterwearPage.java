package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MensOuterwearPage {
	private  WebDriver driver;
	//Because Selenium cannot locate Shadow DOM elements with @FindBy,
	//we use getShadowRoot() to traverse shadow boundaries and interact with such elements.”
	
	public MensOuterwearPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	public  void selectMensWear() {
		WebElement shadowHost = driver.findElement(By.cssSelector("shop-app"));	
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement appHeader = shadowRoot.findElement(By.cssSelector("app-header"));
		SearchContext shpTabs = appHeader.findElement(By.cssSelector("shop-tabs"));
		WebElement mensOutwearHeader = shpTabs.findElement(By.linkText("Men's Outerwear"));
		mensOutwearHeader.click();
		
		
	}

}
