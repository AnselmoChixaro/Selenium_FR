package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSData {

	@DataProvider(name="loginData")
	public String[][] GetData() throws IOException {
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\LoginData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		Row rowCells = sheet.getRow(totalRows);
		int totalCols = rowCells.getLastCellNum();
		
		System.out.println(totalRows);
		System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		
		for( int r=1; r <=totalRows; r++) {
			for( int c=0; c<totalCols; c++ ) {
				testData[r-1][c]=format.formatCellValue(sheet.getRow(r).getCell(c));
			}
		}
		
		return testData;
	}
}
