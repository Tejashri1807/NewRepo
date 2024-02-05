package melaluace.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class MelaleucaAndroidBaseTest {
	public  AndroidDriver driver;
	AppiumDriverLocalService service;
	@BeforeClass
	public void startMelaluaca() throws MalformedURLException, InterruptedException {
		 service=new AppiumServiceBuilder().withAppiumJS
				(new File("C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
				withIPAddress("192.168.0.149").usingPort(4723).build();
		service.start();
		Thread.sleep(2000);
		UiAutomator2Options option=new UiAutomator2Options();
		option.setDeviceName("AutomationDevice");
		option.setApp("D:\\Mobile Automation Testing\\eclipse\\AndroidMelaleucaProject\\src\\main\\java\\resources\\mela-10-jan-UAT.apk");
	
		 driver=new AndroidDriver(new URL("http://192.168.0.149:4723"),option);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
