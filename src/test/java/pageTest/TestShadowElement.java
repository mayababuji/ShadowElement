package pageTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

import baseClass.BaseClass;
import pageObjects.AddToCart;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.MensOuterwearPage;


public class TestShadowElement extends BaseClass {
	HomePage homepage;
	MensOuterwearPage  menswear;
	AddToCart addtocart;
	Checkout checkout;
@BeforeClass
public void initialise() {
	homepage = new HomePage(driver);
  menswear = new  MensOuterwearPage(driver);
  addtocart =new AddToCart(driver);
  checkout = new Checkout(driver);
	
}

	
	@Test
	public void testOpenHome() {
		homepage.navigateToHome();
		String actualUrl = driver.getTitle();
		String expectedUrl = "Home - SHOP";
		Assert.assertEquals(actualUrl, expectedUrl,"URL MisMatch actual url was "+actualUrl+" expected url is "+expectedUrl );
	
	
	}
	@Test
	public void testSelectMensWear() {
		homepage.navigateToHome();
		menswear.selectMensWear();
		Assert.assertTrue(driver.getCurrentUrl().contains("mens_outerwear"), "The url doesn't contain Men's outwear");
	}
	@Test
	public void testaddToCart() {
		homepage.navigateToHome();
		menswear.selectMensWear();
		String label = addtocart.addToCart();
		Assert.assertEquals(label, "Added to cart"," Men's Tech Shell Full-Zip wasn't added to the cart ");
		
	}
	@Test
	public void testGotoCart() {
		
		homepage.navigateToHome();
		menswear.selectMensWear();
		addtocart.addToCart();
		addtocart.closeWindow();
		addtocart.goToCart();
		
	}
@Test

	public void testCheckout() {
	homepage.navigateToHome();
	menswear.selectMensWear();
	addtocart.addToCart();
	addtocart.closeWindow();
	addtocart.goToCart();
	checkout.checkout();
	
		
	}
}
