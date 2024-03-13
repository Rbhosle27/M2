package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebdriverUtil;

public class HomePage extends WebdriverUtil {

	//Identify Organization.		
	@FindBy(linkText="Organizations")
private	WebElement organization;
	
	//Identify Contact.
	@FindBy(linkText="Contacts")
private	WebElement contacts;
	
	//Identify images.
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private	WebElement image;
	
	//Identify SignOut
	@FindBy(xpath = "(//a[@class='drop_down_usersettings'])[2]")
private	WebElement signOut;

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	//Create a Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Create a Method.
	public void Home(WebDriver d) {	
		//Click on Organization.
		organization.click();
		//Mouse Hover on image
		mousehover(d, image);
		//Click on SignOut Button.
		
		
		
	}
	
	public void Home()
	{
		signOut.click();
	}

	
	
	
	
}
