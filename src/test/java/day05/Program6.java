package day05;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Program6 {
	
	
	@Test(groups = {"smoke","regression"})
	public void testcase01()
	{
		System.out.println("Test Case01");
	}
	
	@Test(groups = {"smoke"})
	public void testcase02()
	{
		System.out.println("Test Case02");
	}
	
	@Test(groups = {"smoke","regression"})
	public void testcase03()
	{
		System.out.println("Test Case03");
	}


	@Test(groups = {"regression"})
	public void testcase04()
	{
		System.out.println("Test Case04");
	}
	
	@Test()
	public void testcase05()
	{
		System.out.println("Test Case05");
	}
	
	@Test(groups = {"smoke","regression"})
	public void testcase06()
	{
		System.out.println("Test Case06");
	}
	
	@BeforeGroups(groups = {"smoke","regression"})
	public void testcaseBeforeGrp()
	{
		System.out.println("BeforeGroups");
	}
	
	
	@AfterGroups(groups = {"smoke","regression"})
	public void testcaseAfterGrp()
	{
		System.out.println("AfterGroups");
	}

}
