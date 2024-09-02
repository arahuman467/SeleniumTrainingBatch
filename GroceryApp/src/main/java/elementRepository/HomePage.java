package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement manageProduct;
	@FindBy(xpath="//p[text()='Manage Category']")
	WebElement manageCategory;
	
	public String getDashboardText() {
		String dashboardText = dashboard.getText();
		return dashboardText;
	}
	
	public boolean manageProductEnabled() {
		
		boolean mpButton = gu.elementIsEnabled(manageProduct);
		return mpButton;
	}
	
	public boolean manageCategoryEnabled() {
		boolean mcButton = gu.elementIsDisplayed(manageCategory);
		return mcButton;
	}

}
