package melaluaca.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class MelaleucaLoginPage{
	
	AndroidDriver driver;
	WebDriverWait wait;
	public MelaleucaLoginPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//@AndroidFindBy(className="//android.widget.EditText[1]")
	@AndroidFindBy(xpath="//android.widget.EditText[@text='']")
	//@AndroidFindBy(id="__VID__10__MelaId_lrohem6o__usernameId")
	private WebElement Username;
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Password']")
	//@AndroidFindBy(id="__VID__10__MelaId_lrohem6o__passwordId")
	private WebElement password;
	@AndroidFindBy(xpath="//android.widget.ToggleButton[@text='Show Password']")
	private WebElement Showpassword;
	@AndroidFindBy(xpath="//android.widget.Button[@text='SIGN IN']")
	private WebElement btnSignIn;
	@AndroidFindBy(xpath="//android.widget.ImageView")
	private WebElement melaleucaLobo;
	@AndroidFindBy(className="android.widget.TextView")
	private WebElement Privacy_Terms;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Invalid Username or Password.']")
	private WebElement InvalidCredMessage;
	@AndroidFindBy(accessibility="GET TO KNOW MELALEUCA")
	private WebElement textGetKnowMela;
	@AndroidFindBy(xpath="//android.view.View[@text='BECOME A MEMBER!']")
	private WebElement textBecomeADoctor;
	
	public WebElement username() {
		return Username;
	}
	public WebElement password() {
		return password;
	}
	public WebElement btnsignin() {
		return btnSignIn;
	}
	public void LoginPage() throws InterruptedException {
		btnSignIn.click();	
		Username.sendKeys("MSATestUA25");
		String pass="Password1";
		//Showpassword.click();
		password.sendKeys(pass);
		
//		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(80))
//                .withTimeout(Duration.ofSeconds(80))
//                .pollingEvery(Duration.ofMillis(500));
//		wait.until(ExpectedConditions.visibilityOf(pass)).isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));;
		btnSignIn.click();	
	}
	public WebElement lobo() {
		return melaleucaLobo;
	}
	public WebElement privacy_termsText() {
		return Privacy_Terms;
	}
	public WebElement invalidcredentils() {
		return InvalidCredMessage;
	}
	public WebElement textGetKnowMela() {
		return textGetKnowMela;
	}
	public WebElement textBecomeADoctor() {
		return textBecomeADoctor;
	}
}