package org.altairretro.accounts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDate {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//a[text()='Sales_And_Inventory_..>']")).click();
	driver.findElement(By.name("user")).sendKeys("unguardable");
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("btnlogin")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/li[4]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/h4/a")).click();
    WebElement dateclick = driver.findElement(By.name("datestock"));
    dateclick.click();
    dateclick.sendKeys("10102020");
	}

}
