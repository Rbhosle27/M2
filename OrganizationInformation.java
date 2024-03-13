package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebdriverUtil;

public class OrganizationInformation  {
	
	
	WebdriverUtil wutil=new WebdriverUtil();
	//Identify Organization Name.
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement Organizationnametf;

	//Identify  Group radio button.
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement radiobtn;

	//Identify Dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;
	
	//Identify Save Button.
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getRadiobtn() {
		return radiobtn;
	}
	
	public WebElement getOrganizationnametf() {
		return Organizationnametf;
	}
	
	public OrganizationInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Create a Method
	public void OrganizationInformation(String OrgnameData,String Groupdata)	{
		//Enter Organization Name.
		Organizationnametf.sendKeys(OrgnameData);
		//Click on radio btn.
		radiobtn.click();
		//Select Support group in the dropdown.
		wutil.handeldropdown(dropdown,Groupdata);
		//Click on save button.
		savebtn.click();
		
		

		
	}
	

}
