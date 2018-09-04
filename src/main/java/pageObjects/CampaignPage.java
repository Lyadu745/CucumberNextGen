package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testdatatypes.Customer;

public class CampaignPage {
	

	private WebDriver driver;

	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Campaigns")
	private WebElement Campaigns;

	@FindBy(how = How.CSS, using = "input#campaignName")
	private WebElement CN;

	@FindBy(how = How.CSS, using = "span#select2-newsletterId-container")
	private WebElement NN;

	public void clickcampaign() {
		Campaigns.click();
	}

	public void EnterCampaignName(Customer customer) {
		CN.sendKeys(customer.CampaignDetails.Campaignname);
	}

	public void SelectNewsLetter(Customer customer) throws Exception {

		NN.click();
		Thread.sleep(5000);
		System.out.println("Test");
		List<WebElement> Newsnames = driver.findElements(By.xpath("/html/body/span/span/span[2]/ul/li"));
		for (WebElement a : Newsnames) {

			if (a.getText().equals(customer.CampaignDetails.NewsletterName)) {
				a.click();
				Thread.sleep(3000);

			}

		}

	}

}
