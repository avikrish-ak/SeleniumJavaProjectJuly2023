package day02;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Program1 {

	public static void main(String[] args) throws Exception {

		File src = new File("./DataSheet.xlsx"); 
		FileInputStream ip = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("data");

		DataFormatter format = new DataFormatter();

		System.out.println(format.formatCellValue(sh.getRow(0).getCell(0)));

		System.out.println(format.formatCellValue(sh.getRow(1).getCell(0)));

		System.out.println(format.formatCellValue(sh.getRow(2).getCell(0)));

		System.out.println(format.formatCellValue(sh.getRow(3).getCell(0)));

		System.out.println(format.formatCellValue(sh.getRow(0).getCell(1)));
		
		System.out.println(format.formatCellValue(sh.getRow(0).getCell(2)));
		
		
		System.out.println(sh.getLastRowNum());//index of 0


		System.out.println(sh.getRow(0).getLastCellNum());//index of 1
		
		wb.close();

	}
}
