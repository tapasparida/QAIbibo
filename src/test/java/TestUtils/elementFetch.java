package TestUtils;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testSuites.BaseTest;


public class elementFetch {
	
	public WebElement getWebelement(String identificationType, String identificationValue){
		
		switch(identificationType){
			
			case "ID":
				return BaseTest.driver.findElement(By.id(identificationValue));
			case "Name":
				return BaseTest.driver.findElement(By.name(identificationValue));
			case "CSS":
				return BaseTest.driver.findElement(By.cssSelector(identificationValue));
			case "Xpath":
				return BaseTest.driver.findElement(By.xpath(identificationValue));
			case "tagName":
				return BaseTest.driver.findElement(By.tagName(identificationValue));
			case "classname":
				return BaseTest.driver.findElement(By.className(identificationValue));
			default:
				return null;
		}
	}
	
	public List<WebElement> getlistWebelements(String identificationType, String identificationValue){
		
	
		switch(identificationType){
	
		case "ID":
				return BaseTest.driver.findElements(By.id(identificationValue));
		case "Name":
				return BaseTest.driver.findElements(By.name(identificationValue));
		case "CSS":
				return BaseTest.driver.findElements(By.cssSelector(identificationValue));
		case "Xpath":
				return BaseTest.driver.findElements(By.xpath(identificationValue));
		case "tagName":
			return BaseTest.driver.findElements(By.tagName(identificationValue));
		default:
				return null;
}
}

}
