package utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	public void explicitWaitElementToBeClickable(WebDriver driver, WebElement element, int value) {
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(value));
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void explicitWaitElementToBeSelected(WebDriver driver, WebElement element, int value) {
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(value));
		explicitWait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void explicitWaitAlertIsPresent(WebDriver driver, int value) {
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(value));
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void explicitWaitElementSelectionState(WebDriver driver, int value, WebElement element) {
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(value));
		explicitWait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}
	
	public void fluentWaitMethod(WebDriver driver, int timeOut, int polling) {
		Wait<WebDriver> fluWaitObject=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(polling))
				.ignoring(NoSuchElementException.class);
	}
	
	public void fluentWait(WebDriver driver, int timeOut, int polling, WebElement element) {
		Boolean fluWaitObject=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(polling))
				.until(ExpectedConditions.invisibilityOf(element));
	}

}

