package seleniumtests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emailing {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lalit\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.96.205.227/nxtgencr/login");
		WebElement ele  = driver.findElement(By.cssSelector("input#username"));
		ele.sendKeys("admin");
		ele = driver.findElement(By.cssSelector("input#password"));
		ele.sendKeys("admin");
		ele = driver.findElement(By.cssSelector("input.button"));
		ele.click();
		String d ="dfg";
		ArrayList<WebElement> list = (ArrayList<WebElement>)driver.findElements(By.xpath(""));

	}

}
