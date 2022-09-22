package org.altairretro.accounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioTOexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//kiran
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@title='INDIE']//preceding::li[@data-test='li-KIDS']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200);");
		driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div[1]/div[7]/div/div/div/div[1]/div/a[2]"))
				.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,2500);");
		String kids = driver.findElement(By.xpath("//div[text()='Puma']")).getText();
		System.out.println(kids);
		String price1 = driver.findElement(By.xpath("//span[text()='₹368']")).getText();
		System.out.println(price1);
		FileInputStream fis = new FileInputStream("./src/test/resources/Ajio.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(0);
		cell.setCellValue(kids);
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.createCell(1);
		cell1.setCellValue(price1);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Ajio.xlsx");
		System.out.println("Product and Price updated succesfully");
		wb.write(fos);
		wb.close();
	}
}
