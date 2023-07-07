package day04;

import org.testng.annotations.Test;

public class Program1 {

	@Test(priority = 2)
	public void testcase01()
	{
		System.out.println("Test Case01");
	}
	
	@Test(priority = 1)
	public void testcase02()
	{
		System.out.println("Test Case02");
	}
	
	@Test(priority = -1)
	public void testcase03()
	{
		System.out.println("Test Case03");
	}

}
