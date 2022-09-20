package org.ar.obejctrepo;


import java.util.List;

import org.ar.genericUtility.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddSupplier_Prod {
	ExcelUtility eu=new ExcelUtility();
	WebDriver driver;
	@FindBy(xpath = "//span[.='Supplier']")
	private WebElement SupplierTab;
	@FindBy(xpath = "//h4[@class='m-2 font-weight-bold text-primary']/a")
	private WebElement clickOnAddSupplier;
	@FindBy(xpath = "//input[@placeholder='Company Name']")
	private WebElement companyName;
	@FindBy(xpath = "//h5[.='Add Supplier']/parent::div/following-sibling::div//select[@placeholder='Province']")
	private WebElement province;
	@FindBy(xpath = "//h5[.='Add Supplier']/parent::div/following-sibling::div//select[@placeholder='City']")
	private WebElement city;
	@FindBy(xpath = "//h5[.='Add Supplier']/parent::div/following-sibling::div//input[@placeholder='Phone Number']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//h5[.='Add Supplier']/parent::div/following-sibling::div//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@id='dataTable_paginate']/descendant::li[last()-1]")
	private WebElement lastCol;
	@FindBy (xpath="//div[@class='col-sm-12']/table/thead/tr/th[1]/following::td")
	private WebElement customerList;
	@FindBy (xpath="//div[@class='col-sm-12']/table/thead/tr/th[2]/following::td")
	private WebElement Provincelist;
	@FindBy (xpath ="//th[text()='Company Name']/ancestor::thead/following-sibling::tbody//td[1]")
	private List<WebElement> companynNameList ;
	@FindBy (xpath ="//th[text()='Company Name']/ancestor::thead/following-sibling::tbody//td[2]")
	private List<WebElement> provinceList;
	@FindBy (xpath="//ul[@class='pagination']/li[last()-1]")
	private WebElement  LastColomn;
	@FindBy (xpath="//a[.='Next']")
	private WebElement next;
	@FindBy (xpath="//span[.='Product']")
	private WebElement productClick;
	@FindBy(xpath="//h4[@class='m-2 font-weight-bold text-primary']//a[@type='button']")
	private WebElement addProduct;
	@FindBy (xpath="//select[@name='supplier']")
	private WebElement clickOnSupplier;
	@FindBy (xpath="//input[@placeholder='Date Stock In']/parent::div/following::button[@class='btn btn-secondary']")
	private WebElement clickonCancel;
	
	

	public AddSupplier_Prod(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnSupplierTab() {
		SupplierTab.click();
	}

	public void clickOnAddSupp() {
		clickOnAddSupplier.click();
	}

	public void addCompanyName(String compname) {
		companyName.sendKeys(compname);

	}

	public void clickOnProvince() {
		province.click();
	}

	public void selectProvince(WebElement element, String province) {
		Select s = new Select(element);
		s.selectByVisibleText(province);

	}

	public WebElement Province() {
		return province;
	}

	public void selectCity() {
		city.click();
	}

	public void SelectCityFromDD(WebElement element, String city) {
		Select s = new Select(element);
		s.selectByVisibleText(city);
	}

	public WebElement selectCITY() {
		return city;
	}

	public void phoneNo(String phoneno) {
		phoneNumber.click();
		phoneNumber.sendKeys(phoneno);
	}

	public void SaveSupplierButton() {
		saveButton.click();
	}
	public String getTextofLastcol() {
		String lastColo=lastCol.getText();
		return lastColo;
	}
	public List<WebElement> companies()
	{
		return companynNameList;
	}
	public List<WebElement> province()
	{
		return provinceList;
	}
	public void nextButton() {
		next.click();
	}
	public void clickOnProduct()
	{
		productClick.click();
		addProduct.click();
	}
/*	public void clickOnAddProd()
	{
		addProduct.click();
	}*/
	public void clickONsupplier()
	{
		clickOnSupplier.click();
	}
	public String getdatafromSup()
	{
		String suppliers = clickOnSupplier.getText();
		return suppliers;
	}
	public void clickCancel() {
		clickonCancel.click();
	}
	public void selectcompany(WebElement element, String compname)
	{
		Select s = new Select(element);
		s.selectByVisibleText(compname);
	}
	public WebElement suppliers()
	{
		return clickOnSupplier;
	}
}