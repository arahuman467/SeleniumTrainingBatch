package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ManageProductPage;
import elementRepository.LoginPage;

public class ManageProductPageTest extends BaseClass{
	
	LoginPage lp;
	ManageProductPage mpp;
	
  @Test(enabled = true)
  public void verifyListProductPage() throws IOException {
	  lp=new LoginPage(driver);
	  mpp=new ManageProductPage(driver);
	  lp.sendUserName(loginDetails(0, 0));
	  lp.sendPassword(loginDetails(0, 1));
	  lp.signIn();
	  mpp.listProductPage();
	  String actual = mpp.getUrl();
	  String expected = "https://groceryapp.uniqassosiates.com/admin/list-product";
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(enabled = false)
  public void verifyAddProductPage() throws IOException {
	  lp=new LoginPage(driver);
	  mpp=new ManageProductPage(driver);
	  lp.sendUserName(loginDetails(0, 0));
	  lp.sendPassword(loginDetails(0, 1));
	  lp.signIn();
	  mpp.listProductPage();
	  mpp.clickNewButton();
	  mpp.enterTitle();
	  mpp.selectProductType();
	  mpp.selectCategoryOption();
	  mpp.selectGroupOption();
	  mpp.clickPriceTypePiece();
	  mpp.selectMinimumPiece();
	  mpp.enterMaximumQuantityForOrder();
	  mpp.enterPrice();
	  mpp.enterStockAvailability();
	  mpp.chooseImageFile();
	  mpp.clickSaveButton();
	  String actual=mpp.getAlertMessage();
	  String expected="Image does not have a valid mime type.\n"
	  		+ "The Category field is required.\n"
	  		+ "The Sub Category field is required.";
	  Assert.assertEquals(actual, expected);
  }
  
}
