package org.ar.obejctrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateUser_Account {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Accounts']")
	private WebElement accounts;
	@FindBy(xpath="//h4[text()='Admin Account(s)']")
	private WebElement adminacc;
	@FindBy (xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement adduser;
	@FindBy (name="empid")
	private WebElement Emp;
	@FindBy(xpath="//div[@class='form-group']//input[@name='username' and @placeholder='Username']")
	private WebElement usern;	
	@FindBy(xpath="//div[@class='form-group']//input[@name='password'and @placeholder='Password']")
	private WebElement pass;
	@FindBy(xpath="//h5[.='Add User Account']/following::button[@type='submit']")
	private WebElement submit;
	@FindBy (xpath="//h4[contains(.,'User')]/../following::tbody//td[2]")
	private List<WebElement> listof;
	
	public CreateUser_Account(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void userAccTab()
	{
		accounts.click();
	}
	public String adminAcc() {
		String admintext = adminacc.getText();
		return admintext;
	}
	
	public void clickonadduser() {
		adduser.click();
	}
	public void Empl()
	{
		Emp.click();
	}
	public WebElement getEmpAddress()
	{
	return Emp;
	}
	public void us_name(String u) {
		usern.sendKeys(u);
	}
	public void pass_name(String p)
	{
		pass.sendKeys(p);
	}
 public void submitt() 
 {
 submit.click();
}
 public List<WebElement> lisoff()
 {
	 return listof;
	 
 }
}
