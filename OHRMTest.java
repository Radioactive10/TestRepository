package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRMTest {
	String driverPath = "C:\\Users\\kushal\\eclipse-workspace\\AutomationCG\\drivers\\chromedriver.exe";
	WebDriver driver;
	OHRMLoginPage objLoginPage;
	OHRMHomePage objHomePage;

	@BeforeTest
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void test_Home_Page_Appear_Correct() {
		objLoginPage = new OHRMLoginPage(driver);
		
		objLoginPage.loginToOHRM("Admin", "admin123");
		objHomePage = new OHRMHomePage(driver);
		
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().matches("^Welcome.*"));
		driver.close();
	}
	}
