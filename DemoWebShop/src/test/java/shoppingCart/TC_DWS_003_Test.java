package shoppingCart;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class TC_DWS_003_Test extends BaseClass {
	
	@Test
	public void addProduct() {
		hp.getAddToCartButtons().get(1).click();
		Assert.assertEquals(hp.getProductAddedMsg().isDisplayed(),true,"Product failed to add");
		test.log(Status.PASS, "Product added successfully");
		wait.until(ExpectedConditions.invisibilityOf(hp.getProductAddedMsg()));
	}
	

}
