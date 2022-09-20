package org.ar.obejctrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Transaction {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='POS']")
	private WebElement clickonPOS;
	private String Prodcate = "//ul[@class='nav nav-tabs']/li/a[.='%s']";
	private String ProductName = "//h6[.='%s']/following-sibling::input[@name='quantity']";
	private String addbutton = "//h6[.='%s']/following-sibling::input[@type='submit']";
	@FindBy(name = "customer")
	private WebElement customer;
	@FindBy(xpath="//button[.='SUBMIT']")
	private WebElement submit;
	@FindBy (xpath="//h3[@class='font-weight-bold py-3 bg-light']")
	private WebElement amttxt;
	@FindBy (xpath="//input[@placeholder='ENTER CASH']")
	private WebElement entercash;
	@FindBy (xpath="//button[.='PROCEED TO PAYMENT']")
	private WebElement proceedPayment;
	@FindBy (xpath="//a[@href='transaction.php']")
	private WebElement transactionPage;
	@FindBy(xpath="//div[@id='dataTable_paginate']/descendant::li[last()-1]")
	private WebElement lastCol;
	@FindBy(xpath="//div[@id='dataTable_paginate']/descendant::li[last()-1]")
	private WebElement lastTrans;
	@FindBy (xpath="//tbody/tr[last()]/td[1]")
	private WebElement lastID;
	@FindBy (xpath="//a[.='Next']")
	private WebElement nextbutton;
	@FindBy (xpath="//h4[.='Transaction']/following::div/table/thead//tr/following::tbody/tr/td[2]")
	private List<WebElement> customerlist;
	

	public Admin_Transaction(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnPos() {
		clickonPOS.click();
	}

	public WebElement prodcat(String requiredvalue) {
		String actualstring = String.format(Prodcate, requiredvalue);
		WebElement element = driver.findElement(By.xpath(actualstring));
		return element;
	}

	public void productcategoryclick(String requiredvalue1) {
		prodcat(requiredvalue1).click();
	}

	public String procattext(String requiredvalue) {
		String cattext = prodcat(requiredvalue).getText();
		System.out.println(cattext);
		return cattext;
	}

	public WebElement prodname(String requiredvalue) {
		String actualstring = String.format(ProductName, requiredvalue);
		WebElement element = driver.findElement(By.xpath(actualstring));
		return element;
	}

	public void productnameclick(String requiredvalue, String value) {
		prodname(requiredvalue).click();
		prodname(requiredvalue).clear();
		prodname(requiredvalue).sendKeys(value);

	}

	public WebElement addbutton(String requiredvalue) {
		String actualstring = String.format(addbutton, requiredvalue);
		WebElement element = driver.findElement(By.xpath(actualstring));
		return element;
	}

	public void addbut(String requiredvalue) {
		addbutton(requiredvalue).click();

	}
	public void addcustomer()
	{
		customer.click();
	}
	public WebElement customers()
	{
		return customer;
	}
	public void clickSubmit()
	{
		submit.click();
	}
	public String getAmounttxt()
	{
		String Amttxt=amttxt.getText();
		return Amttxt;
	}
	public void enterCash(String amt)
	{
		entercash.sendKeys(amt);
	}
  public void proceedTopayment()
  {
	  proceedPayment.click();
  }
  public void clickOnTransaction()
  {
	  transactionPage.click();
  }
  public String clickOnLastCol()
  {
	  String lastcolno=lastCol.getText();
	  return lastcolno;
  }
  public String lastTransact()
  {
	  String lasttrns = lastTrans.getText();
	  return lasttrns;
  }
  public WebElement lastid()
  {
	  return lastID;
  }
  public void clickOnNext()
  {
	  nextbutton.click();
  }
  public List<WebElement> customerLists()
  {
	  return customerlist;
  }
}
