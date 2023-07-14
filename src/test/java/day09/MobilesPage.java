package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobilesPage extends Framework {


	public void verifyMobilesPage()
	{
		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String expectedUrl ="https://www.amazon.in/mobile-phones";
		if(expectedTitle.equals(getTitle()) && getCurrentUrl().contains(expectedUrl) )
		{
			System.out.println("User landed in Mobiles Page");
		}
		else
		{
			System.out.println("User landed in Wrong Page");
		}			
	}


	public void verifyElectroicCategory()
	{
		List<WebElement> listElement = driver.findElements(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[1]//li[@class='a-spacing-micro']"));
		List<String> expectedTextList = new ArrayList<String>(Arrays.asList("Electronics","Mobiles & Accessories"));
		int index=0;
		for(WebElement element:listElement)
		{
			if(element.getText().equals(expectedTextList.get(index)))
			{
				System.out.println(expectedTextList.get(index) +" is displayed");
			}
			else
			{
				System.out.println(expectedTextList.get(index) +" is not displayed");

			}
			index++;
		}

	}




}
