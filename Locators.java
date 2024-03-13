package Locators;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BasePage;

public class Locators {
	
	BasePage base = new BasePage();
	
	
	public Locators(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	TEST DATA
	
	public final String username = "9514688432";
	public final String searchInput = "laptop";
	
//	GMAIL PAGE // Can't Sign In Gmail blocked for the security reason
	@FindBy(xpath="//a[text()='Sign in']")
	public WebElement GMailSignInButton;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement GMailEmailInputbox;

	@FindBy(xpath="//input[@type='password']")
	public WebElement GMailKeyInputbox;
	
	@FindBy(xpath="(//span[contains(text(),'Flipkart Account') and contains(text(),'verification code')])[1]")
	public WebElement FlipKartOTP;
	
//	WORK AROUND STACK OVERFLOW // Tried work-around 1 failed
	@FindBy(xpath="//a[text()='Log in']")
	public WebElement StackOverflowLogin;

	@FindBy(xpath="//button[@data-provider='google']")
	public WebElement GoogleSSO;
	
//	METHOD 3 - FORWARDING THE OTP TO DISPOSAL MAILS AND RETERIVE
	
	@FindBy(css="#inbox-id")
	public WebElement EditMailName;
	
	@FindBy(css="#inbox-id>input")
	public WebElement EditMailNameInputBox;
	
	@FindBy(xpath="//button[text()='Set']")
	public WebElement SetMailButtom;
	
	@FindBy(css="#gm-host-select")
	public WebElement EditMailHost;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	public WebElement CheckBoxEmailScramble;
	
	@FindBy(xpath="(//td[contains(text(),'Flipkart')])[1]")
	public WebElement VerificationCodeText;
	
	@FindBy(xpath="//td//input[@type='checkbox']")
	public List<WebElement> CheckBoxes;
	
	@FindBy(css="#del_button")
	public WebElement DeleteMail;
	
//	LOGIN PAGE
	@FindBy(xpath="//span[text()='Login']")
	public WebElement LoginButton;
	
	@FindBy(xpath="//span[contains(text(),'Email')]//..//preceding-sibling::input")
	public WebElement LoginInputBox;
	
	@FindBy(xpath="//button[contains(text(),'OTP')]")
	public WebElement RequestOTPButton;
	
	@FindBy(xpath="//div[@id='px-captcha']")
	public WebElement VerifyHuman;
	
	@FindBy(xpath="//div[contains(text(),'OTP sent to')]//following-sibling::form//input")
	public List<WebElement> OTPs;
	
//	HOME PAGE
	
	@FindBy(xpath="//img[@alt='Flipkart']")
	public WebElement HomeButton;
	
	@FindBy(xpath="//input[@name='q']")
	public WebElement SearchBox;
	
	@FindBy(xpath="//a[contains(@href,'viewcart')]")
	public WebElement CartOption;
	
//	LAPTOP SEARCH RESULT PAGE
	@FindBy(xpath="//span[contains(text(),'results')]//child::span")
	public WebElement SearchResultTitle;
	
	@FindBy(xpath="//div[contains(@data-tkid,'SEARCH')]//a//div[contains(@class,'col')][1]//div[contains(text(),' ')]")
	public List<WebElement> LapTopSearchListName;
	
	@FindBy(xpath="//div[contains(@data-tkid,'SEARCH')]//a//div[contains(@class,'col')][2]//div[contains(text(),'₹')][1]")
	public List<WebElement> LapTopSearchListPrice;
	
//	PRODUCT DESCRIPTION PAGE
	@FindBy(xpath="//button[text()='Add to cart']//..")
	public WebElement AddToCartButton;
	
	@FindBy(xpath="//button[text()='GO TO CART']")
	public WebElement GoToCartButton;
	
	@FindBy(xpath="//div[text()='Product is now out of stock.']")
	public WebElement ProductOutOfStockInfo;
	
	@FindBy(xpath="//h1//span//text()")
	public WebElement ProductName;
	
//	CART PAGE
	@FindBy(xpath="(//span[contains(text(),'₹')])[1]//parent::div//a/text()")
	public WebElement CartProductName;
	
	@FindBy(xpath="//span[text()='Place Order']//parent::button")
	public WebElement PlaceOrderButton;
	
	@FindBy(xpath="//div[text()='Delivery Address']//parent::div//following-sibling::button")
	public WebElement ChangeAddress;
	
	@FindBy(xpath="//div[text()='Remove']")
	public List<WebElement> RemoveObjectFromCart;
	
	@FindBy(xpath="//div[contains(text(),'Are you sure')]//..//div[text()='Remove']")
	public WebElement RemovePopUp;

	@FindBy(xpath="//div[text()='Add a new address']")
	public WebElement AddNewAddress;
	
//	SHIPPING PAGE
	@FindBy(xpath="//label[text()='Name']//preceding-sibling::input")
	public WebElement AddressName;
	
	@FindBy(xpath="//label[contains(text(),'number')]//preceding-sibling::input")
	public WebElement AddressMobile;
	
	@FindBy(xpath="//label[contains(text(),'Pincode')]//preceding-sibling::input")
	public WebElement AddressPincode;
	
	@FindBy(xpath="//label[contains(text(),'Locality')]//preceding-sibling::input")
	public WebElement AddressLocality;
	
	@FindBy(xpath="//label[contains(text(),'Address')]//preceding-sibling::textarea")
	public WebElement Address;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement SaveAddress;
	
	@FindBy(xpath="//button[text()='Deliver Here']")	
	public WebElement DeliverHereButton;
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	public WebElement ContinueButton;
	
	@FindBy(xpath="//button[text()='Accept & Continue']")
	public WebElement AcceptAndContinue;
	
//	ORDER SUMMARY
	@FindBy(xpath="(//span[contains(text(),'Seller')]//parent::div//parent::div)[1]//text()")
	public List<WebElement> SummaryText;
}
