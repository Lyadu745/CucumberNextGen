package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testdatatypes.Customer;



public class HomePage {
	

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.CSS,using = "input#username")
	private WebElement Username;
	
	@FindBy(how = How.CSS,using = "input#password")
	private WebElement Password;
	
	@FindBy(how = How.CSS,using = "input.button")
	private WebElement login;
	
	public void enter_name(String name)
	{
		Username.sendKeys(name);
	}
	public void enter_password(String password)
	{
		Password.sendKeys(password);
	}
	
	public void click()
	{
		login.click();
	}
	
	public void details(Customer customer)
	{
		enter_name(customer.Username);
		System.out.println(customer.Username);
		enter_password(customer.password);
		System.out.println(customer.NewsletterDetails.Newslettername);
		
	}
	public void details() {
		enter_name("admin");
		enter_password("Nextgen");
		
		
	}
	
}
