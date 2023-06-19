package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {

	//@declatation
	 /** this class contains elements and respective bussiness libraries of skillRary Home page
	  * 
	  * 
	  */
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath="//ul[contains(@class,'home_menu')]/li[1]")
	private WebElement languageicon;
	
	@FindBy(xpath="//ul[contains(@class,'home_menu')]/li[1]/descendant::a[text()=' English']")
	private WebElement English;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearTab;
	
	@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/li[7]/a")
	private WebElement skillraryDemoAppLink;
	
	//initialising
	public SkillraryHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilisation
	/** this method return logo .
	 * 
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}
	/** this method choose English as default language
	 * 
	 */
	public void chooseEnglish() {
		languageicon.click();
	    English.click();
	}
	/** this method will click on gear tab
	 * 
	 */
	public void clickGearsTab() {
		gearTab.click();
	}
	/** this method will click on skillraryDemoApp
	 * 
	 */
	public void clickskillraryDemoAppLink() {
		skillraryDemoAppLink.click();
	}
}
