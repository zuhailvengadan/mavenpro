package testscript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SendContactDetailsTest extends BaseClass {

	
	@Test
	public void sendContactDetailsTest() throws InterruptedException {
		
		SoftAssert soft=new SoftAssert();
		
		home.clickGearsTab();
		home.clickskillraryDemoAppLink();
		web.switchToChildBrowser();
		soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
		web.scrollTiltleElement(demoApp.getContactUsLink());
		demoApp.clickOncontactus();
		web.ExplicitWait(5,contact.getlogo());
		soft.assertTrue(contact.getlogo().isDisplayed());
		Map<String,String> map=excel.getDataFromExcel("sheet1");
		contact.sendDetails(map.get("Fullname"),map.get("Email"),map.get("subject"),map.get("message"));
		
		soft.assertAll();
	}
}
