package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Google_Search {
		WebDriver driver;

		By logo = By.cssSelector("#hplogo");
		By searchbox = By.xpath("//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
		By search_Button = By.cssSelector("body.hp.vasq:nth-child(2) div.ctr-p:nth-child(3) div.jhp:nth-child(3) form.tsf:nth-child(4) div:nth-child(2) div.A8SBwf:nth-child(1) div.FPdoLc.tfB0Bf:nth-child(4) center:nth-child(1) > input.gNO89b");
		
		public Google_Search(WebDriver driver)
		{
			this.driver= driver;

		}

		//Set name in textbox

		public void setString(String str) {

			driver.findElement(searchbox).sendKeys(str);

		}
		
		public void searchBtn() {
			
			driver.findElement(search_Button).click();
			
		}
}
