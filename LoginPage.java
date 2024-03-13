package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Identify Username Tf
	@FindBy(name="user_name")
private	WebElement usernametf;
	
	//Identify Password Tf
	@FindBy(name="user_password")
private	WebElement passwordtf;
	
	//Identify Login Button
	@FindBy(id="submitButton")
private	WebElement loginbtn;
	
	
	
public WebElement getUsernametf() {
		return usernametf;
	}
	public WebElement getPasswordtf() {
		return passwordtf;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//Create the Constructor-TO initilize webelement
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Create a Methods.
	public void Login(String usernamedata,String passworddata) {
		usernametf.sendKeys(usernamedata);
		passwordtf.sendKeys(passworddata);
		loginbtn.click();
		
	}
	
}
