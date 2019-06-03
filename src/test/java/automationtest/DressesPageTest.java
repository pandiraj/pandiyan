 package automationtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.DressesPageObjects;
import automation.HomePageObjects;
 public class DressesPageTest {
	HomePageObjects hp;
	DressesPageObjects dpo;

	public DressesPageTest() {
		hp = new HomePageObjects();
		dpo = new DressesPageObjects();
	}

	// Verifying product count is displaying

	@Test()
	public void verifyProductCount() {
		Assert.assertTrue(dpo.getProductCount() == dpo.getProductCountFromHeader(), "Count Mismatched");
	
	}

	// Add first product and verify its added to cart
	@Test
	public void verifyProductAddedIntoCart() {
			Assert.assertTrue(dpo.getProductAddedcart().contains("success"), "");
		} 
			

	@Test
	public void verifyAllSizes() {
		ArrayList<String> sizeList = dpo.getAllSize();
		System.out.println(sizeList);
		Assert.assertTrue(sizeList.contains("S (5)"), "");
		Assert.assertTrue(sizeList.contains("M (5)"), "");
		Assert.assertTrue(sizeList.contains("L (5)"), "");
	}
}
