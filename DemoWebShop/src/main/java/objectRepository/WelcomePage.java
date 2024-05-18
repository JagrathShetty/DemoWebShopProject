package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	@FindBy(id="small-searchterms")
	private WebElement searchTF;
	
	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;
	

	public WebElement getLoginLink()
	{
		return loginLink;
	}
	
	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getShoppingCartLink()
	{
		return shoppingCartLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

}
