package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtil {
	
	public WebDriver d;
		public void Maximize(WebDriver d) {
			d.manage().window().maximize();
		}
		public void implicitwait(WebDriver d)
		{
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		public void HandleDropDown(WebElement element,String targetedelement) {
			Select a=new Select(element);
			a.selectByVisibleText(targetedelement);
		}
		public void MouseHover(WebDriver d,WebElement Admin) {
			Actions ac=new Actions(d);
			ac.moveToElement(Admin);
			ac.perform();
		}
		public void SwitchTo(WebDriver d,String ExpectedUrl) {
			Set<String> ids=d.getWindowHandles();
			for (String e : ids) {
			String acturalurl=	d.switchTo().window(e).getCurrentUrl();
				
				if(acturalurl.contains(ExpectedUrl)) {
					break;
				}
			}
		}
		public File Screenshot(WebDriver d,String screenshotname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) d;
			File tempfile=ts.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("./Screenshot/"+screenshotname+".png");
			FileUtils.copyFile(tempfile, destinationFile);
			return destinationFile;
		}
}
