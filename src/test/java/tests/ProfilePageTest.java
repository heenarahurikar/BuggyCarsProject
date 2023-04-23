package test.java.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.security.SecureRandom;
import org.openqa.selenium.support.ui.Select;

public class ProfilePageTest extends BuggyCarsBaseTest {

	private String username = "heenaautomation";
	private String password = "Heena123$";
	private String firstName = "heena";
	private String lastName = "rahurikar";

	private String gender = "Female";
	private String age = "33";
	private String address = "Auckland, New Zealand";
	private String phone = "224234943";
	private String hobby = "Reading";

	/*
	 * verify updating basic info under profile page
	 */
	@Test(priority = 1)
	public void updateBasicInfo() throws InterruptedException {
		System.out.println("Test :: updateBasicInfo()");

		driver.findElement(By.name("login")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='/profile']")).click();

		driver.findElement(By.id("currentPassword")).clear();

		Thread.sleep(2000);

		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(firstName);

		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(lastName);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		Thread.sleep(2000);

		String result = driver.findElement(By.xpath("//div[contains(@class,'result alert')]")).getText();

		Assert.assertTrue(result.equals("The profile has been saved successful"), "Profile Update failed");
		Thread.sleep(2000);

	}
	
	/*
	 * verify updating additional info under profile page
	 */
	@Test(priority = 2)
	public void updateAdditionalInfo() throws InterruptedException {
		System.out.println("Test :: updateAdditionalInfo()");
		
		Thread.sleep(2000);

		driver.findElement(By.id("gender")).clear();
		driver.findElement(By.id("gender")).sendKeys(gender);

		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys(age);

		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys(address);

		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(phone);

		Select hobbyDropdown = new Select(driver.findElement(By.id("hobby")));
		hobbyDropdown.selectByVisibleText(hobby);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		String result = driver.findElement(By.xpath("//div[contains(@class,'result alert')]")).getText();

		Assert.assertTrue(result.equals("The profile has been saved successful"), "Profile Update failed");
		Thread.sleep(2000);
		
		//cancel
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();

	}
	
	/*
	 * validate profile info verify each field populated from above test 
	 */
	@Test(priority = 3)
	public void validateProfileInfo() throws InterruptedException {
		System.out.println("Test :: validateProfileInfo()");
		
		Thread.sleep(2000);
		//view profile 
		driver.findElement(By.xpath("//a[@href='/profile']")).click();
		
		System.out.println("FirstName"+driver.findElement(By.id("firstName")).getAttribute("value"));
		
		Assert.assertTrue(driver.findElement(By.id("firstName")).getAttribute("value").equals(firstName),"FirstName is not updated");
		Assert.assertTrue(driver.findElement(By.id("lastName")).getAttribute("value").equals(lastName),"LastName is not updated");
		Assert.assertTrue(driver.findElement(By.id("gender")).getAttribute("value").equals(gender),"Gender is not updated");
		Assert.assertTrue(driver.findElement(By.id("age")).getAttribute("value").equals(age),"Age is not updated");
		Assert.assertTrue(driver.findElement(By.id("address")).getAttribute("value").equals(address),"Address is not updated");
		Assert.assertTrue(driver.findElement(By.id("phone")).getAttribute("value").equals(phone),"Phone is not updated");
		Assert.assertTrue(driver.findElement(By.id("hobby")).getAttribute("value").equals(hobby),"Hobby is not updated");
		
		Thread.sleep(2000); 

	}

}
