package OptikTvTests;

import Base.BaseTest;
import PageObjects.ContentContainers;
import PageObjects.ContentDetails;
import PageObjects.MainScreen;
import PageObjects.OnDemand;
import PageObjects.WelcomeScreen;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RatingsTest extends BaseTest {
	
	@Test
	public void validateRatingInDetailsPage() {
		Reporter.log("Test Name: Validate rating displayed in movie details page.");
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		MainScreen mainScreen = new MainScreen(driver);
		OnDemand onDemand = new OnDemand(driver);
		ContentContainers contentContainers = new ContentContainers(driver);
		ContentDetails contentDetails = new ContentDetails(driver);
		
		Reporter.log("Selecting Guest Mode if welcome page is displayed.");
		welcomeScreen.selectGuestModeIfWelcomePageDisplayed();
		
		mainScreen.checkHomePageButtonIsVisible();
		Reporter.log("Application is in Home Screen");
		
		mainScreen.clickOnDemandLink();
		Reporter.log("Selected OnDemand");
		
		onDemand.selectCategory("Movies");
		Reporter.log("Selected Category as Movies");
		
		contentContainers.clickContentBasedOnRating("18A");
		Reporter.log("Selected a Movie with Rating '18A'");
		
		Assert.assertEquals("18A", contentDetails.getRating(), 
				"Error: Content rating in the list is mismatching with the rating displayed in content details page.");
		Reporter.log("Success: Content rating in the list is matching with the rating displayed in content details page.");
	}
	

}
