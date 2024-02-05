package Framework.APIDemos.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Framework.APIDemos.Utils.androidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashboardPage extends androidActions {
	
	AndroidDriver driver;
	public DashboardPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy 
	(accessibility ="App") private WebElement btnApp;

}
