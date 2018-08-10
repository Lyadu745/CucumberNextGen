package cucumber;

import manager.PageObjectManager;
import manager.WebdriverManager;

public class TestContext {
	
	private WebdriverManager webdrivermanager;
	private PageObjectManager pageobjectmanager;
	
	
	public TestContext()
	{
		webdrivermanager = new WebdriverManager();
		pageobjectmanager = new PageObjectManager(webdrivermanager.getDriver());
	}
	public WebdriverManager getWebdrivermanager()
	{
		return webdrivermanager;
	}
	public PageObjectManager getPageObjectmanager()
	{
		return pageobjectmanager;
	}

}
