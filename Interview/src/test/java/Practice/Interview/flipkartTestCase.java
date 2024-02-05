package Practice.Interview;

import org.testng.annotations.Test;

public class flipkartTestCase extends Class {
	
	@Test
	public void testcase() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.btnlogin().click();
		Thread.sleep(2000);
	}

}
