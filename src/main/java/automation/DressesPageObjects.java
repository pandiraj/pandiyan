package automation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObjects extends BasePage {

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement headcount;

	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	private List<WebElement> lstProduct;

	@FindBy(xpath = "//div/ul/li[2]//*[text()='Dresses']")
	private WebElement dressesTab;

	@FindBy(xpath = "//span//preceding::a[last()-34]")
	private WebElement clickProduct;

	@FindBy(xpath = ("//*[@id='add_to_cart']/button/span"))
	private WebElement addToCart;

	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
	private WebElement cartAddedSuccess;

	@FindBys(@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[*]/label/a"))
	private List<WebElement> allSizes;

	public DressesPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public int getProductCount() {
		dressesTab.click();
		return lstProduct.size();
	}

	public int getProductCountFromHeader() {
		/*
		 * String msg=headcount.getText(); String[] arr=msg.split(" "); String
		 * text=arr[2]; int value=Integer.parseInt(text); return value;
		 */
		return Integer.parseInt(headcount.getText().split(" ")[2]);
	}

	public ArrayList<String> getAllSize() {
		dressesTab.click();
		ArrayList<String> sizeList = new ArrayList<String>();
		Iterator<WebElement> itr = allSizes.iterator();
		while (itr.hasNext()) {
			sizeList.add(itr.next().getText());
		}
		return sizeList;
	}

	public String getProductAddedcart() {
		clickProduct.click();
		isElementVisible(addToCart);
		addToCart.click();
		isElementVisible(cartAddedSuccess);
		String str = cartAddedSuccess.getText();
		System.out.println(str);
		return str;
	}

}
