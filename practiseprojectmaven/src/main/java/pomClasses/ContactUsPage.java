package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement logo;
	
	@FindBy(name="name")
	private WebElement fullnameTF;
	
	@FindBy(name="sender")
	private WebElement emailTF;
	
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(name="message")
	private WebElement messageBox;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendUsMailButton;

public ContactUsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getlogo() {
	return logo;
}
public void sendDetails(String name,String email,String subject,String message) {
	
	fullnameTF.sendKeys(name);
	emailTF.sendKeys(email);
	subjectTF.sendKeys(subject);
	messageBox.sendKeys(message);
	sendUsMailButton.click();
}

}