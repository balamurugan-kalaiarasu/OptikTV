package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreen {
	private AppiumDriver driver;
	
	/**
	 * 
	 * @param driver
	 */
	public WelcomeScreen(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * Clicks on Guest Mode link if application shows Welcome Page
	 */
	public void selectGuestModeIfWelcomePageDisplayed() {
		if (driver.findElements(By.id("com.optiktv:id/enter_guest_mode")).size() > 0) {
			driver.findElement(By.id("com.optiktv:id/enter_guest_mode")).click();
		}
	}
}
