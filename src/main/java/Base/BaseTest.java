package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utils.UtilProperties;
import io.appium.java_client.AppiumDriver;

public class BaseTest {

	// public AppiumDriver driver;
	public AppiumDriver driver;

	@BeforeTest
	public void driverSetup() {
		//Properties reader
		UtilProperties prop = new UtilProperties();
		
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", prop.getPropery("deviceName"));
		caps.setCapability("udid", prop.getPropery("udid"));
		caps.setCapability("platformName", prop.getPropery("platformName"));
		caps.setCapability("platformVersion", prop.getPropery("platformVersion"));
		caps.setCapability("appPackage", prop.getPropery("appPackage"));
		caps.setCapability("appActivity", prop.getPropery("appActivity"));
		caps.setCapability("noReset", prop.getPropery("noReset"));
		caps.setCapability("unicodeKeyboard", prop.getPropery("unicodeKeyboard"));
		caps.setCapability("resetKeyboard", prop.getPropery("resetKeyboard"));

		// Instantiate Appium Driver
		try {
			Reporter.log("Instantiating Appium Driver");
			driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Reporter.log("Instantiated Appium Driver and Application Under Test has been lauched.");
		} catch (MalformedURLException e) {
			driver = null;
			System.out.println(e.getMessage());
		}
	}

	//After Test method
	@AfterTest
	public void tearDown() {
		driver.quit();
		Reporter.log("Test has been completed. Appium driver instance has been terminated.");
	}
}
