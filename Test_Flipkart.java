package Test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Locators.Locators;

public class Test_Flipkart extends BasePage{
	int count = 0;
	Locators locators = new Locators(getDriver());
	String ParentWindow;
	String ObjectInCart;
	
//	Simple Logging
	public void log(String text) {
		System.out.println(""+new Date()+"\t"+ count++ +"\t"+text);
	}
	
	@Test
	public void TC001_launch_website() throws AWTException, InterruptedException {
		launch_url("https://www.flipkart.com/");
		log("WebBrowser Launched");
		
		assertEquals(getTitle(),"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		log("Assertion checked Title Matched");
		
		ParentWindow = getParentWindow();
		log("Parent Window assigned");
		
		ClearInbox();
		log("For Safe: Clearing Inbox of temp mail");
	}
	
	public void ClearInbox() throws AWTException, InterruptedException {	
		
		// WINDOW SWITCH REQUIRED
		new_tab();
		log("New Tab Opened");
		
		new_window_switch(ParentWindow);
		log("New Window Switch occured successfully");
		
		getDriver().navigate().to("https://www.guerrillamail.com/");
		log("Navigated to Temp Mail page");
		
		click_element(locators.EditMailName);
		log("Edit Mail name, block clicked");
		
		send_text(locators.EditMailNameInputBox,"random001");
		log("Email Name: random001 provided");
		
		click_element(locators.SetMailButtom);
		log("Set Button clicked to fix the email.name");
		
		dropdowns_by_text(locators.EditMailHost,"grr.la");
		log("Domain changed to grr.la");
		
		Thread.sleep(2000);
		for(WebElement i :locators.CheckBoxes) {
			click_element(i);
		}
		log("All Mail Checkboxes clicked");
		
		click_element(locators.DeleteMail);
		log("Deleting all the Mail");
		
		Thread.sleep(2000);
		close_tab();
		log("TEMP Mail tab closed using CTRL+W keys");
		
		window_switch_string(ParentWindow);
		log("RE-SWITCH to Parent Window");
				
	}
	
	public String GetOTPFromMail() throws AWTException, InterruptedException {
		// WINDOW SWITCH REQUIRED
		new_tab();
		log("New Tab Opened");
		
		new_window_switch(ParentWindow);
		log("New Window Switch occured successfully");
		
		getDriver().navigate().to("https://www.guerrillamail.com/");
		log("Navigated to Temp Mail page");
		
		click_element(locators.EditMailName);
		log("Edit Mail name, block clicked");
		
		send_text(locators.EditMailNameInputBox,"random001");
		log("Email Name: random001 provided");
		
		click_element(locators.SetMailButtom);
		log("Set Button clicked to fix the email.name");
		
//		dropdowns_by_text(locators.EditMailHost,"grr.la");
//		log("Domain changed to grr.la");
//		
//		if(locators.CheckBoxEmailScramble.isSelected()) {
//			click_element(locators.CheckBoxEmailScramble);
//			log("Email name scrambled checkbox: UNCHECKED");
//		}
		
		// Static Wait for 5seconds
		Thread.sleep(1000*10);
		log("Static wait for 5 seconds to manually forward the gmail OTP mailto Temp");
		
		String a = getText(locators.VerificationCodeText);
		String OTP = a.substring(a.indexOf("-")+2,a.indexOf("-")+8);
		log("Verification code reterived: "+OTP);
		
		Thread.sleep(1000);
		close_tab();
		log("TEMP Mail tab closed using CTRL+W keys");
		
		window_switch_string(ParentWindow);
		log("RE-SWITCH to Parent Window");
		return OTP;	
	}
	
	@Test
	public void TC002_User_Auth() throws InterruptedException, AWTException {
		click_element(locators.LoginButton);
		log("Login button clicked");
		
		assertEquals(getURL().contains("login"),true);
		log("Assert checked whether the URL contains the login keyword :"+getURL());
		
		send_text(locators.LoginInputBox,locators.username);
		log("Email provided in the Email Text Box");
		
		click_element(locators.RequestOTPButton);
		log("Request OTP button clicked");
		
		Thread.sleep(5000);
		log("Static wait for 5Seconds");
		
//		INCONSISTENTLY APPEARING IN THE WEBSITE
//		if(locators.VerifyHuman.isDisplayed()) {
//			click_and_hold(locators.VerifyHuman,7000); // Hold time varies randomly
//			log("Verify Human actions");
//		}
		
		log("OTP RETERIVAL PART");
		String code = GetOTPFromMail();
		for(int i=0;i<locators.OTPs.size();i++) {
			send_text(locators.OTPs.get(i),code.toCharArray()[i]+"");
		}
		log("OTP provided");
		
		Thread.sleep(5000);
		log("Static wait for Safety purpose | manual interpution as the given ENV is not TEST ENV");
		
//		FOR SAFETY PURPOSE
		click_element(locators.CartOption);
		int CartItems = locators.RemoveObjectFromCart.size();
		log("Cart is clicked from the HomePage"+" "+CartItems+" Items in cart");
		if( CartItems >= 1) {
			for(WebElement i:locators.RemoveObjectFromCart) {
				click_element(i);
				Thread.sleep(1000); // DOM contains same xpath for the pop window and the before CTA so static wait here
				click_element(locators.RemovePopUp);
			}
			log("Removing the carts items");
		}
		
		click_element(locators.HomeButton);
		log("Home Button clicked");	
	}
	
	@Test
	public void TC003_Search_LapTop() throws AWTException {
		send_text(locators.SearchBox,locators.searchInput);
		log("Search keywords given to Search Bar");
		
		hit_enter();
		log("Keyboard Enter is used to initiate Search");
		assertEquals(getText(locators.SearchResultTitle).toLowerCase(),"laptop");
		log("Assertion done with the laptop keyword");
				
		// First Search page result Iteration
		for (int i=0;i<=locators.LapTopSearchListName.size()-1;i++) {
			System.out.println(getText(locators.LapTopSearchListName.get(i)));
			System.out.println();
			System.out.println(getText(locators.LapTopSearchListPrice.get(i)));
			
		}
	}
	
	@Test
	public void TC004_Click_and_AddToCart() throws AWTException, InterruptedException {
		click_element(locators.LapTopSearchListName.get(0));
		log("First search Item clicked");
		
		new_window_switch(ParentWindow);
		log("Switched to PRODUCT DESCRIPTION PAGE");
		
		Thread.sleep(1000); // TO Observe in recording
		click_element(locators.AddToCartButton);
		log("Add to Cart button clicked");
		
		System.err.println("---ERROR---");
		log("UN Wanted INFO Message"+locators.ProductOutOfStockInfo.isDisplayed());
		// BUG HERE !!!
		// IN WEBSITE IT THROWS THE OUT OF STOCK INFO MESSAGE 
		// YET ADDED IN THE CART
		
		refresh_tab();
		log("Refreshing the tab - so the GO TO CART CTA state will change");
		
//		assertEquals(locators.GoToCartButton.isDisplayed(),true);
//		log("Assert GoToCart Button is displayed");
		
		ObjectInCart = locators.ProductName.getText();
		log("Product Name Captured: "+ObjectInCart);
		
		close_tab();
		log("Closing the PDP Page");
		
		window_switch_string(ParentWindow);
		log("RE-SWITCH to Parent Window");
	}
	
	@Test
	public void TC005_Check_Cart() {
		click_element(locators.CartOption);
		log("Cart is clicked from the HomePage");
		
//		assertEquals(getText(locators.CartProductName),ObjectInCart);
		log("Object from the Product description page "+ObjectInCart);
		log("Cart Object is "+getText(locators.CartProductName));
		
		click_element(locators.PlaceOrderButton);
		log("Place Order button clicked");
	}
	
	@Test
	public void TC006_ShippingAddress() throws InterruptedException {
//		click_element(locators.ChangeAddress);
//		log("Change CTA in Address bar is clicked");
		
		click_element(locators.AddNewAddress);
		log("New Address Add option is clicked");
		
		send_text(locators.AddressName,"Deva");
		log("Name provided in address");
		
		send_text(locators.AddressMobile,"9751251492");
		log("Mobile Number provided in address");
		
		send_text(locators.AddressPincode,"607106");
		log("Pincode provided in address");
		
		send_text(locators.AddressLocality,"Panruti");
		log("Locality Summary Text");
		
		send_text(locators.Address,"206, East Street, Aunguchettipalayam, Panruti - 607106");
		log("Address Summary Text");
		
		click_element(locators.SaveAddress);
		log("SAVE button clicked");
		
//		BUG HERE | INCONSISTENT
//		AFTER CLICKING SAVE BUTTON
//		ERROR MESSAGE THROWN YET ON REFRESH, NEW ADDRESS ADDED
		
		refresh_tab();
		log("TAB refreshed");
		
		simple_alert();
		log("Alert Handled");
		
		Thread.sleep(1000);
		
		click_element(locators.DeliverHereButton);
		log("Deliver here button clicked");
		
		click_element(locators.AcceptAndContinue);
		log("Accept and continue clicked");
	}
	
	@Test
	public void TC006_OrderSummary() {
		log("Order Summary Text");
		for (WebElement text : locators.SummaryText) {
			System.out.println(text.getText());
		}
	}
	
//	@Test
	public void TC000_fail_case() {
		assertEquals(1,3);
	}


}
