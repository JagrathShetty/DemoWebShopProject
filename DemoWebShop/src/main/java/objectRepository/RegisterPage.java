package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

 public RegisterPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
	}
 
@FindBy(id = "gender-male")
private WebElement maleRadioBtn;

@FindBy(id = "gender-female")
private WebElement femaleRadioBtn;

@FindBy(id = "FirstName")
private WebElement firstNameTF;

@FindBy(id = "LastName")
private WebElement lastNameTF;

@FindBy(id = "Email")
private WebElement emailTF;

@FindBy(id = "Password")
private WebElement pwdTF;

@FindBy(id = "ConfirmPassword")
private WebElement confirmPwdTF;

@FindBy(id = "register-button")
private WebElement registerBtn;

public WebElement maleRB()
{
	return maleRadioBtn;
}

 public WebElement femaleRB()
 {
	 return femaleRadioBtn;
 }
 
 public WebElement firstNameTF()
 {
	 return firstNameTF;
 }
 
 public WebElement lastNameTF()
 {
	 return lastNameTF;
 }
 
 public WebElement emailTF()
 {
	return emailTF;	 
 }
 
 public WebElement pwdTF()
 {
	 return pwdTF;
 }
 
 public WebElement confirmPwdTF()
 {
	 return confirmPwdTF;
 }
 
 public WebElement registerBtn()
 {
	 return registerBtn;
 }

}
