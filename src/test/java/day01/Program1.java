package day01;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		screenShot("downloads");
		
	}
	
	
	public static void screenShot(String fileName) throws Exception
	{
		File des = new File("./screenshot/"+fileName+".png");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, des);	
	}
	
	
	
	

}
