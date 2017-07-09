package DataDriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	
	public ExcelData(String excelPath) {
		
		try {
			
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public String getData(int sheetNumber, int row, int col) {
		sheet1=wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row++;
		
		return row;
	}

}
