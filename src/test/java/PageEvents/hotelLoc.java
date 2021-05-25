package PageEvents;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageElements.HomepageElements;
import PageElements.hotelLocPageElements;
import TestUtils.elementFetch;
import testSuites.BaseTest;

public class hotelLoc {
	
	public void selLocation() {
		
		new WebDriverWait(BaseTest.driver, 40).until(ExpectedConditions.elementToBeSelected(By.id("//input[@id='downshift-1-input']")));
				
		List<WebElement> myList = new WebDriverWait(BaseTest.driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("downshift-1-menu")));
				for (WebElement element:myList) {
				         if(element.getText().contains("Bengaluru"));
				         element.click();
				    }
				
		
		elementFetch ef = new elementFetch();
		ef.getWebelement("Xpath", hotelLocPageElements.SearchHotelTab).click();
		
		 String Expected_result =ef.getWebelement("classname",hotelLocPageElements.hotelLoc).getText();
		 Assert.assertEquals("CHECKIN", Expected_result);
		 System.out.println("Checkin does exist on the page");

	
	

}
}