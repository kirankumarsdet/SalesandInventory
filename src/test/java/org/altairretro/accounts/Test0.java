package org.altairretro.accounts;

import org.ar.genericUtility.FileUtility;
import org.ar.genericUtility.IConstantpath;
import org.ar.genericUtility.WebDriverUtility;

public class Test0 {

	public static void main(String[] args) {
		WebDriverUtility WB= new WebDriverUtility();
		FileUtility property = new FileUtility();
		String url=property.FetchUrl(IConstantpath.PROPERTY1_FILE_XPATH, "url2");
		String browser=property.FetchUrl(IConstantpath.PROPERTY1_FILE_XPATH, "browser1");
		WB.openApplication(browser,url,10);

	}

}
