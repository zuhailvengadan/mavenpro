package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class addToCartTest extends BaseClass {
	
	
	
	@Test
	public void addToCart() throws InterruptedException {
		
		SoftAssert soft=new SoftAssert();
		
	
			home.clickGearsTab();
			home.clickskillraryDemoAppLink();
			web.switchToChildBrowser();
			soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
	
			demoApp.mousehoverToCourse(web);
			demoApp.clickOnSeleniumTrainingLink();
			soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
			int initialQuantity = Integer.parseInt(selenium.getQuantity());
			selenium.doubleClickPlusButton(web);
			int finalQuantity=Integer.parseInt(selenium.getQuantity());
			
			soft.assertEquals(finalQuantity,initialQuantity+1);
			
			selenium.clickAddToCart();
			web.handleAlert("ok");
			Thread.sleep(3000);
			soft.assertEquals(selenium.getItemAddedMessage(),"Item added to cart");
			soft.assertAll();
		
		
	}
	

}
