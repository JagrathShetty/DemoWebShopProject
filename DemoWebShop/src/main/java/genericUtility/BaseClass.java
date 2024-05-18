package genericUtility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class BaseClass {

	public static ExtentReports extReports;
	public ExtentTest test;
	public static WebDriver driver;
	public WebDriverWait wait;
	
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib;
	public ExcelUtility eLib;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	
	@BeforeSuite
	public void reportConfig() {
		String time= jLib.getSystemTime();
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/ExtentReport_"+time+".html");
		extReports=new ExtentReports();
		extReports.attachReporter(spark);
	}
	
	@Parameters("Browser")
	
	@BeforeClass 
	public void openBrowser(@Optional("Chrome")String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		fLib=new FileUtility();
		String URL=fLib.getDataFromProperty("url");
		driver.get(URL);
}
	
	@BeforeMethod
	public void login(Method method) throws EncryptedDocumentException, IOException {
		test=extReports.createTest(method.getName());
		wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		lp=new LoginPage(driver);
		String Email = fLib.getDataFromProperty("email");
		String Password = fLib.getDataFromProperty("password");
		lp.getEmailTF().sendKeys(Email);
		lp.getPwdTF().sendKeys(Password);
		lp.getLoginBtn().click();
		eLib=new ExcelUtility();
		String expectedTitle = eLib.getStringDataFromExcel("TS_Data_Login",1,2);
		Assert.assertEquals(driver.getTitle(),expectedTitle,"Home page is not displayed");
		test.log(Status.PASS,"Home page is displayed");
		hp=new HomePage(driver);
			
	}
	
	
	@AfterMethod
	public void logout() {
		hp.getLogoutLink().click();
		test.log(Status.INFO,"User Logged out");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void flush() {
		extReports.flush();
	}		
}
