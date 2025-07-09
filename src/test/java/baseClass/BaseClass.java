package baseClass;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Optional;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//Why @BeforeSuite Doesn't Work with Parameters in TestNG
//Parameter Scope Limitation:
//
//Parameters in testng.xml are scoped to <test> tags
//
//@BeforeSuite runs before any <test> tags are processed
//
//Therefore, parameters aren't available yet during suite-level setup
//@BeforeSuite
//@Parameters("browser")  // Will fail - parameters not available yet


import driverFactory.DriverFactory;
public class BaseClass {
	DriverFactory driverfactory = new DriverFactory();
	protected WebDriver driver;  // make protected for child classes to use
	@BeforeClass
	@Parameters({"browser"})
	public  void setUp(@Optional("chrome") String browser) {
	 
		driverfactory.initialiseDriver(browser);
		 driver = driverfactory.getDriver();  // assign driver instance here
		
		
	}

	
	@AfterClass
	public void tearDown() {
		
		driverfactory.quitDriver();
	}
	

}
