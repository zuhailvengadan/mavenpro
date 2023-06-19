package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class SeleniumTrainingPage {
	
	 /**this class contains elements locators and respective bussiness
	 *  libraries of seleniumtrainingPage
	 **/
	
	//declaration
    @FindBy(xpath="//h1[@class='page-header']")
    private WebElement pageHeader;

    @FindBy(id="quantity")
    private WebElement quantity;
    
    @FindBy(id="add")
    private WebElement plusButton;
    
    @FindBy(xpath="//button[@ondblclick='addtocart()']")
    private WebElement addToCartButton;
    
    @FindBy(xpath="//div[@class='callout callout-success']/span")
    private WebElement itemAddedMessage;
    
    //initialising
    public SeleniumTrainingPage(WebDriver driver){
    	PageFactory.initElements(driver,this);
    }
    
    //utilisation
    
    /** this page returns pageHeader text.
     * 
     * @return
     */
    public String getPageHeader() {
    	return pageHeader.getText();
    }
    /** this method fetch the Quantity of product
     * 
     * @return
     */
    public String getQuantity() {
    	return quantity.getAttribute("value");
    }
    
    /** this method is used to doubleclick on plus button
     * 
     * @param web
     */
    public void doubleClickPlusButton(WebDriverUtility web) {
    web.doubleClickOnElement(plusButton);
    	
    }
    /** this method is used to click addtocart button
     * 
     */
    public void clickAddToCart() {
    	addToCartButton.click();
    }
    /** this method will return item added message
     * 
     * @return
     */
    public String getItemAddedMessage() {
    	return itemAddedMessage.getText();
    }
}
