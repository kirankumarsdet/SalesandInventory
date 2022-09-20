package org.ar.obejctrepo;

import java.util.List;

import org.ar.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Customer {
	WebDriver driver;
	WebDriverUtility web= new WebDriverUtility();
	@FindBy(xpath = "//span[.='Customer']")
	private WebElement custTab;
	@FindBy(xpath = "//h4[@class='m-2 font-weight-bold text-primary']/a")
	private WebElement clickOnaddcutsomer;
	@FindBy(xpath = "//*[@id=\"customerModal\"]/div/div/div[2]/form/div[1]/input")
	private WebElement firstName;
	@FindBy(xpath = "//*[@id=\"customerModal\"]/div/div/div[2]/form/div[2]/input")
	private WebElement lastName;
	@FindBy(xpath = "//*[@id=\"customerModal\"]/div/div/div[2]/form/div[3]/input")
	private WebElement phoneno;
	@FindBy(xpath = "//*[@id=\"customerModal\"]/div/div/div[2]/form/button[1]")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@id='dataTable_paginate']/descendant::li[last()-1]")
	private WebElement lastCol;
	@FindBy(xpath = "//th[text()='First Name']/ancestor::thead/following-sibling::tbody//td[1]")
	private List<WebElement> CustomerList;
	@FindBy(xpath = "//a[.='Next']")
	private WebElement next;
	@FindBy(xpath = "//span[.='POS']")
	private WebElement POS;
	private String Prodcate = "//ul[@class='nav nav-tabs']/li/a[.='%s']";
	private String ProductName = "//h6[.='%s']/following-sibling::input[@name='quantity']";
	private String addb = "//h6[.='%s']/following-sibling::input[@type='submit']";
	@FindBy(name = "customer")
	private WebElement customers;

	public String productCategory() {
		return Prodcate;
	}

	public String ProductName() {
		return ProductName;
	}

	public WebElement prodname(String ProductName, String requiredvalue) {
		String actualstring = String.format(ProductName, requiredvalue);
		WebElement element = driver.findElement(By.xpath(actualstring));
		return element;
	}

	public Add_Customer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOncustTab() {
		custTab.click();
		clickOnaddcutsomer.click();
	}

	public void sendDetails(String fname, String lname, String phone) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		phoneno.sendKeys(phone);
		saveButton.click();
		
	}

	public String getTextofLastcol() {
		String lastColo = lastCol.getText();
		return lastColo;
	}

	public List<WebElement> customerList() {
		return CustomerList;
	}

	public void nextButton() {
		next.click();
	}

	public void clickonPOS() {
		POS.click();
	}

	public String addButton() {
		return addb;
	}
public void clickOnCustomer()
{
	customers.click();
}
public WebElement custList()
{
	return customers;
} 
public void selectcustomer(String name)
{
	web.selectdropdown(customers, name);
}
	

}
