package org.altairretro.Tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.ar.genericUtility.BaseClass_SI;
import org.ar.obejctrepo.AddSupplier_Prod;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSupplier_ProductTest extends BaseClass_SI {

	@Test
	public void AddSupplier_Product() {
		AddSupplier_Prod prodsup = new AddSupplier_Prod(driver);
		prodsup.clickOnSupplierTab();
		prodsup.clickOnAddSupp();
		Map<String, String> map = excelutility.getDataFromExcelByMap("Product_Supplier");
		String CompanyName = map.get("Company Name");
		prodsup.addCompanyName(CompanyName);
		prodsup.clickOnProvince();
		prodsup.selectProvince(prodsup.Province(), map.get("Province Name"));
		prodsup.selectCITY();
		prodsup.SelectCityFromDD(prodsup.selectCITY(), map.get("Select City"));
		prodsup.phoneNo(map.get("Phone Number"));
		prodsup.SaveSupplierButton();
		String LastColNo = prodsup.getTextofLastcol();
		int c = Integer.parseInt(LastColNo);
		int count = 0;
		for (int i = 0; i < c; i++)
		{
			List<WebElement> CompanyList = prodsup.companies();
			for (WebElement companyLists : CompanyList) 
			{
				if (companyLists.getText().equalsIgnoreCase(CompanyName)) 
				{
					System.out.println(CompanyName + "   Company is Identified");
					count++;
					break;
				}
			}
			if (count == 1) 
			{
				break;
			}
			prodsup.nextButton();
		}
		if (count == 0) {
			Assert.fail("Company is not created");
		}

		prodsup.clickOnProduct();
		// prodsup.clickOnAddProd();
		prodsup.clickONsupplier();
		// String supplierDetails = prodsup.getdatafromSup();
		// System.out.println(supplierDetails);
		WebElement Supplierdetails = prodsup.suppliers();
		prodsup.selectcompany(Supplierdetails, CompanyName);
		String allSuppliers = Supplierdetails.getText();
		Assert.assertTrue(allSuppliers.contains(CompanyName));
		prodsup.clickCancel();

	}
}
