package day07;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase extends Framework {
	
	
	@Test
	public void testCase01() throws Exception
	{
	browser();
	application();
	selectDropDownByValue("alldropdown");
	typeIn("searchText");
	}

	@Test
	public void testCase02() throws Exception
	{
		clickIn("coreJava");
		for(String WindowID:getAllWindowId())
		{
			windowSwitch(WindowID);

			if(getCurrentUrl().contains("Core-Java-Integrated-Approach-Versions"))
			{
				selectDropDownByValue("quantity");
				clickIn("addToCart");
			}	

		}
	}
	
	
}
