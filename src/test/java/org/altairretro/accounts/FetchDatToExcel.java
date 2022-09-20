package org.altairretro.accounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FetchDatToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis=new	FileInputStream("./src/test/resources/SI.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.createCell(5);
		cell.setCellValue("kirankkk");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/SI.xlsx");
		wb.write(fos);
		System.out.println("data successfull");
		wb.close();

	}

}
