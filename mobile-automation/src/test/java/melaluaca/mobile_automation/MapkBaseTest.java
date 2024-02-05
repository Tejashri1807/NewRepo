package melaluaca.mobile_automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MapkBaseTest {
	public AppiumDriverLocalService service;
	public AppiumDriver driver ;
	public UiAutomator2Options options;
	
	@BeforeClass
	public void appiumstart() throws MalformedURLException {
		service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//admin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
    			.withIPAddress("192.168.1.38").usingPort(4723).build();
    	service.start();

        options = new UiAutomator2Options();
        options.setDeviceName("AutomationDevice");
        options.setApp("D:\\Mobile Automation Testing\\eclipse\\mobile-automation\\src\\main\\java\\melaluaca\\mobile_automation\\resources\\mela-10-jan-UAT.apk");
        driver = new AndroidDriver(new URL("http://192.168.1.38:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}	
	
	@AfterClass
	public void appiumclose() {
		  	driver.quit();
	        service.stop();
	}	

}
