package PageEvents;

import PageElements.HomepageElements;
import TestUtils.elementFetch;

public class homePage {
	
	public void homelogin() {
		
		elementFetch ef =new elementFetch();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ef.getWebelement("Xpath",HomepageElements.hotel).click();
		System.out.println("Hotel tab clicked");
	}

}
