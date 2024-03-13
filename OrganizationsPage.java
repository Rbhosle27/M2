package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
			
		//Identify Create Organization ....(+).
		@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement createorganization;
		
		public WebElement getCreateOrganization() {
			return createorganization;
		}
		
		public OrganizationsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Create a Method
		public void Organizations() {
			//Click on Organization...(+)
			createorganization.click();
		}
		
		
}
