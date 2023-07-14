package day09;

import org.testng.annotations.Test;

public class TestCase extends Framework {
	
	
	HomePage hp = new HomePage();
	MobilesPage mp = new MobilesPage();
	
	@Test
	public void testCase01() throws Exception
	{
		hp.browserSetup();
		hp.clickMobilePage();
	}
	

	@Test
	public void testCase02() throws Exception
	{
		mp.verifyMobilesPage();
		mp.verifyElectroicCategory();
	}
	
}
