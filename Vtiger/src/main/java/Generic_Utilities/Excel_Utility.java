package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		
	//Step1:- Path Connection of the physical File
			FileInputStream fes = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Vtiger\\src\\test\\resources\\excel.xlsx");

			        //step2:- keep Excel_File in Read mode
			         Workbook book = WorkbookFactory.create(fes);
				
			         //step3:- get control of the sheet
			         Sheet sheet = book.getSheet(sheetName);
			         
			         //step4:- get control of the Row
			         Row row = sheet.getRow(rowNum);
			         
			         //step5:- get control of the Cell
			         Cell cell = row.getCell(cellNum);
			         
			         String ExcelData = cell.getStringCellValue();
			         return ExcelData;
			         
	}
	public String getExcelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		
	//Step1:- Path Connection of the physical File
			FileInputStream fes = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Vtiger\\src\\test\\resources\\excel.xlsx");

			        //step2:- keep Excel_File in Read mode
			         Workbook book = WorkbookFactory.create(fes);
				
			         //step3:- get control of the sheet
			         Sheet sheet = book.getSheet(sheetName);
			         
			         //step4:- get control of the Row
			         Row row = sheet.getRow(rowNum);
			         
			         //step5:- get control of the Cell
			         Cell cell = row.getCell(cellNum);
			         
			        DataFormatter dataf= new DataFormatter();
			     String  excelData = dataf.formatCellValue(cell);
			         return excelData;
			         
	}
}
