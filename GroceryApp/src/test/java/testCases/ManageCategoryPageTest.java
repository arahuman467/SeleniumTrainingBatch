package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.ManageCategoryPage;
import elementRepository.LoginPage;

public class ManageCategoryPageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	ManageCategoryPage mcp;

	@Test(enabled = true)
	public void verifyManageCategoryPage() throws IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		mcp = new ManageCategoryPage(driver);
		lp.sendUserName(loginDetails(0, 0));
		lp.sendPassword(loginDetails(0, 1));
		lp.signIn();
		mcp.clickCategoryElement();
		String actual = mcp.getUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/list-category";
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled = false)
	public void verifyNewCategoryAdded() throws IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		mcp = new ManageCategoryPage(driver);
		lp.sendUserName(loginDetails(0, 0));
		lp.sendPassword(loginDetails(0, 1));
		lp.signIn();
		mcp.clickCategoryElement();
		mcp.clickNewButton();
		mcp.sendCategoryValue("WaterColor");
		mcp.clickSelectGroup();
		mcp.clickChooseFileButton();
		mcp.clickSaveButton();
		String actual = mcp.getAlertMessage();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = false)
	public void verifyNewCategoryAddedEnteredIntotable() throws IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		mcp = new ManageCategoryPage(driver);
		lp.sendUserName(loginDetails(0, 0));
		lp.sendPassword(loginDetails(0, 1));
		lp.signIn();
		mcp.clickCategoryElement();
		mcp.clickNewButton();
		mcp.sendCategoryValue("SweetCorn");
		mcp.clickSelectGroup();
		mcp.clickChooseFileButton();
		mcp.clickSaveButton();
		String actual = mcp.getAlertMessage();
		System.out.println(actual);
		String expected = "�\n"
				+ "Alert!\n"
				+ "Category Created Successfully";
		Assert.assertEquals(actual, expected);
		mcp.clickDashboardCategory();
		String actualString = mcp.newlyCreatedCategory("SweetCorn");
		String expectedString="SweetCorn";
		Assert.assertEquals(actualString, expectedString);
	}

}

