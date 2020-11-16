package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest  {
	public String baseUrl = "https://www.google.co.nz/";
	public WebDriver driver;


	@BeforeMethod

	public void setBaseUrl()
	{

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}

	@Test
	public void verifyGooglePageTitle()  throws InterruptedException {
		driver.navigate().to("https://www.google.co.nz/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals("Condition true", actualTitle, expectedTitle);
	}


	@Test
	public void verifySearchResults() throws InterruptedException {
		
		driver.navigate().to("https://www.google.co.nz/");
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys("Selenium");
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();

		// Now, let's gather our search results
		List<WebElement> results = driver.findElements(By.cssSelector("#result-stats"));

		// Finally, we'll loop over the list to verify each result link contains our term
		for (int i = 0; i < results.size(); i++) {
			Assert.assertTrue(results.get(i).getText().contains("Selenium"), "Search result validation at instance [ + i + ]");

		}


	}
	@Test
	public void validateSearchSuggestion() 
	{
		driver.get("https://www.google.co.nz");
		driver.findElement(By.name("q")).sendKeys("Selenium");


		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

		System.out.println("Auto Suggest List ::" + list.size());

		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());

			Assert.assertTrue(list.get(i).getText().contains("Selenium"), "Search result validation at instance [ + i + ]");

		}
		
	}
	
	@AfterTest
	public void CloseDriver() 
	{
		driver.close();
		driver.quit();
	}
}





