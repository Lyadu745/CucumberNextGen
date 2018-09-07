package pageObjects;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(how = How.CSS, using = "button#disable")
	private WebElement LiveTime;

	@FindBy(how = How.CSS, using = "input.select2-search__field")
	private WebElement Selectsegment;

	@FindBy(how = How.CSS, using = "button#fetchSegments")
	private WebElement ClickFetchCount;

	@FindBy(how = How.CSS, using = "select#domain")
	private WebElement selectDomain;

	@FindBy(how = How.CSS, using = "select#domainname")
	private WebElement selectDomainName;

	@FindBy(how = How.CSS, using = "select#campaignType")
	private WebElement selectCampaigntype;

	@FindBy(how = How.CSS, using = "select#tags")
	private WebElement selectCampaigntags;

	@FindBy(how = How.CSS, using = "input#scheduledCount")
	private WebElement EnterMaxvalCap;

	@FindBy(how = How.CSS, using = "input#rto1")
	private WebElement selectRTO1;

	By clickRto = By.cssSelector("span#select2-rto1_newsletterId-container");

	@FindBy(how = How.CSS, using = "button#save")
	private WebElement ClickonSave;

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
		ArrayList<WebElement> Newsnames = (ArrayList<WebElement>) driver
				.findElements(By.xpath("/html/body/span/span/span[2]/ul/li"));
		for (WebElement a : Newsnames) {

			if (a.getText().equals(customer.CampaignDetails.NewsletterName)) {
				a.click();
				Thread.sleep(3000);
				break;

			}

		}

	}

	public void ClickonLiveTime() throws Exception {
		LiveTime.click();
		Thread.sleep(5000);
	}

	public void selSegment(Customer customer) throws Exception {
		Selectsegment.click();
		ArrayList<WebElement> Segnames = (ArrayList<WebElement>) driver
				.findElements(By.xpath("/html/body/span/span/span/ul/li"));
		for (int i = 0; i <= Segnames.size(); i++) {
			WebElement a1 = Segnames.get(i);
			String a = a1.getText();
			if (a.equals(customer.CampaignDetails.SegmentName)) {
				a1.click();
				Thread.sleep(5000);
				break;
			}

		}

	}

	public void fetchcount() {
		ClickFetchCount.click();
	}

	public void SelDomain(Customer customer) {
		Select a1 = new Select(selectDomain);
		a1.selectByVisibleText(customer.CampaignDetails.Domain);
	}

	public void selDomainname(Customer customer) throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Select a2 = new Select(selectDomainName);
		a2.selectByValue(customer.CampaignDetails.DomainName);
	}

	public void selcamptype(Customer customer) {
		Select a3 = new Select(selectCampaigntype);
		a3.selectByVisibleText(customer.CampaignDetails.CampaignType);
		if (customer.CampaignDetails.CampaignType.equals("Engagement")) {
			Select a4 = new Select(selectCampaigntags);
			a4.selectByVisibleText(customer.CampaignDetails.Campaigntag);
		}
	}

	public void ClickSave() {
		ClickonSave.click();
	}

	public void entermaxcap(Customer customer) throws Exception {
		EnterMaxvalCap.sendKeys(customer.CampaignDetails.MaxVolumeCap);
		Thread.sleep(5000);
	}

	public void ScheduleRTOs(Customer customer)  {
		String a = "Yes";
		if (a.equals(customer.CampaignDetails.ScheduleRTos)) {

			selectRTO1.click();
			driver.findElement(clickRto).click();
			
			JavascriptExecutor browser = ((JavascriptExecutor) driver);
			browser.executeScript("arguments[0].click()", ClickonSave);

		} else {
			JavascriptExecutor browser = ((JavascriptExecutor) driver);
			browser.executeScript("arguments[0].click()", ClickonSave);

			/* For Find ing Coordinates and then Perform CLick */
			/**
			 * Point point = ClickonSave.getLocation(); int xcord = point.getX();
			 * System.out.println("Position of the webelement from left side is " + xcord +
			 * " pixels"); int ycord = point.getY(); System.out.println("Position of the
			 * webelement from top side is " + ycord + " pixels"); Actions action = new
			 * Actions(driver); // clicking on the logo based on x coordinate and y
			 * coordinate // you will be redirecting to the home page of
			 * softwaretestingmaterial.com action.moveToElement(ClickonSave, xcord,
			 * ycord).click().build().perform();
			 */
		}
	}

}
