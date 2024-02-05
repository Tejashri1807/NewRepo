package melaluaca.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import melaluaca.pageobject.MelaleucaDashBoard;
import melaluaca.pageobject.MelaleucaLoginPage;
import melaluace.utils.MelaleucaAppiumActions;

public class MelaleucaLoginTest extends MelaleucaAppiumActions{
	MelaleucaLoginPage pageLogin;
	MelaleucaDashBoard dashboard;
	@Test
	public void startExecution() throws InterruptedException {
		
		 pageLogin=new MelaleucaLoginPage(driver);
//		String LoboText = pageLogin.lobo().getText();
//		System.out.println(LoboText);
//		Assert.assertEquals("melaleuca", LoboText);
		
		pageLogin.privacy_termsText().isDisplayed();
		String privacy_termsText=pageLogin.privacy_termsText().getText();
		//Assert.assertEquals(privacy_termsText, "By signing in, I agree to Melaleuca's Privacy Policy and Terms of Use");
		Assert.assertTrue(privacy_termsText.contains("Privacy Policy and Terms of Use"));
		
		pageLogin.LoginPage();		
		
		dashboard=new MelaleucaDashBoard(driver);
		System.out.println(dashboard.clicktextSupplements());
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(80))
                .withTimeout(Duration.ofSeconds(80))
                .pollingEvery(Duration.ofMillis(500));
		wait.until(ExpectedConditions.visibilityOf(dashboard.clicktextSupplements())).isDisplayed();
		String supplements = dashboard.clicktextSupplements().getText();
		Assert.assertEquals("Supplements", supplements);
	}
	@Test
	public void invalidLogin() throws InterruptedException {
		pageLogin=new MelaleucaLoginPage(driver);
		pageLogin.btnsignin().click();
		pageLogin.username().sendKeys("shri");
		pageLogin.password().sendKeys("123456");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pageLogin.btnsignin().click();
//		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(80))
//              .withTimeout(Duration.ofSeconds(80))
//              .pollingEvery(Duration.ofMillis(500));
//		wait.until(ExpectedConditions.visibilityOf(pageLogin.invalidcredentils())).isDisplayed();
		//Thread.sleep(80);
		String errormessage=pageLogin.invalidcredentils().getText();
		Assert.assertEquals(errormessage, "Invalid Username or Password.");
	}
	@Test
	public void getKnowMelaleuca() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pageLogin=new MelaleucaLoginPage(driver);
		scrollUptoElement(pageLogin.textGetKnowMela()).click();;
		//pageLogin.textGetKnowMela().click();
		//Thread.sleep(8000);
		pageLogin.textBecomeADoctor().isDisplayed();
		
	}
}
