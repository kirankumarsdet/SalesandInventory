package org.ar.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Method Is used To select Web Browser
 * 
 * @author 91910
 *
 */

public class WebDriverUtility {
	private Actions a;
	WebDriver driver;

	public WebDriver openBrowser(String browser) {

		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Please Enter Valid Browser Key");
			break;
		}
		return driver;
	}

	/**
	 * This Method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizebrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method id used to call implicitlywait
	 * 
	 * @param driver
	 * @param time
	 */
	public void implicitlyWait(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * this method is used to close the browser.
	 * 
	 * @param driver
	 */
	public void closetheBrowser() {
		driver.quit();
	}

	/**
	 * this method is used to get into URL
	 * 
	 * @param driver
	 * @param url
	 */
	public void navigatetoApplication(String url) {
		driver.get(url);
	}

	/**
	 * Open browser with application
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, int time) {
		openBrowser(browser);
		maximizebrowser();
		navigatetoApplication(url);
		implicitlyWait(time);
		return driver;

	}

	/**
	 * This Method is used to Scroll down
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void javaScriptExecutor(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	/**
	 * This methos is used to select dropdown
	 * 
	 * @param element
	 * @param data
	 */
	public void selectdropdown(WebElement element, String data) {
		Select s1 = new Select(element);
		s1.selectByVisibleText(data);
	}

	public void selectddbyindex(WebElement element, int data) {
		Select s1 = new Select(element);
		s1.deselectByIndex(data);
	}

	public void alert() {
		driver.switchTo().alert().accept();
	}

	public void si_login(String username, String password) {
		driver.findElement(By.name("user")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnlogin")).click();
		alert();

	}

	public void si_logout() {
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@data-target='#logoutModal']")).click();
		driver.findElement(
				By.xpath("//div/h5[.='Ready to Leave?']/following::div/button/following::a[@href='logout.php'][1]"))
				.click();
	}

	public void getss() {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(IConstantpath.PHOTO_PATH);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void screenShot(JavaUtility java, WebDriver driver, String className) {
		String CT = java.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/" + className + "_" + CT + ".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String screenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;

	}

	/**
	 * This Method is used to wait until visibilityof element
	 * 
	 * @param element
	 * @param timeouts
	 */
	public void explicitWait(WebElement element, long timeouts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void mouseHoverAction(WebElement element, WebDriver driver) {

		a.moveToElement(element).perform();
	}

	public void mouseHoverAction(WebElement element, int xaxis, int yaxis) {
		a.moveToElement(element, xaxis, yaxis);
	}

	public void initializeActions(WebDriver driver) {
		a = new Actions(driver);
	}

	/**
	  * this method is used to switch to particular window
	  * @param driver
	  * @param text
	  */
	public void switchToWindow(WebDriver driver,String text)
	{
		
		Set<String> windowid = driver.getWindowHandles();
		for(String id : windowid)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(text))
			{
				break;
			}
		
		}
	}

}


