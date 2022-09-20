package org.ar.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetdatafromExcel {
	public String getDataFromExcel(String excel,String page,int rownum,int cellnum)
	{
		FileInputStream fisexcel=null;
		try {
			fisexcel = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb=null;
		try {
			wb = WorkbookFactory.create(fisexcel);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(page);
String data = new DataFormatter().formatCellValue(sheet.getRow(rownum).getCell(cellnum));
try {
	wb.close();
} catch (IOException e) {
	e.printStackTrace();
}
return data;
	
	}
	

}
