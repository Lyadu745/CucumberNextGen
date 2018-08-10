package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testdatatypes.Customer;

public class NewsletterPage {

	WebDriver driver;

	public NewsletterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Newsletter")
	private WebElement ClickonNews;

	@FindBy(how = How.CSS, using = "input#name")
	private WebElement NewName;

	@FindBy(how = How.CSS, using = "input#senderName")
	private WebElement SenderName;

	@FindBy(how = How.CSS, using = "input#subject")
	private WebElement Subjectline;

	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-categoryId-container\"]")
	private WebElement drop1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-subCategoryId-container\"]")
	private WebElement drop2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-customerId-container\"]")
	private WebElement drop3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-clientId-container\"]")
	private WebElement drop4;

	@FindBy(how = How.CSS, using = "select#hostindServerId")
	private WebElement drop5;

	@FindBy(how = How.CSS, using = "input#fileToUpload")
	private WebElement choosefile;

	@FindBy(how = How.CSS, using = "input#zipUpload")
	private WebElement uploadbutton;

	@FindBy(how = How.CSS, using = "button#save")
	private WebElement Savebutton;

	@FindBy(how = How.LINK_TEXT, using = "View NewsLetters")
	private WebElement viewNewsletter;

	public void clickonNews() {
		ClickonNews.click();

	}

	public void EnterNewsname(String name) {

		NewName.sendKeys(name);

	}

	public void EnterSenderName(String name1) {
		SenderName.sendKeys(name1);
	}

	public void Entersubjectline(String sub) {
		Subjectline.sendKeys(sub);
	}

	public void SelectCategory(String val) throws Exception {
		drop1.click();
		try {
			List<WebElement> data = driver.findElements(By.xpath("/html/body/span/span/span/ul/li"));
			for (WebElement ae : data) {

				String a = ae.getText();

				if (a.equalsIgnoreCase(val)) {
					ae.click();
					Thread.sleep(5000);
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Category selected");
		}
	}

	public void Selectsubcategory(String val2) {
		drop2.click();
		try {
			List<WebElement> data = driver.findElements(By.xpath("/html/body/span/span/span[2]/ul/li"));
			for (WebElement ae : data) {

				String a = ae.getText();

				if (a.equalsIgnoreCase(val2)) {
					ae.click();

				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Subcategory selected");
		}

	}

	public void SelectCustomername(String val3) throws Exception {
		drop3.click();
		try {
			List<WebElement> data = driver.findElements(By.xpath("/html/body/span/span/span[2]/ul/li"));
			for (WebElement ae : data) {

				String a = ae.getText();

				if (a.equalsIgnoreCase(val3)) {
					ae.click();
					Thread.sleep(3000);

				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("customername selected");
		}

	}

	public void Selectclientname(String val4) {
		drop4.click();
		try {
			List<WebElement> data = driver.findElements(By.xpath("/html/body/span/span/span[2]/ul/li"));
			for (WebElement ae : data) {

				String a = ae.getText();

				if (a.equalsIgnoreCase(val4)) {
					ae.click();

				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("clientname selected");
		}

	}

	public void SelectHostingServer(String val5) {
		Select A = new Select(drop5);
		A.selectByVisibleText(val5);
	}

	public void Uploadfile(String val6, String val7) throws Exception {

		choosefile.sendKeys("C:\\Users\\Lalit\\Downloads\\A.zip");
		Thread.sleep(3000);
		uploadbutton.click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#insertHeaderbtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#insertFooterbtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("textarea#open_sms")).sendKeys(val6);
		driver.findElement(By.cssSelector("textarea#click_sms")).sendKeys(val7);
	}

	public void Screenshot() {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\E\\Taskbucks\\NewsletterScreenshots\\1.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void ClickSave() {
		Savebutton.click();

	}

	public void enterdetails(Customer customer) throws Exception {
		EnterNewsname(customer.NewsletterDetails.Newslettername);
		EnterSenderName(customer.NewsletterDetails.Sendername);
		Entersubjectline(customer.NewsletterDetails.SubjectLine);
		SelectCategory(customer.NewsletterDetails.category);
		Selectsubcategory(customer.NewsletterDetails.subcategory);
		SelectCustomername(customer.NewsletterDetails.customername);
		Selectclientname(customer.NewsletterDetails.clientname);
		SelectHostingServer(customer.NewsletterDetails.Hostingserver);
		Uploadfile(customer.NewsletterDetails.opensms, customer.NewsletterDetails.clicksms);
		ClickSave();
	}

	public void clickonviewNewsletter(Customer customer) {
		viewNewsletter.click();
		Screenshot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			List<WebElement> Newsletters = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]/p"));
			for (WebElement N : Newsletters) {

				String ab = N.getAttribute("title");
				System.out.println(ab);
				if (ab.equalsIgnoreCase(customer.NewsletterDetails.Newslettername)) {
					N = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr/td[6]/a[5]"));
					N.click();
					driver.switchTo().alert().accept();

				}

			}
		} catch (StaleElementReferenceException e) {
			System.out.println(" Newsletter Deleted");
		}
	}

}
