package manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.Drivertype;
import enums.Environment;

public class WebdriverManager {
	 private WebDriver driver;
	 private static Drivertype dtype;
	 private static Environment en;
	 private static final String CHROME_DRIVER = "webdriver.chrome.driver";
	 private static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
	 private static final String IE_DRIVER = "webdriver.ie.driver";
	 
	 public WebdriverManager() {
		 dtype = FileReaderManager.getInstance().getConfigreader().getbrowser();
		 en = FileReaderManager.getInstance().getConfigreader().getEnvironment();
		 
	 }
	 public WebDriver getDriver()
	 {
		 if (driver==null)driver = createDriver();
			 return driver;
	 }
     
	 
	 private WebDriver createDriver()
	 {
		 switch(en) {
		 case LOCAL: driver = createlocaldriver();
		 break;
		 case REMOTE: driver = createRemotedriver();
		 
		 }
		return driver;
	 }
	 
	
	 
	 
	 private WebDriver createRemotedriver() {
		 throw new RuntimeException("No Remote Environment is present");
		 
	 }
	 private WebDriver createlocaldriver()
	 {
		 
		 switch(dtype) {
		 case CHROME:System.setProperty(CHROME_DRIVER, FileReaderManager.getInstance().getConfigreader().getDriverPath());
			 driver = new ChromeDriver();
			 break;
		 case FIREFOX:System.setProperty(FIREFOX_DRIVER, FileReaderManager.getInstance().getConfigreader().getDriverpathMozilla());
             driver = new FirefoxDriver();
             break;
		 case INTERNETEXPLORER:System.setProperty(IE_DRIVER, FileReaderManager.getInstance().getConfigreader().getDriverPath());
             driver = new InternetExplorerDriver();
 		 }
		
		if(FileReaderManager.getInstance().getConfigreader().getWindowmaximize())driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigreader().getimplicitwait(), TimeUnit.SECONDS);
		return driver;
	 }
	 public void closedriver() {
		 driver.close();
		 driver.quit();
		 
	 }
}
