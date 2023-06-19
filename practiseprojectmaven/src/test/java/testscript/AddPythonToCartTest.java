package testscript;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddPythonToCartTest extends BaseClass {
	
	@Test
	public void addpythonToCartTest() throws InterruptedException, AWTException {
		
	
	SoftAssert soft=new SoftAssert();
	
	home.clickGearsTab();
	home.clickskillraryDemoAppLink();
	web.switchToChildBrowser();
	
	soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
	
	demoApp.selectCategory(web,1);
	
	soft.assertEquals(testing.getpageHeader(),"Testing");
	
	web.scrollTiltleElement(testing.getpythonImage());
	
	
	
	web.dragAndDropElement(testing.getpythonImage(),testing.getcartArea());
	
	web.scrollTiltleElement(testing.getfacebookIcon());
	testing.clickfacebookIcon();
	Thread.sleep(3000);

	soft.assertAll();
}
}