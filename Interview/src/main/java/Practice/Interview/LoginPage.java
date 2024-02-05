package Practice.Interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//title="Login"
	@FindBy(xpath="//a[@title='Login']")
	private WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement btnlogin() {
		return btnLogin;
	}

}
