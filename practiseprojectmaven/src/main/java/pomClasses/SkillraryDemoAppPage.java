package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/** this class contains elements and respective bussiness libraries of skillRary demoApppage
 * 
 * 
 */
public class SkillraryDemoAppPage {
	
	//declaration
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement pageHeader;

	@FindBy(id="course")
	private WebElement courseTab;
	
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	
	@FindBy(name="addresstype")
	private WebElement categoryDD;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	//inilisation
	public SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilisation
	
	/** this method will return page header text
	 * 
	 * @return
	 */
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/** This method is used to MouseHover on the course tab
	 * 
	 */
	public void mousehoverToCourse(WebDriverUtility web) {
		web.mouseHover(courseTab);
	}
	/** This method is used to click on selenium training
	 * 
	 */
	public void clickOnSeleniumTrainingLink() {
		seleniumTrainingLink.click();
	}
	/** this method is used to select category
	 * 
	 */
	public void selectCategory(WebDriverUtility web,int index) {
		web.dropdown(categoryDD,index);
	}
	
	/** this method return contact us link
	 * 
	 * 
	 */
	public WebElement getContactUsLink() {
		return contactUsLink;
		}
	/** this method is used to click on contact us link
	 * 
	 */
	public void clickOncontactus() {
		contactUsLink.click();
	}
}
