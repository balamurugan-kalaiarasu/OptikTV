package Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CommonFunctions {
	
	/**
	 * Scrolls application until given text visible
	 * 
	 * @param searchText
	 * @param driver
	 */
	public static void scrollUntilText(String searchText, int maxScrolls, AppiumDriver driver) {
		try {
			driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable("
					+ "new UiSelector().scrollable(true)).setMaxSearchSwipes("+ String.valueOf(maxScrolls) +").scrollIntoView"
					+ "(new UiSelector().text(\""+ searchText +"\"))"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
