package Framework.APIDemos.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumActions {
	
	public void waitForElementGetVisible(WebElement ele,String ItemName,int time,AppiumDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.attributeContains((ele), "text", ItemName));
	}
	
	// For Fetching data from json file
	public List<HashMap<String, String>> getJsondata() throws IOException {
		//\src\test\java\framworkFromScratch\testData\eCommerce.json
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				"\\src\\test\\java\\framworkFromScratch\\testData\\eCommerce.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
	}
	//To start Appium Server
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer(String ipaddress,int portNumber) {
		service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//admin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
    			.withIPAddress(ipaddress).usingPort(portNumber).build();
    	service.start();
    	return service;
	}
	// Getting ScreenShot
	public String getScreenShotPath(AppiumDriver driver,String testcaseName) throws IOException {
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\reports\\evi"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;

}
}
