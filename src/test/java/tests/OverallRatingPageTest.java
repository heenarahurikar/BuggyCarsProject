package test.java.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OverallRatingPageTest extends BuggyCarsBaseTest {

	private String usernameVal = "heenaautomation";
	private String passwordVal = "Heena123$";
	private String commentText = "Comment from Heena$";

	/*
	 * validate the if any images are missing or invalid under overallrating list
	 */
	@Test(priority = 2)
	public void validateImageDisplay() throws InterruptedException {
		System.out.println("Test :: validateImageDisplay()");

		// Go to Overall Rating page
		driver.findElement(By.xpath("//a[contains(@href,\"/overall\")]")).click();

		Assert.assertTrue(findBrokenImages(), "Image not displayed properly - Please check!");

		// Go to Home Page
		driver.findElement(By.xpath("//a[contains(text(),'Buggy Rating')]")).click();

	}

	public boolean findBrokenImages() throws InterruptedException {
		WebElement totalPages = driver.findElement(By.xpath("//div[@class='pull-xs-right' and contains(.,'page')]"));
		WebElement nextPage = driver.findElement(By.xpath("//a[contains(text(),'»')]"));

		int invalidImgCount = 0;
		try {
			int pageCount = Integer
					.parseInt(totalPages.getText().substring(totalPages.getText().lastIndexOf("of ") + 3));
			for (int pc = 1; pc <= pageCount; pc++) {
				Thread.sleep(1000);
				List<WebElement> imagesList = driver.findElements(By.tagName("img"));
				System.out.println("Total no of images : " + imagesList.size());
				for (WebElement imgElement : imagesList) {
					if (imgElement != null) {
						if (((imgElement.getAttribute("naturalWidth").equals("0"))
								|| (imgElement.getAttribute("naturalWidth").equals(null)))
								&& ((imgElement.getAttribute("naturalWidth").equals("0"))
										|| (imgElement.getAttribute("naturalheight").equals(null))))
							invalidImgCount++;
					}
				}
				if (pc < pageCount) {
					nextPage.click();
					Thread.sleep(1000);
				}
			}
			System.out.println("Total no of invalid images : " + invalidImgCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Thread.sleep(2000);
		if (invalidImgCount > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/*
	 * vote and verify vote for a model
	 */
	@Test(priority = 1)
	public void verifyVotingForAModel() throws InterruptedException {
		System.out.println("Test :: verifyVotingForAModel()");

		driver.findElement(By.name("login")).sendKeys(usernameVal);
		driver.findElement(By.name("password")).sendKeys(passwordVal);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		Thread.sleep(2000);

		// Go to Overall Rating page
		driver.findElement(By.xpath("//a[contains(@href,\"/overall\")]")).click();

		int rowCount = 0;

		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr/td[1]"));
		System.out.println("No of rows in Page :  = " + rows.size());
		rowCount = rows.size();

		for (int i = 1; i <= rowCount; i = i + 1) {
			driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[3]/a"))
					.click();
			Thread.sleep(1000);

			if (driver.findElements(By.xpath("//p[contains(text(),'Thank you for your vote!')]")).size() != 0) {
				driver.navigate().back(); // Thank you for your vote! Text is present
				Thread.sleep(1000);
			} else {
				driver.findElement(By.id("comment")).sendKeys(commentText);
				driver.findElement(By.xpath("//button[contains(text(),'Vote!')]")).click();
				Thread.sleep(1000);
				break;
			}
		}

		// Go to Home Page
		driver.findElement(By.xpath("//a[contains(text(),'Buggy Rating')]")).click();
		Thread.sleep(1000);
	}

}
