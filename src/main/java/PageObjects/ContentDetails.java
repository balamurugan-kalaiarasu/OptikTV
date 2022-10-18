package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContentDetails {
	private AppiumDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public ContentDetails(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * 
	 * @return rating
	 */
	public String getRating() {
		try {
			return driver.findElement(By.id("com.optiktv:id/subText1")).getText().split("\\|")[0].trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
