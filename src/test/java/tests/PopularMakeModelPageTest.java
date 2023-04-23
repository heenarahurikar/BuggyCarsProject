package test.java.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopularMakeModelPageTest extends BuggyCarsBaseTest {

	/*
	 * verify popular make and model are correct verify ranking and vote count
	 */
	@Test(priority = 1)
	public void verifyPopularMakeModeal() throws InterruptedException {
		System.out.println("Test :: verifyPopularMakeModeal()");

		// Go to Overall Rating page
		driver.findElement(By.xpath("//a[contains(@href,\"/overall\")]")).click();

		System.out.println("Checking First Row Record");

		String currentMake = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[1]/td[2]"))
				.getText();
		String currentModel = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[1]/td[3]"))
				.getText();
		String currentRank = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[1]/td[4]"))
				.getText();
		String currentVotes = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[1]/td[5]"))
				.getText();

		System.out.println("Frist Record from overall Rating page - currentMake : " + currentMake + " currentModel : "
				+ currentModel + " currentRank : " + currentRank + " currentVotes : " + currentVotes);

		Thread.sleep(2000);

		// Go to Home Page
		driver.findElement(By.xpath("//a[contains(text(),'Buggy Rating')]")).click();

		String homePageCurrentMake = driver.findElement(By.xpath("//*[text() = 'Popular Make']/..//h3")).getText();
		String homePageCurrentModel = driver.findElement(By.xpath("//*[text() = 'Popular Model']/..//h3")).getText();

		System.out.println("Home Page - homePageCurrentMake : " + homePageCurrentMake + " homePageCurrentModel : "
				+ homePageCurrentModel);

		Thread.sleep(2000);

		String make = homePageCurrentMake.split("\\(")[0].trim();
		String makemodal = homePageCurrentModel.split("\\(")[0].trim();
		String votes = homePageCurrentModel.split("\\(")[1].split(" ")[0].trim();

		System.out.println("make : " + make + " makemodal : " + makemodal + " votes : " + votes);

		Assert.assertTrue(currentMake.equals(make), "Popular Make is Incorrect compare to overall rating");
		Assert.assertTrue((currentMake + " " + currentModel).equals(makemodal),
				"Popular Model is Incorrect compare to overall rating");
		Assert.assertTrue(currentRank.equals("1"), "Model Ranking is Incorrect");
		Assert.assertTrue(currentVotes.equals(votes), "Votes are Incorrect");

		Thread.sleep(2000);

	}
}
