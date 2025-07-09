package pageObjects;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
public class HomePage {
	
	ConfigReader configreader = new ConfigReader();
	private WebDriver driver;
	 
	 public HomePage(WebDriver driver){
		 this.driver = driver;//stores that browser handle.
		// PageFactory.initElements(driver,this);//sets up all the buttons, links, and fields in the helper so you can click or read them easily later.
		 
	 }
	 public void navigateToHome() {

		 String url = configreader.getValue("url");
	
	        driver.get(url);
	    }

}
