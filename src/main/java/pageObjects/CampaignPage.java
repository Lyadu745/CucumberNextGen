package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	public void click() {
		NN.click();
	}

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(how = How.CSS,using = "input#campaignName")
	private WebElement CN ;
    
	@FindBy(how = How.CSS,using = "span#select2-newsletterId-container")
	private WebElement NN;

	public void sendKeys() {
		CN.sendKeys("");
	}

	public void clear() {
		NN.clear();
	}
    

}
