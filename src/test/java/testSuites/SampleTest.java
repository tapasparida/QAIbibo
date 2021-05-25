package testSuites;

import org.testng.annotations.Test;

import PageEvents.homePage;

import PageEvents.hotelLoc;

public class SampleTest extends BaseTest{
	
	@Test(priority = 0)
	
	public void homePageTest() {
		
		 homePage homePageTest= new homePage();
		homePageTest.homelogin();
		
				}


@Test(priority = 1)

public void hotelLocTest() {
	
	hotelLoc hotelLocTest = new hotelLoc();
	hotelLocTest.selLocation();
	System.out.println("Bangalore location is selected");
	
}
}