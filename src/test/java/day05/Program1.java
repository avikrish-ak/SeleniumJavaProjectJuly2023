package day05;

import org.testng.annotations.Test;

public class Program1 {
	
	
	@Test(dependsOnMethods = {"testcase03","testcase06","testcase04"})
	public void testcase01()
	{
		System.out.println("Test Case01");
	}
	
	@Test()
	public void testcase02()
	{
		System.out.println("Test Case02");
	}
	
	@Test()
	public void testcase03()
	{
		System.out.println("Test Case03");
	}

	
	@Test()
	public void testcase04()
	{
		System.out.println("Test Case04");
	}
	
	@Test()
	public void testcase05()
	{
		System.out.println("Test Case05");
	}
	
	@Test()
	public void testcase06()
	{
		System.out.println("Test Case06");
	}

}
