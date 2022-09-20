package org.altairretro.accounts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SI_POS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Sales_And_Inventory_..>']")).click();
		String Login = driver.findElement(By.xpath("//h1[text()='Welcome to Sales and Inventory!']")).getText();

		// Login Page Varification

		if (Login.equalsIgnoreCase("Welcome to Sales and Inventory!")) {
			System.out.println(Login + "--Login Page Is Displayed");
		} else {
			System.out.println("Enter Correct Url");
		}

		// Login Credential

		driver.findElement(By.name("user")).sendKeys("unguardable");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("btnlogin")).click();

		// Confirmation Pop Up

		if (driver.switchTo().alert().getText().equalsIgnoreCase("prince Welcome!")) {
			System.out.println("Login Successfull");
		} else {
			System.out.println("Login UnSuccessfull Check Username or Password");
		}
		driver.switchTo().alert().accept();

		// Home Page Validation

		String Home = driver.findElement(By.xpath("//div[text()='Sales and Inventory System']")).getText();
		if (Home.equalsIgnoreCase("Sales and Inventory System")) {
			System.out.println(Home + "  Home Page Is Displayed");
		} else {
			System.out.println("Home Page Is not displayed");
		}
       // Get Into POS
		driver.findElement(By.xpath("//span[text()='POS']")).click();
        // Varification of the Product category Page
       String ProdCat = driver.findElement(By.xpath("//h4[text()='Product category']")).getText();
		if (ProdCat.equalsIgnoreCase("Product category")) {
			System.out.println("Product Category Is Located");
		} else {
			System.out.println("click on product category");
		}
        // selecting the product
        WebElement Prod = driver.findElement(By.xpath("//a[text()='Processor']"));
		/*
		 * if(Prod.getText().equals("Processor")) { System.out.println(Prod); } else {
		 * System.out.println("Select the correct product category"); }
		 */
		Prod.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"processor\"]/div/div/form/div/input[4]")).click();
		driver.findElement(By.xpath("Lenovo ideapad 20056666666666666666"));
		/*
		 * WebElement
		 * customer=driver.findElement(By.xpath("//select[@name='customer']"));
		 * customer.click(); Select s1= new Select(customer); s1.selectByIndex(2);
		 */
		
		WebElement c=driver.findElement(By.xpath("//select[@name='customer']"));
		c.click();
		
	}

}
