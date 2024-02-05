package Framework.APIDemos.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class androidActions extends appiumActions {

	AppiumDriver driver;
	public androidActions(AndroidDriver driver) {
		this.driver=driver;
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).
						getId(),"duration",2000));
	}
	
	public void swipePage(WebElement element,String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).
				getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void dragAndDrop(WebElement element, int a, int b) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", a,
			    "endY", b
			));
	}
	
	public WebElement scrollUptoElement(String elementText) {
	     return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
	            + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"));"));
	}
}
