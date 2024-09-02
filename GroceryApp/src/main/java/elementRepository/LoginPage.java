package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "username")
	WebElement userNameField;
	@FindBy(name = "password")
	WebElement userPassword;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement errorMessage;

	public void sendUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void sendPassword(String password) {
		userPassword.sendKeys(password);
	}

	public void signIn() {
		signInButton.click();
	}
	
	public HomePage signInChain() {
		signInButton.click();
		return new HomePage(driver);
	}

	public String getErrorMessage() {
		return gu.getTextElement(errorMessage);
	}

}
