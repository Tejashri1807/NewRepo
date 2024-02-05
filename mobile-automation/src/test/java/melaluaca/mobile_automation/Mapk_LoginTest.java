package melaluaca.mobile_automation;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Mapk_LoginTest extends MapkLoginPage {
	
	
	public Mapk_LoginTest(AndroidDriver driver) {
		super(driver);
		
	}
@Test
	public void TestLogin() {
		MapkLoginPage testlogin=new MapkLoginPage(driver);
		testlogin.mapklogin();
	}

}
