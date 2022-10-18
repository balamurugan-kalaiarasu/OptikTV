package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utils.CommonFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContentContainers {
	private AppiumDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public ContentContainers(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * Clicks on Content from the list of contents displayed in OnDemand Page based on Rating
	 * 
	 * @param rating
	 */
	public void clickContentBasedOnRating(String rating) {
		try {
			Reporter.log("Searching for Movie based on rating in the list.");
			CommonFunctions.scrollUntilText(rating, 20, driver);
			List<WebElement> contents = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.optiktv:id/recyclerView']"
					+ "//android.widget.TextView[@resource-id='com.optiktv:id/subtext']"));
			for (int i = 0; i < contents.size(); i++) {
				if (contents.get(i).getText().equalsIgnoreCase(rating)) {
					Reporter.log("Found a matching Movie based on rating. Opening it's details page.");
					driver.findElements(By.id("com.optiktv:id/programHolder")).get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
