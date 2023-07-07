package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Program1 {

	static WebDriver driver;

	@Test
	public void tc01()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropdown.selectByVisibleText("Books");	
		driver.findElement(By.name("field-keywords")).sendKeys("Java Books"+Keys.ENTER);
	}


	@Test
	public void tc02()
	{
		driver.findElement(By.xpath("(//span[text()='Core Java: An Integrated Approach, New: Includes All Versions upto Java 8 | BS | e'])[3]")).click();

		for(String WindowID:driver.getWindowHandles())
		{
			driver.switchTo().window(WindowID);

			if(driver.getCurrentUrl().contains("Core-Java-Integrated-Approach-Versions"))
			{
				Select dropdown = new Select(driver.findElement(By.name("quantity")));
				dropdown.selectByValue("6");
				driver.findElement(By.name("submit.add-to-cart")).click();
			}	

		}	
	}

	@Test
	public void tc03() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();

		if(text.contains("Subtotal (6 items)"))
		{
			System.out.println("All items are Added in cart");
		}
		else
		{
			System.out.println("Items are not added in cart");
		}



		WebElement book = driver.findElement(By.xpath("//span[text()='Core Java: An Integrated Approach, New: Includes All Versions upto Java 8 | BS | e']"));

		//if(book.isDisplayed())
		{
			driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();

			Thread.sleep(3000);
			if(driver.findElement(By.xpath("//h1[contains(text(),'Your Amazon Cart is empty')]")).isDisplayed())
			{
				text = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
				if(text.contains("Subtotal (0 items)"))
				{
					System.out.println("All items are deleted");
				}
			}
			else
			{
				System.out.println("Items are not deleted");
			}

		}

	}








}
