package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ExcelUtilities excelUtility=new ExcelUtilities();
	
  @Test
  public void verifyLoginWithValidData() throws IOException {
	  lp=new LoginPage(driver);
//	  hp=new HomePage(driver);
	  lp.sendUserName(loginDetails(0, 0));
	  lp.sendPassword(loginDetails(0, 1));
	  hp=lp.signInChain();
	  String actual=hp.getDashboardText();
	  String expected="Dashboard";
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);
  }
  
  @Test(dataProvider = "loginDetails", enabled = false)
  public void verifyLoginWithInvalidData(String s1, String s2) throws IOException {
	  lp=new LoginPage(driver);
	  lp.sendUserName(loginDetails(0, 0));
	  lp.sendPassword(loginDetails(0, 1));
	  lp.signIn();
	  String actual=lp.getErrorMessage();
	  String expected="Alert!";
	  Assert.assertEquals(actual, expected, "Login error message not as expected");
  }
  
  @DataProvider
  public Object[][] loginDetails() {
    return new Object[][] {
    	{"admin", "pass"}, {"aduser", "admin"}, {"login", "web"}
    };
  }
  
}
