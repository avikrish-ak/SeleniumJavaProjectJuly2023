package day09;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Framework{
	
	
	public void browserSetup() throws Exception
	{
		browser();
		application();
	}

	
	public void clickMobilePage() throws Exception
	{
		clickIn("mobiles");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));	
		wait.until(ExpectedConditions.titleContains("Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in"));
	}
	
}
