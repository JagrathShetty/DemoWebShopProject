package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "14.1-inch Laptop")
	private WebElement productName;
	
	@FindBy(xpath = "//h1[text()='Shopping cart']")
	private WebElement shoppingCartText;
	
	@FindBy(name = "removefromcart")
	private WebElement removeFromCart;
	
	public WebElement getProductName()
	{
	return productName;	
	}
	
	public WebElement getShoppingCartText()
	{
		return shoppingCartText;
	}

}
