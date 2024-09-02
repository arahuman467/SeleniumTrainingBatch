package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

public class GeneralUtilities {

	public String getTextElement(WebElement element) {
		return element.getText();
	}

	public void selectSingleValueFromDropdownByValue(WebElement element, String value) {
		Select svbValue = new Select(element);
		svbValue.selectByValue(value);
	}

	public String selectSingleValueFromDropdownByIndex(WebElement element, int value) {
		Select svbIndex = new Select(element);
		svbIndex.selectByIndex(value);
		WebElement selectedElementByIndex = svbIndex.getFirstSelectedOption();
		return selectedElementByIndex.getText();
	}

	public void selectSingleValueFromDropdownByVisibleText(WebElement element, String value) {
		Select svbVisibleText = new Select(element);
		svbVisibleText.selectByVisibleText(value);
	}

	public ArrayList<String> selectMultipleValueFromDropdownByValue(WebElement element, int limit) {
		Select smvbValue = new Select(element);
		ArrayList<String> selectedValue=new ArrayList<String>();
		String value=null;
		for (int i = 0; i < limit; i++) {
			smvbValue.selectByIndex(i);
		}
		List<WebElement> selectedElementByValue = smvbValue.getAllSelectedOptions();
		for (int j = 0; j < selectedElementByValue.size(); j++) {
			value = selectedElementByValue.get(j).getText();
			selectedValue.add(value);
		}
		return selectedValue;

	}

	public boolean elementIsSelected(WebElement element) {
		element.click();
		boolean b = element.isSelected();
		return b;
	}

	public boolean elementIsDisplayed(WebElement element) {
		boolean d = element.isDisplayed();
		return d;
	}

	public boolean elementIsEnabled(WebElement element) {
		boolean e = element.isEnabled();
		return e;
	}

	public void mouseRightClick(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.contextClick(element).perform();
	}

	public void mouseDoubleClick(WebDriver driver, WebElement element) {
		Actions actionsObject = new Actions(driver);
		actionsObject.doubleClick(element).perform();
	}

	public void alertBoxAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertBoxDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void alertBoxSendKeys(WebDriver driver, String value) {
		Alert alertObject = driver.switchTo().alert();
		alertObject.sendKeys(value);
		alertObject.accept();
	}

	public int randon(int limit) {
		Random random = new Random();
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	
	public String generateCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");	
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}
	
	public void scrollByElement(int value, WebDriver driver) {
		JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, "+value+")");

	}
	
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

}
