package melaluaca.mobile_automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MapkLoginPage   {
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='__VID__10__MelaId_lrhcflkp__usernameId']")
	private WebElement FieldUsername;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='__VID__10__MelaId_lrhcflkp__passwordId']")
	private WebElement FieldPassword;
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"SIGN IN\"]")
	private WebElement btnSignIn;
	
	AndroidDriver driver;
	public MapkLoginPage(AndroidDriver driver) {
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void mapklogin() {
		FieldUsername.sendKeys("");
		FieldPassword.sendKeys("");
		btnSignIn.click();
	}

}
