package manager;

import org.openqa.selenium.WebDriver;

import pageObjects.EmailingLandingPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewsletterPage;

public class PageObjectManager {
	
	
	private WebDriver driver;
	private LoginPage login;
	private HomePage homepage;
	private EmailingLandingPage El;
	private NewsletterPage NL;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public LoginPage getLoginPage()
	{
		return (login== null) ? login = new LoginPage(driver):login;
	}
	
	public HomePage getHomePage()
	{
		return (homepage == null) ? homepage = new HomePage(driver):homepage;
		
	}
	
	public EmailingLandingPage getEmailLandingPage() {
		
		return (El==null)? El = new EmailingLandingPage(driver):El;
		
	}
	public NewsletterPage getNewsletterpage() {
		
		return (NL == null )? NL = new NewsletterPage(driver):NL;
	}

}
