package test.java.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BuggyCarsBaseTest {

	private String usernameVal = "heenaautomation";
	private String usernameInvalid = "wrongusername";
	private String passwordVal = "Heena123$";
	private String firstname = "heena";

	/*
	 * Verify home page title 
	 */
	@Test(priority = 1)
	public void verifyTitle() {
		System.out.println("Test :: verifyTitle()");
		Assert.assertTrue(driver.getTitle().equals("Buggy Cars Rating"));
	}

	/*
	 * validate application login by passing username and password and login to application, verify if the login user is same user
	 */
	@Test(priority = 2)
	public void validateLogin() throws InterruptedException {
		System.out.println("Test :: validateLogin()");
		
		Thread.sleep(2000);

		driver.findElement(By.name("login")).sendKeys(usernameVal);
		driver.findElement(By.name("password")).sendKeys(passwordVal);

		// driver.findElement(By.className("btn-success")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		// String profilename = driver.findElement(By.className("nav-link")).getText();
		String profilename = driver.findElement(By.xpath("//span[contains(text(),'Hi')]")).getText();

		Assert.assertTrue(profilename.contentEquals("Hi, " + firstname));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
	}
	
	/*
	 * validate invalid login by passing wrong user name and check if user not able to login
	 */
	@Test(priority = 3)
	public void inValidateLogin() throws InterruptedException {
		System.out.println("Test :: inValidateLogin()");

		Thread.sleep(2000);
		
		driver.findElement(By.name("login")).sendKeys(usernameInvalid);
		driver.findElement(By.name("password")).sendKeys(passwordVal);

		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		String errormessage = driver.findElement(By.xpath("//span[contains(text(),'Invalid username/password')]")).getText();
		Assert.assertTrue(errormessage.contentEquals("Invalid username/password"));
		
		Thread.sleep(2000);
	}
}
