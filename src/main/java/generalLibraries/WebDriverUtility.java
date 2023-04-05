package generalLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
	private WebDriver driver;
	private Actions a;
	private Select s;
	
	/*
	 * this methods is used to launch the browser and navigate to application
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver openApplication(String browser,String url,long time) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		    break;
		default:
			System.out.println("Invalid browser data");
			}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		return driver;
		
	}
	/*
	 * this methods is used to wait until element is visible
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(Duration time,WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
		
	}
	/*
	 * this method is used to mouse hover to an element
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/*
	 * this method is used to double click on an element
	 * @param element
	 */
	public void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
		
	}
	/*
	 * this method is used to drag and drop an element in specified target location
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement(WebElement element,WebElement target) {
	a=new Actions(driver);
	a.dragAndDrop(element, target).perform();
	}
	/*
	 * this method is used to select an element from drop and drop based on index
	 * @param element
	 * @param Index
	 */
	public void dropdown(WebElement element,int Index) {
		s=new Select(element);
		s.selectByIndex(Index);
		
	}
	/*
	 * this method is used to select an element from drop down based on value
	 * @param element
	 * @param values
	 */
	public void dropdown(WebElement element, String value) {
		s=new Select(element);
		s.deselectByValue(value);
		
	}
	/*
	 * this method is used to select an element from drop down based on visibilityText
	 * @param Text
	 * @param element
	 */
	public void dropdown(String Text,WebElement element) {
		s=new Select(element);
		s.selectByVisibleText(Text);
	}
	/*
	 * this is used to switch to frame based on frame index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		
	}
	/*
	 * this method is used to switch to frame based on frame nameorid
	 * @param nameorID
	 */
	public void switchToFrame(String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	/*
	 * this method is used to switch to frame based on frame element
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/*
	 * this method is used to switch back from frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
		
	}
	/*
	 * this method is used scroll till element using element reference
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		
	}
	/*
	 * this method is usedd to take screenshot
	 * @param javaUtil
	 */
	public void takeScreenshot(JavaUtility javaUtil) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
	    File dest=new File("./Screenshot/ss_"+javaUtil.getCurrentTime()+".png");
	    try {
	    	FileUtils.copyFile(src, dest);
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	/*
	 * this method is used handle Alert popup
	 * @param status
	 */
	public void handleAlert(String status) {
		Alert a1=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			a1.accept();
		else
			a1.dismiss();
		
	}
	/*
	 * this method is used handle parent browser
	 */
	public void switchToParentWindow() {
		driver.switchTo().window(driver.getWindowHandle());
		
	}
	/*
	 * this method is used to handle child browser
	 */
	public void handleChildBrowser() {
		Set<String> set=driver.getWindowHandles();
		for(String wId:set) {
			driver.switchTo().window(wId);
			
		}
		
	}
	/*
	 * this method is used to close current tab
	 */
	public void quitBrowser() {
		driver.quit();
	}
	public void doubleClickOnElement(WebElement plusButton) {
		// TODO Auto-generated method stub
		
	}
	
	}
