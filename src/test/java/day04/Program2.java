package day04;

import org.testng.annotations.Test;

public class Program2 {

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
	
	@Test(priority = 4,enabled = false)
	public void testcase03()
	{
		System.out.println("Test Case03");
	}

	
	@Test(priority = 5,enabled = false)
	public void testcase04()
	{
		System.out.println("Test Case04");
	}
	
	@Test(priority = 3)
	public void testcase05()
	{
		System.out.println("Test Case05");
	}
	
	@Test(priority = -2)
	public void testcase06()
	{
		System.out.println("Test Case06");
	}
}
