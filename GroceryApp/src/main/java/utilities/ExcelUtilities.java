package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
		
	public static String readData(String sheetName, int row, int column) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\GroceryApp.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow rows=sheet.getRow(row);
		XSSFCell cell=rows.getCell(column);
		return cell.getStringCellValue();
	}
}
