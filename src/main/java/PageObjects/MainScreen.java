package PageObjects;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainScreen {
	
	AppiumDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public MainScreen(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy (accessibility = "Home")
	private WebElement homeButton;
	
	@AndroidFindBy (accessibility = "On Demand")
	private WebElement onDemandLink;
	
	/**
	 * Waits for Home button to visible
	 */
	public void checkHomePageButtonIsVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(homeButton));
	}
	
	/**
	 * Clicks on OnDemand Link
	 */
	public void clickOnDemandLink() {
		try {
			onDemandLink.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Click on Homebutton
	 */
	public void clickHomeButton(){
		try {
			homeButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
