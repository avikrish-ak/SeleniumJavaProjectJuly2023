package day02;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(readData(0, 0));
		
		driver.findElement(By.xpath(readData(1, 0))).sendKeys(readData(1, 1));
		driver.findElement(By.xpath(readData(2, 0))).sendKeys(readData(2, 1));
	}
	
	
	
	public static String readData(int row, int cell) throws Exception {

		File src = new File("./DataSheet.xlsx"); 
		FileInputStream ip = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("selenium");

		DataFormatter format = new DataFormatter();

		wb.close();
		return(format.formatCellValue(sh.getRow(row).getCell(cell)));

	}
	

}
