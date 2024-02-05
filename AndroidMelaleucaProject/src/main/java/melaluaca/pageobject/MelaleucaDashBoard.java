package melaluaca.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MelaleucaDashBoard {
	AndroidDriver driver;
	public MelaleucaDashBoard(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Supplements\"]")
	private WebElement textSupplements;
	
	public  WebElement clicktextSupplements() {
		//textSupplements.getText();
		//WebElement element;
		return textSupplements;
	}

}
