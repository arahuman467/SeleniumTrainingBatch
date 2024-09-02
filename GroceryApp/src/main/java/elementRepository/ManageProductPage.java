package elementRepository;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.text.FlowView;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.util.concurrent.Monitor.Guard;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageProductPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();
	public static Properties prop;
	
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section//div[@class='container-fluid']//div[8]//a[@class='small-box-footer']")
	WebElement manageProduct;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement listProductNewButton;
	@FindBy(id="title")
	WebElement titleElement;
	@FindBy(xpath="//input[@value='Nonveg']")
	WebElement producttypeElement;
	@FindBy(xpath="//select[@name='cat_id']")
	WebElement categoryDropdownButton;
	@FindBy(xpath="//select[@name='grp_id']")
	WebElement groupDropdownButton;
	@FindBy(xpath="//input[@value='piece']")
	WebElement priceTypeRadioButton;
	@FindBy(name="p_minimum")
	WebElement minimumPieceDropdown;
	@FindBy(name="p_max")
	WebElement maximumQuantityOrder;
	@FindBy(name="p_price")
	WebElement priceTextBox;
	@FindBy(name="p_stock")
	WebElement stockAvailabilityTextBox;
	@FindBy(xpath="//input[@name='main_img']")
	WebElement imageSelectFile;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//div[@role='alert']")
	WebElement alertMessage;
	
	public void listProductPage() {
		gu.clickJavaScriptExecutor(manageProduct, driver);
	}
	
	public void clickNewButton() {
		listProductNewButton.click();
	}
	
	public void enterTitle() {
		titleElement.sendKeys("chicken");
	}
	
	public void selectProductType() {
		producttypeElement.click();
	}
	
	public void selectCategoryOption() {
		JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,100)");
		Select selectObject=new Select(categoryDropdownButton);
		selectObject.selectByIndex(0);
	}
	
	public void selectGroupOption() {
		gu.selectSingleValueFromDropdownByValue(groupDropdownButton, "134");
	}
	
	public void clickPriceTypePiece() {
		priceTypeRadioButton.click();
	}

	public void selectMinimumPiece() {
		gu.scrollByElement(200, driver);
		gu.selectSingleValueFromDropdownByVisibleText(minimumPieceDropdown, "2 Piece");
	}
	
	public void enterMaximumQuantityForOrder() {
		maximumQuantityOrder.sendKeys("10");
	}
	
	public void enterPrice() {
		priceTextBox.sendKeys("20");
	}
	
	public void enterStockAvailability() {
		stockAvailabilityTextBox.sendKeys("100");
	}
	
	
	public void chooseImageFile() throws IOException {
		gu.scrollByElement(600, driver);
		imageSelectFile.sendKeys(prop.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles\\Chicken.jpg");
	}
	
	public void clickSaveButton() {
		gu.clickJavaScriptExecutor(saveButton, driver);
	}
	
	public String getAlertMessage() {
		return gu.getTextElement(alertMessage);
	}
	
	public String getUrl() {
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}

}
