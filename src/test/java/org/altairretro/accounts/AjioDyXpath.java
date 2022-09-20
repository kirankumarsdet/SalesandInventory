package org.altairretro.accounts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioDyXpath {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.ajio.com");
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href=\"/s/0-to-2-years-3767-54091\"]")).click();
		driver.findElement(By.xpath("//div[text()='AARIKA GIRLS ETHNIC']"));
		String productprice = driver.findElement(By.xpath(
				"//a[@href='/aarika-girls-ethnic-indian-fit-and-flare-dress/p/463654377_black']/descendant::span[@class='price  ']"))
				.getText();
		System.out.println(productprice);

	}
}
