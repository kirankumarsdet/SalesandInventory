package org.altairretro.Tests;

import java.util.List;
import java.util.Map;

import org.ar.genericUtility.BaseClass_SI;
import org.ar.obejctrepo.CreateUser_Account;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddUserAccTest extends BaseClass_SI {
	private CreateUser_Account ac;

	@Test
	public void addUserAccTest() {
		ac = new CreateUser_Account(driver);
		ac.userAccTab();
		String Admintext = ac.adminAcc();
		Assert.assertEquals(Admintext, "Admin Account(s)");
		ac.clickonadduser();
		Map<String, String> map = excelutility.getDataFromExcelByMap("AL_Account");
		ac.Empl();
		webdriver.selectdropdown(ac.getEmpAddress(), map.get("Employee"));
		ac.us_name(map.get("User_name"));
		ac.pass_name(map.get("User_pwd"));
		ac.submitt();
		List<WebElement> elements = ac.lisoff();
		System.out.println(elements);
		int count = 0;
		for (WebElement ele : elements) {
			String eList = ele.getText();
			// System.out.println(eList);
			if (eList.equalsIgnoreCase(map.get("User_name"))) {
				System.out.println("TC is Passed");
				count++;
				break;
			}
			if (count == 1) {
				break;

			}
		}
		if (count == 0) {
			Assert.fail("user account is not present");
		}

	}
}
