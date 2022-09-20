package org.ar.genericUtility;

public interface IConstantpath {
	String PROJECT_PATH=System.getProperty("user.dir");
	String EXCEL_PATH=PROJECT_PATH+"/src/test/resources/SI.xlsx";
	String PROPERTY_FILE_XPATH=PROJECT_PATH+"/src/test/resources/ai_commondata.Properties";
	String PROPERTY1_FILE_XPATH=PROJECT_PATH+"/src/test/resources/trial_kk.Properties";
	String PHOTO_PATH=PROJECT_PATH+"/photo";
	String DB_URL=PHOTO_PATH+"jdbc:mysql://localhost:3306/tyss";


}
