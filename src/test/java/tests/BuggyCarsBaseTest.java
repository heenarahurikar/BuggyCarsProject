package test.java.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BuggyCarsBaseTest {

	protected static WebDriver driver;
	private static String appurl = "https://buggy.justtestit.org/";

	/*
	 * Setup method to start loading chromedriver and open application URL
	 */
	@BeforeClass
	public static void setUp() {
		System.out.println("setUp()");
		System.out.println("Loading WebDriver");
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		System.out.println("Loading application URL : " + appurl);
		driver.get(appurl);
	}

	/*
	 * Cleanup method to delete any cookies for session
	 */
	@AfterMethod
	public void cleanUp() {
		System.out.println("cleanUp()");
		driver.manage().deleteAllCookies();
	}
	
	
	/*
	 * terDown method to close quit the browser session 
	 */
	@AfterClass
	public static void tearDown() {
		System.out.println("tearDown()");
		driver.quit();
	}

}
