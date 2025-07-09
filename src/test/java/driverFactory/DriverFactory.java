package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class DriverFactory {

	private static final ThreadLocal<WebDriver>driver = new ThreadLocal<>();
	@SuppressWarnings("deprecation")
	public  void initialiseDriver(String browser) {
		 if (driver.get() != null) {
	            return; // Driver already initialized for this thread
	        }

		 System.out.println("Initializing " + browser + " on thread " + Thread.currentThread().getId());
		 WebDriver webDriver;
		switch(browser.toLowerCase()) {
		case "firefox":
			
			webDriver = new FirefoxDriver();
			break;
		case "edge":
			
			webDriver = new EdgeDriver();
			break;
		case "chrome":
		default:
			
			webDriver = new ChromeDriver();
		
		}
		webDriver.manage().window().maximize();
		driver.set(webDriver);
		//..Wait for the URL... : No, ImplicitWait have no effect on page loading.
		//.For finding the element... : Yes, ImplicitWait will define the coarse of time
		//the WebDriver instance will wait looking out for the element or elements.
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public  WebDriver getDriver() {
		if(driver == null) {
			throw new IllegalStateException("Driver is not initialised call initialiseDriver first ");
		}
		else {
			return driver.get();
		}
	}
	
	public  void quitDriver() {
		if(driver!=null) {
			driver.get().quit();
			driver.remove();
			
		}
	}

}
