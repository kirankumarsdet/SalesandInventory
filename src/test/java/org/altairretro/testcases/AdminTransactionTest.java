package org.altairretro.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.Map;

import org.ar.genericUtility.BaseClass_SI;
import org.ar.genericUtility.IConstantpath;
import org.ar.obejctrepo.Admin_Transaction;
import org.ar.obejctrepo.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTransactionTest extends BaseClass_SI {
	Admin_Transaction at;

	@Test
	public void AdminTransactions() {
		at = new Admin_Transaction(driver);
		at.clickOnPos();
		Map<String, String> map = excelutility.getDataFromExcelByMap("Admin_POS");
		at.productcategoryclick(map.get("Product_Category"));
		at.prodname(map.get("Product_Name"));
		at.productnameclick(map.get("Product_Name"), map.get("Quantity"));
		at.addbut(map.get("Product_Name"));
		at.addcustomer();
		webdriver.selectdropdown(at.customers(), map.get("Customer_name"));
		at.clickSubmit();
		String amount = null;
		int count = 0;
		int duration = 10;
		while (count < duration) {
			try {
				amount = at.getAmounttxt();
				if (amount.isEmpty()) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		System.out.println("Total Amount Is= "+amount);
		at.enterCash(amount);
		at.proceedTopayment();
		webdriver.alert();
		cp.profileclick();
		CommonPage cp= new CommonPage(driver);
		cp.Login();
		webdriver.alert();
		at.clickOnTransaction();
	String lastcolno = at.clickOnLastCol();
	int c= Integer.parseInt(lastcolno);
	int count2=0;
	for (int i=1;i<c;i++)
	{
		
		List<WebElement> ele = at.customerLists();
		for(WebElement names:ele)
		{
			//System.out.println(names.getText());
				//assertEquals(names.getText(), Customer_name);
				if(names.getText().equals(map.get("Customer_name")))
			{
				System.out.println("TC IS Passed");
				count2++;
				break;
			}
				
		}
		if(count2==1)
		{
			break;
		}
		at.clickOnNext();
	}
	if (count2==0)
	{
		Assert.fail("TC is Failed");
	}
		
		/*String transactiontxt = at.lastTransact();
	    assertEquals(transactiontxt, Customer_name);
	    System.out.println(at.lastid().getText());*/
	    
		/*if (transactiontxt.equalsIgnoreCase(Customer_name)) {
			System.out.println("TC is Passed");
			System.out.println(
					"Transaction Id is  " + (at.lastid()).getText());
		} else {
			System.out.println("TC is Failed");
		}*/
		
	}
}
