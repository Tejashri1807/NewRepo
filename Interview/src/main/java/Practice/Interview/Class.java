package Practice.Interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Class 
{
	public WebDriver driver;
    @BeforeClass
//    public  void beforeclass() {
//    	System.setProperty("webdriver.chrome.driver", "D:\\MobileAutomationTesting\\chromedriver.exe");
//    	 driver=new ChromeDriver();
//    	 driver.get("https://www.flipkart.com/"); 	
//    }
    public static WebDriver ChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\MobileAutomationTesting\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
    @AfterClass
    public void afterclass() {
    	driver.quit();
    }
}
