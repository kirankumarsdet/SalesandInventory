package org.ar.genericUtility;

/**
 * This class contains methods for fetching data from excel
 * @author 91910
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	Workbook wb;

	public void initializeExcel(String path)
	{

		try {
			fis= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Map<String, String> getDataFromExcelByMap(String sheetname)
	{
		Sheet page = wb.getSheet(sheetname);	
		Map<String, String> map = new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=page.getLastRowNum();i++)
		{
			map.put(df.formatCellValue(page.getRow(i).getCell(0)),df.formatCellValue(page.getRow(i).getCell(1)));
		}
		return map;
	}

	public List<Map<String, String>> getValuesUsingMapAndList(String sheetName)
	{
		Sheet sheet = wb.getSheet(sheetName);
		List<Map<String, String>> list=new ArrayList<>();
		
		DataFormatter df=new DataFormatter();
		for(int i=1;i<sheet.getRow(0).getLastCellNum();i++)
		{
			Map<String, String> map=new HashMap<>();
			for(int j=0;j<=sheet.getLastRowNum();j++)
			{
				map.put(df.formatCellValue(sheet.getRow(j).getCell(0)), df.formatCellValue(sheet.getRow(j).getCell(i)));
			}
			list.add(map);
		}
		return list;
	}

	public String getdatafromExcel(String sheet, int rowcount, int cellcount)
	{
		Sheet Shet = wb.getSheet(sheet);
		String fetcheddata = new DataFormatter().formatCellValue(Shet.getRow(rowcount).getCell(cellcount));
		return fetcheddata;
	}





	public void writeDataIntoExcel(String path)
	{
		try {
			wb.write(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveData(String sheet,int row,int cell,String data)
	{
		new DataFormatter().formatCellValue(wb.getSheet(sheet).getRow(row).createCell(cell));
		//*.setCellValue(data);
	}

	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//	Workbook wb;
	//Sheet shet;
	//public void initExcel(String path,String sheet) throws EncryptedDocumentException, IOException
	//{
	//FileInputStream fis=new FileInputStream(path);	
	//wb = WorkbookFactory.create(fis);
	//shet = wb.getSheet(sheet);
	//}
	//
	//public String fetchData(int rnum,int cnum)
	//{
	//String data = shet.getRow(rnum).getCell(cnum).getStringCellValue();	
	//return data;
	//}
	//
	//public void closeWorkBook() throws IOException
	//{
	//wb.close();	
	//}


	/*ublic String getDataFromExcel(String path, String sheet, int rowcount, int cellcount) {

	try {
		fis = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}

	try {
		wb = WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch
		e.printStackTrace();
	}
	Sheet Shet = wb.getSheet(sheet);
	String fetcheddata = new DataFormatter().formatCellValue(Shet.getRow(rowcount).getCell(cellcount));
	return fetcheddata;
}*/

}
