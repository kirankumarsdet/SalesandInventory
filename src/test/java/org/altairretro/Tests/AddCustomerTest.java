package org.altairretro.Tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.ar.genericUtility.BaseClass_SI;
import org.ar.obejctrepo.Add_Customer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends BaseClass_SI {
	Add_Customer addcustomer;

	@Test(retryAnalyzer = org.ar.genericUtility.RetryImplementation.class)
	public void AddProduct() {
		addcustomer = new Add_Customer(driver);
		addcustomer.clickOncustTab();
		Map<String, String> map = excelutility.getDataFromExcelByMap("Add_Customers");
		String firstname = map.get("First_name");
		String lastname = map.get("Last_name");
		addcustomer.sendDetails(firstname, lastname, map.get("Phone_No"));
		System.out.println(firstname + " " + lastname + "   Customer is Created");
		String LastColNo = addcustomer.getTextofLastcol();
		int c = Integer.parseInt(LastColNo);
		int count = 0;
		for (int i = 0; i < c; i++) {
			List<WebElement> cl = addcustomer.customerList();
			for (WebElement customersLists : cl) {
				if (customersLists.getText().equals(firstname)) {
					System.out.println(firstname + " " + lastname + "   Customer Is Varified In The CustomerListPage");
					count++;
					break;
				}
			}
			if (count == 1) {
				break;
			}
			addcustomer.nextButton();
		}
		if (count == 0) {
			Assert.fail("Customer is not created");
		}
		Assert.fail();
		addcustomer.clickonPOS();
		addcustomer.prodname(addcustomer.productCategory(), "Keyboard").click();
		addcustomer.prodname(addcustomer.addButton(), "bike").click();
		addcustomer.clickOnCustomer();
		addcustomer.selectcustomer(firstname + " " + lastname);
		WebElement listofCustomer = addcustomer.custList();
		String CustomerNameFromDd = listofCustomer.getText();
		Assert.assertTrue(CustomerNameFromDd.contains(firstname + " " + lastname));

	}

}
