package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnDemand {
	private AppiumDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public OnDemand(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * Selects given category from OnDemand Page
	 * 
	 * @param category
	 */
	public void selectCategory(String category) {
		category += " >";
		CommonFunctions.scrollUntilText(category, 20, driver);
		WebElement swimLanesContainer = driver.findElement(By.id("com.optiktv:id/swimLanesContainer"));
		List<WebElement> categories = swimLanesContainer.findElements(By.id("com.optiktv:id/title"));
		for (WebElement x: categories) {
			if (x.getText().equalsIgnoreCase(category)) {
				x.click();
				break;
			}
		}
	}
}