package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public FileInputStream fis;
	public Workbook workbook;
	
	public ExcelUtility() throws EncryptedDocumentException, IOException {
		fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		workbook=WorkbookFactory.create(fis);
	}
	
	public String getStringDataFromExcel(String sheetName,int rowNum,int colNum) throws FileNotFoundException {
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		
	}
	
	public boolean getBooleanData(String sheetName,int rowNum,int colNum) {
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getBooleanCellValue();
		
	}
}
