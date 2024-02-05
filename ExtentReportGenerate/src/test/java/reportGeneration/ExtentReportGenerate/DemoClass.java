package reportGeneration.ExtentReportGenerate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoClass {
	ExtentReports report;
	@BeforeTest
	public void config() {
		//ExtentReports & ExtentSparkReporter both classes are very usefull for generating report
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Report Generate");
		reporter.config().setDocumentTitle("Extend Report");
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Tejashri");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = report.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver","D:\\MobileAutomationTesting\\Application\\chromedriver-win64-LatestVersion\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("result do not match");
		report.flush();
		}
}
