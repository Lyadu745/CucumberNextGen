package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmailingLandingPage {
	WebDriver driver;
	
	public EmailingLandingPage (WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.LINK_TEXT, using = "Newsletter")
	private WebElement Newsletter;
	
	@FindBy(how = How.LINK_TEXT,using = "Campaigns")
	private WebElement Campaigns; 
	
	@FindBy(how = How.LINK_TEXT, using = "Segments")
	private WebElement Segments;
	
	@FindBy(how = How.LINK_TEXT, using = "Reports")
	private WebElement Reports;

	@FindBy(how = How.LINK_TEXT, using = "Trigger")
	private WebElement trigger;

	@FindBy(how = How.LINK_TEXT, using = "Planning Module")
	private WebElement PM;

	@FindBy(how = How.LINK_TEXT, using = "Schedule Campaign")
	private WebElement SC;

	@FindBy(how = How.LINK_TEXT, using = "Settings")
	private WebElement settings;


    public void clickNewsletter() {
    	Newsletter.click();
    }
    
    public void clickCampaigns() {
    	Campaigns.click();
    }

    public void Segments() {
    	Segments.click();
    }
    public void trigger()
    {
    	trigger.click();
    }

    public void reports() {
    	Reports.click();
    }

    public void pm() {
    	PM.click();
    }

    public void sc() {
    	SC.click();
    }

    public void settings() {
    	settings.click();
    }


}
