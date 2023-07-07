package day05;


import org.testng.annotations.*;

public class Program2 {
	
	
	@Test()
	public void testcase01()
	{
		System.out.println("Test Case01");
	}
	
	@Test()
	public void testcase02()
	{
		System.out.println("Test Case02");
	}
	
	@BeforeTest
	public void testcaseSetup()
	{
		System.out.println("Test Case Setup");
	}
	
	@AfterTest
	public void testcaseEndup()
	{
		System.out.println("Test Case End up");
	}

}
