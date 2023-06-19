package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** this class contains elements locators and respective bussiness
 *  libraries of testingPage
 * @author Zuhail
 *
 */
public class TestingPage {
 //Declaration;
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id="Python")
	private WebElement pythonImage;
	
	@FindBy(id="mycart")
	private WebElement cartArea;
	
	@FindBy(xpath="//ul[@class='list-socialicons']/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	//initialising
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilisation
	
	/** this method return text of pageHeader.
	 * 
	 * @return
	 */
	
	public String getpageHeader() {
		return pageHeader.getText();
	}
	
	/** this method return python image
	 * 
	 * @return
	 */
	public WebElement getpythonImage() {
		return pythonImage;
	}
	
	/** this method return webelement of cartarea.
	 * 
	 * @return
	 */
	public WebElement getcartArea() {
		return cartArea;
	}
	/** this method return facebook icon
	 * 
	 * @return
	 */
	public WebElement getfacebookIcon() {
		return facebookIcon;
	}
	/** this method is used to click on facebookicon.
	 * 
	 */
	public void clickfacebookIcon() {
		facebookIcon.click();
	}
}
