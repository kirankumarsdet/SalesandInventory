package org.ar.obejctrepo;

import org.ar.genericUtility.FileUtility;
import org.ar.genericUtility.IConstantpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CommonPage {
	FileUtility fileutility= new FileUtility();
	WebDriver driver=null;
	private String dynamicXpath="//ul[@class='nav nav-tabs']/li/a[.='%s']";
	//private String productnamedxpath="//h6[.='%s']";
	private String quantity="//h6[.='%s']/following-sibling::input[@name='quantity']";
	private String addprod="//h6[.='%s']/following-sibling::input[@type='submit']";
	@FindBy(name="user")
	private WebElement usernametextbox;
	@FindBy(name="password")
	private WebElement passwordtextbox;
	@FindBy(name="btnlogin")
	private WebElement loginbutton;
	@FindBy(xpath="//span[text()='POS']")
	private WebElement POStab;
	@FindBy (name="customer")
	private WebElement customer;
	@FindBy(xpath="//button[.='SUBMIT']")
	private WebElement submit;
	@FindBy (xpath="//h3[@class='font-weight-bold py-3 bg-light']")
	private WebElement amt;
	@FindBy(xpath="//input[@placeholder='ENTER CASH']")
	private WebElement cash;
	@FindBy (xpath="//button[.='PROCEED TO PAYMENT']")
	private WebElement payment;
	@FindBy (xpath="//span[.='Prince Cesarly']")
	private WebElement profile;
	@FindBy (xpath="//a[@data-target='#logoutModal']")
	private WebElement logout;
	@FindBy (xpath="//div/h5[.='Ready to Leave?']/following::div/button/following::a[@href='logout.php'][1]")
	private WebElement logoutclick;
	@FindBy (xpath="//a[@href='transaction.php']")
	private WebElement transaction;
	@FindBy (xpath="//div[@id='dataTable_paginate']/descendant::li[last()-1]")
	private WebElement lasttab;
	@FindBy (xpath="//tbody/tr[last()]/td[2]")
	private WebElement lasteele;
	@FindBy(xpath="//tbody/tr[last()]/td[1]")
	private WebElement transid;
	@FindBy(xpath="//a[@href='Sales_And_Inventory_System/']")
	private WebElement sipath;
	/*@FindBy (xpath="//ul[@class='nav nav-tabs']/li/a[.='\" + Product_Category + \"']")
	private WebElement Productcategorytab;*/
	@FindBy (xpath="//div[text()='Sales and Inventory System']")
    private WebElement HomePage;
	
	
// Initialization
 public CommonPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
	 this.driver=driver;
 }
 
 // business Library
 String username = fileutility.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "username");
	String password = fileutility.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "password");
 public void Login()
 {
	 usernametextbox.sendKeys(username);
	 passwordtextbox.sendKeys(password);
	 loginbutton.click();
 }
 public void POStab()
 {
	 POStab.click();
 }
/**
 * This Methos is used for Dynamic Product category xpath
 * @param requiredvalue
 * @return
 */
 public WebElement convertStringToWebelement(String requiredvalue)
 {
	 String actualstring = String.format(dynamicXpath, requiredvalue);
	 WebElement element = driver.findElement(By.xpath(actualstring));
	 return element;
 }
// public void useDynamicToSendData(String Options)
// {
//	 convertStringToWebelement(Options).click();
// }
 public WebElement prodname(String requiredvalue)
 {
	String actualstring = String.format(quantity, requiredvalue);
	WebElement element = driver.findElement(By.xpath(actualstring));
	return element;
 }
// public void prodnamedynamic(String pro)
// {
//	String proname = prodname(pro).getText();
//	System.out.println(proname);
// }
 public void sendData(WebElement ele,String data)
 {
	 ele.click();
	 ele.clear();
	ele.sendKeys(data);
 }
public void clickonDynamicEle(WebElement ele)
{
	ele.click();
}
public void clearData(WebElement ele)
{
	ele.clear();
}
public WebElement addbutton(String requiredvalue)
{
	String actualstring = String.format(addprod, requiredvalue);
	WebElement element = driver.findElement(By.xpath(actualstring));
	
	return element;
	}
public void addpro( String data,WebElement ele)
{
	addbutton(data);
	ele.click();
}
public WebElement customer()
{
 return customer;
}
public void submit()
{
	submit.click();
}
 public String amt() {
	 return amt.getText();
	 
 }
 public void cash(String cash1)
 {
	 cash.sendKeys(cash1);
 }
 public void pay() {
	 payment.click();
 }
 
 public void profileclick()
 {
	 profile.click();
	 logout.click();
	 logoutclick.click();
 }
 public void trans()
 {
	 transaction.click();
 }

 public void lastcol()
 {
	 lasttab.click();
 }
 public String lastone()
 {
	String eleName = lasteele.getText();
	System.out.println(eleName);
	return eleName;
 }
 public String trans1()
 {
	 String ele1 = transid.getText();
	 System.out.println(ele1);
	 return ele1;
 }
 public void quit()
 {
	 driver.quit();
 }
 public void si()
 {
	 sipath.click();
 }
public String HomePageText()
{
	String HomepageTxt=HomePage.getText();
	return HomepageTxt;
}

 

















 }

