package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;



public class HomePageTest extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	
  @Test
  public void verifyManageProductButton() throws IOException {
	  hp=new HomePage(driver);
	  lp=new LoginPage(driver);
	  lp.sendUserName(loginDetails(0, 0));
	  lp.sendPassword(loginDetails(0, 1));
	  lp.signIn();
	  boolean actualBoolean= hp.manageProductEnabled();
	  Assert.assertEquals(actualBoolean, true, Constant.lp_verifyManageProductButton);
	  }
  
  @Test
  public void verifyManageCategoryButton() throws IOException {
	  hp=new HomePage(driver);
	  lp=new LoginPage(driver);
	  lp.sendUserName(loginDetails(0, 0));
	  lp.sendPassword(loginDetails(0, 1));
	  lp.signIn();
	  boolean actual=hp.manageCategoryEnabled();
	  Assert.assertEquals(actual, true, Constant.lp_verifyManageCategoryButton);
  }
}
