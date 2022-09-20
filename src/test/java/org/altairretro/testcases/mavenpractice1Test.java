package org.altairretro.testcases;

import org.ar.genericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class mavenpractice1Test {
	@Test(groups = "sanity")
	public void step1Test() {
		String browser = System.getProperty("b");
		String url = System.getProperty("u");
		System.out.println("Browser name is ======>>  " + browser);
		System.out.println("URL is ======>   " + url);
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		webDriverUtility.openApplication(browser, url, 10);
	}

}
