package BasicPOM;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtils;
import CommonUtils.ProertyFileUtil;
import CommonUtils.WebdriverUtil;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationInformation;
import POM.OrganizationsPage;

public class BasePage{
	

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		
		
		//Object Creartion.
	ProertyFileUtil util= new ProertyFileUtil();
	ExcelUtil eutil= new ExcelUtil();
	WebdriverUtil wutil= new WebdriverUtil();
	JavaUtils jutil= new JavaUtils();
	
	//TO read data from property file
	String BROWSER=util.getDataFromPropertyFile("Browser");
	String URL=util.getDataFromPropertyFile("url");
	String USERNAME=util.getDataFromPropertyFile("Username");
	String PASSWORD=util.getDataFromPropertyFile("Password");
	
	
	//To read data from Excel file
	String ORGNAME=eutil.getDataFromExcel("Oraginations", 0, 1);
	String GROUP=eutil.getDataFromExcel("Oraginations", 1, 1);
		
		//To launch the browser
	if (BROWSER.equals("Chrome")) {
		driver= new ChromeDriver();
	} else if (BROWSER.equals("Edge")) {
		driver= new EdgeDriver();
	} else {
		driver= new FirefoxDriver();
		
	}
		
	
		driver.manage().window().maximize();
		//To launch the application.
		driver.get(URL);
		
		//Create Object of LoginPage.
		LoginPage lp= new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		//To login the application.
//		lp.getUsernametf().sendKeys(USERNAME);
//		lp.getPasswordtf().sendKeys(PASSWORD);
//		lp.getLoginbtn().click();
		
		
		//Create Object of Homepage.
		HomePage hp=new HomePage(driver);
		
		hp.Home(driver);
//		hp.getOrganization().click();
		
		
		//Create the object of organization page
		OrganizationsPage op= new OrganizationsPage(driver);
		//Click on Organization...(+)
		op.Organizations();
		//op.getCreateOrganization().click();
		
		//Create the object of OrganizationInformation page.
		OrganizationInformation oip= new OrganizationInformation(driver);
		//Enter Organization Name.
//		oip.getOrganizationnametf().sendKeys(ORGNAME+jutil.getRandomNumber());
		oip.OrganizationInformation(ORGNAME+jutil.getRandomNumber(),GROUP);
		//Click on radio btn.
//		oip.getRadiobtn().click();
		//Select Support group in the dropdown.
//		wutil.handeldropdown(oip.getDropdown(), GROUP);
		
		//Click on save button.
//		oip.getSavebtn().click();
		Thread.sleep(4000);
	//Mouse Hover on image
		hp.Home(driver);
		Thread.sleep(1000);
//		wutil.mousehover(driver, hp.getImage());
		//Click on SignOut Button.
//		hp.getSignOut().click();
		hp.Home();
		
	
	}

}
