package day03;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Program1 {

public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath(readXpath("FirstName"))).sendKeys(readData("FirstName"));
		driver.findElement(By.xpath(readXpath("LastName"))).sendKeys(readData("LastName"));
		driver.findElement(By.xpath(readXpath("Address"))).sendKeys(readData("Address"));
		driver.findElement(By.xpath(readXpath("Cricket"))).click();
		driver.findElement(By.xpath(readXpath("Hockey"))).click();
		
		Select dropDown = new Select(driver.findElement(By.xpath(readXpath("Skill"))));
		dropDown.selectByValue(readData("Skill"));

}
	
	
	
	public static String readData(String fieldName) throws Exception {

		File src = new File("./DataSheet.xlsx"); 
		FileInputStream ip = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("locator");

		DataFormatter format = new DataFormatter();

		wb.close();
		
		
		for(int row=1;row<=sh.getLastRowNum();row++)
		{
			if(format.formatCellValue(sh.getRow(row).getCell(0)).contains(fieldName))
			{
				return format.formatCellValue(sh.getRow(row).getCell(2));
			}
		}
		
		
		return null;

	}
	
	
	public static String readXpath(String fieldName) throws Exception {

		File src = new File("./DataSheet.xlsx"); 
		FileInputStream ip = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("locator");

		DataFormatter format = new DataFormatter();

		wb.close();
		
		
		for(int row=1;row<=sh.getLastRowNum();row++)
		{
			if(format.formatCellValue(sh.getRow(row).getCell(0)).contains(fieldName))
			{
				return format.formatCellValue(sh.getRow(row).getCell(1));
			}
		}
		
		
		return null;

	}

}
