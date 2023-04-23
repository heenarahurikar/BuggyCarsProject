package test.java.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.security.SecureRandom;

public class RegisterPageTest extends BuggyCarsBaseTest {

	private String username = "";
	private String firstName = "heenaregister";
	private String lastName = "rahurikar";
	private String password = "Heena123$";
	
	
	/*
	 * validate new registration
	 */
	@Test
	public void validateNewRegistration() throws InterruptedException {
		System.out.println("Test :: validateNewRegistration()");

		// Click on Register button
		//driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		driver.findElement(By.xpath("//a[@href='/register']")).click();
		
		Thread.sleep(2000);
		
		username = "heena"+randomString(5); // Generate username of random 5 characters

		newRegistration(username);
		System.out.println("New user registered = " + username);

		String result = driver.findElement(By.xpath("//div[contains(@class,'result alert')]")).getText();
		Assert.assertTrue(result.equals("Registration is successful"),
				"Registration is not successfull");

		Thread.sleep(2000);
		
		
		driver.findElement(By.name("login")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		String profilename = driver.findElement(By.xpath("//span[contains(text(),'Hi')]")).getText();

		Assert.assertTrue(profilename.contentEquals("Hi, " + firstName), "Login not successful");
		//driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		Thread.sleep(2000);
		
	}

	public static String randomString(int len) {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public void newRegistration(String username) {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();

	}

}
