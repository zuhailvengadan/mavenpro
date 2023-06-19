package genericLibraries;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	/** this class contains all reusable method of WebDriver
	 * 
	 * @param browser
	 */
	private WebDriver driver;
	
	/** this method is used launch the browser
	 * 
	 * @param browser
	 */
	public WebDriver launchBrowser(String browser) {
		
		
		switch (browser) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:System.out.println("invalid browser");
			throw new IllegalArgumentException("Unexpected value: " + browser);
		
		}
		return driver;
		
	}
	    /**
	     * this method is used to maximize the browser
	     * 
	     */
		public void maximizeBrowser() {
			driver.manage().window().maximize();
		
		}
		/** this method is used to navigate to the application via url
		 * 
		 * @param url
		 */
		public void navigateToApp(String url) {
			driver.get(url);
		}
		
		/** this methods waits until element/elements is found
		 * 
		 * @param time
		 */
		public void waitUntilElementFound(long time) {
			driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		}
		
		/** this method is used to wait until WebPage element is visible.
		 * 
		 * @param time
		 * @param element
		 * @return
		 */
		public WebElement ExplicitWait(long time,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,time);
			return wait.until(ExpectedConditions.visibilityOf(element));
		}
		/** this method is used to wait until WebPage element to be ClickAble .
		 * 
		 * @param element
		 * @param time
		 * @return
		 */
		
		public WebElement ExplicitWait(WebElement element,long time) {
			WebDriverWait wait=new WebDriverWait(driver,time);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		/** this method is used to wait until WebPage title is displayed
		 * 
		 * @param time
		 * @param title
		 * @return
		 */
		public boolean ExplicitWait(long time,String title) {
			WebDriverWait wait=new WebDriverWait(driver,time);
			return wait.until(ExpectedConditions.titleContains(title));
		}
		/** this element is used to wait for WebElement displayed.
		public void ExplicitWaitfor(long time,WebElement title) {
			WebDriverWait wait=new WebDriverWait(driver,time);
			 wait.until(ExpectedConditions.visibilityOf(title));
		}
		/** this method is used to mouseHover on an element
		  * 
		  * @param element
		  */
		public void mouseHover(WebElement element) {
			Actions actions=new Actions(driver);
			actions.moveToElement(element).perform();
		}
		/** this method is used to double click on an element
		  * 
		  * @param element
		  */
		public void doubleClickOnElement(WebElement element) {
			Actions actions=new Actions(driver);
			actions.doubleClick(element).perform();
		}
		
		 /** this method is used to right click on an element
		  * 
		  * @param element
		  */
		public void rightClickOnElement(WebElement element) {
			Actions actions=new Actions(driver);
			actions.contextClick(element).perform();
		}
		/**
		 * this method is used to drag and drop an element to target.
		 * @param element
		 * @param target
		 */
		public void dragAndDropElement(WebElement element,WebElement target) {
			Actions actions=new Actions(driver);
			actions.dragAndDrop(element,target).perform();
		}
		/** this method is used to select dropDown using index
		 * 
		 * @param element
		 * @param index
		 */
		public void dropdown(WebElement element,int index) {
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		/** this method is used to select dropDown using value
		 * 
		 * @param element
		 * @param value
		 */
		public void dropdown(WebElement element,String value) {
			Select s=new Select(element);
			s.selectByValue(value);
		}
		/** this method is used to select dropDown using visible text
		 * 
		 * @param text
		 * @param element
		 */
		public void dropdown(String text,WebElement element) {
			Select s=new Select(element);
			s.selectByVisibleText(text);
		}
		/** this method is used to scroll till the element
		 * 
		 */
		public void scrollTiltleElement(WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver ;
			js.executeScript("arguments[0].scrollIntoView(true)",element);
		}
		
		/** this method is used to switch to frame using index value
		 * 
		 * @param index
		 */
		public void switchToFrame(int index) {
			driver.switchTo().frame(index);
		}
		/** this method is used to switch to frame using idOrName attribute value
		 * 
		 * @param idOrName
		 */
		public void switchToFrame(String idOrName) {
			driver.switchTo().frame(idOrName);
		}
		/** this method is used to switch to frame using frame Element
		 * 
		 * @param frameElement
		 */
		public void switchToFrame(WebElement frameElement) {
			driver.switchTo().frame(frameElement);
		}
		/** this method is used to switch back from frame
		 * 
		 */
		public void switchBackFromFrame() {
			driver.switchTo().defaultContent();
		}
		/** this method is used to capture Screenshot of window
		 * 
		 * 
		 */
		public void takeScreenshot() {
			SimpleDateFormat cTime=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("./screenshot/"+cTime+".png");
			try {
			FileUtils.copyFile(src,dest);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		
		/** this method is used to handle alert
		 * 
		 * @param status
		 */
		public void handleAlert(String status) {
			Alert a1=driver.switchTo().alert();
			if (status.equalsIgnoreCase("ok")) 
			a1.accept();
			else
				a1.dismiss();
			
				
			}
		/** this method is used to switch to child browser
		 * 
		 */
		public void switchToChildBrowser() {
			Set<String> set=driver.getWindowHandles();
			for(String id: set){
				driver.switchTo().window(id);
			}
		}
			/** this method is used to close the current window
			 * 
			 */
			public void closeCurrentWindow() {
				driver.close();
			}
			/** this method is used to quit all the windows
			 * 
			 */
			public void quitAllWindows() {
				driver.quit();
		}
}

