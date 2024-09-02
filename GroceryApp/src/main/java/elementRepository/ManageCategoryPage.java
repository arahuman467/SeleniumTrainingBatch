package elementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;
import utilities.GeneralUtilities;

public class ManageCategoryPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public static Properties prop;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section//div[@class='container-fluid']//div//div[3]//div//a[@class='small-box-footer']")
	WebElement categoryElement;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement categoryWebElement;
	@FindBy(xpath="//li[@id='134-selectable']//span[text()='discount']")
	WebElement selectGroupElement;
	@FindBy(name="main_img")
	WebElement chooseFileButton;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']//li[2]//p[text()='Category']")
	WebElement dashboardCategory;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> tableRows;
		
	public void clickCategoryElement() {
		categoryElement.click();
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void sendCategoryValue(String category) {
		categoryWebElement.sendKeys(category);
	}
	
	public void clickSelectGroup() {
		selectGroupElement.click();
	}
	
	public void clickChooseFileButton() {
		JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,200)");
		chooseFileButton.sendKeys(prop.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles\\Crayons Picture.jpg");
	}
	
	public void clickSaveButton() {
		gu.clickJavaScriptExecutor(saveButton, driver);
	}
	
	public String getAlertMessage() {
		return gu.getTextElement(alertMessage);
	}
	
	public void clickDashboardCategory() {
		dashboardCategory.click();
	}
	
	public String newlyCreatedCategory(String value) {
		List<WebElement> rows=tableRows;
		String categoryValueAdded = null;
		for(int i=0; i<rows.size(); i++) {
			if (rows.get(i).getText().equals(value)) {
				String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(i+1)+"]//td[1]";
				WebElement findCategory=driver.findElement(By.xpath(locator));
				categoryValueAdded = findCategory.getText();
				break;
			}
		}
			return categoryValueAdded;
		}
	
	public String getUrl() {
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}
	
}
