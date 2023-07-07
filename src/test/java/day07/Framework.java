package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Framework {
	static WebDriver driver;
	
	
	public static void browser() throws Exception
	{
		String browserValue= getValue("browser");
		switch (browserValue) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
	}
	
	public static void application() throws Exception
	{
		String url = getValue("url");
		driver.get(url);
	}
	
	
	public static void typeIn(String fieldName) throws Exception
	{
		driver.findElement(By.xpath(readXpath(fieldName))).sendKeys(readData(fieldName)+Keys.ENTER);
	}
	
	
	public static void clickIn(String fieldName) throws Exception
	{
		driver.findElement(By.xpath(readXpath(fieldName))).click();
	}
	
	public static void clearAll(String fieldName) throws Exception
	{
		driver.findElement(By.xpath(readXpath(fieldName))).clear();
	}
	
	public static Set<String> getAllWindowId()
	{
		return driver.getWindowHandles();
	}
	
	public static void windowSwitch(String windowId)
	{
		driver.switchTo().window(windowId);
	}
	
	public static String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public static String getTitle()
	{
		return driver.getTitle();
	}
	
	public static void selectDropDownByText(String fieldName) throws Exception
	{
		Select dropDown = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
		dropDown.selectByVisibleText(readData(fieldName));
	}
	
	public static void selectDropDownByValue(String fieldName) throws Exception
	{
		Select dropDown = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
		dropDown.selectByValue(readData(fieldName));
	}
	
	
	public static void alertOk()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void alertCancel()
	{
		driver.switchTo().alert().dismiss();
	}

	public static void actionRightClick(String fieldName) throws Exception
	{
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath(readXpath(fieldName)))).build().perform();
	}
	
	public static void actionClick(String fieldName) throws Exception
	{
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath(readXpath(fieldName)))).build().perform();
	}
	
	public static void actionDoubleClick(String fieldName) throws Exception
	{
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath(readXpath(fieldName)))).build().perform();
	}
	
	public static void windowMax()
	{
		driver.manage().window().maximize();
	}
	
	
	public static void browserBack()
	{
		driver.navigate().back();
	}
	
	
	public static String readData(String fieldName) throws Exception {

		File src = new File("./DataSheet.xlsx"); 
		FileInputStream ip = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("amazon");

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
		XSSFSheet sh = wb.getSheet("amazon");

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
	
	
	
	public static String getValue(String key) throws Exception
	{
		File src = new File("./application.properties");
		FileReader read = new FileReader(src);	
		Properties prop =new Properties();
		prop.load(read);	
		return prop.getProperty(key);
	}
	
	public static void setValue(String key,String value) throws Exception
	{
		File src = new File("./application.properties");
		FileReader read = new FileReader(src);	
		Properties prop =new Properties();
		prop.load(read);	
		prop.setProperty(key, value);
		FileWriter write = new FileWriter(src);
		prop.store(write, "Test Data Uploaded in file");
	}
	
	

}
