package dataprovider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import enums.Drivertype;
import enums.Environment;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyfilepath = "configs/configuration.properties";
	
	public ConfigFileReader()
	{
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader(propertyfilepath));
		    properties = new  Properties();
		try
		{
			properties.load(reader);
			reader.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file is not found at"+propertyfilepath);
		}
	}
	public boolean getWindowmaximize()
	{
		String wm = properties.getProperty("Windowmaximize");
		if(wm!= null) return Boolean.valueOf(wm);
		return true;
		
	}
	
	public String getDriverPath()
	{
		String driver = properties.getProperty("Driverpath");
		if(driver != null) return driver;
	
		else throw new RuntimeException("Configuration file driverpath value is null or not specified");
    }
	public String  getDriverpathMozilla()
	{
		String d1 = properties.getProperty("DriverpathM");
		
		if(d1 != null) return d1;
		else throw new RuntimeException("Configuration file driverpath value is null or not specified");
		
	}
	
	public Drivertype getbrowser() {
		String bname = properties.getProperty("browser");
		
		if(bname.equalsIgnoreCase("chrome")) return Drivertype.CHROME;
		else if(bname.equalsIgnoreCase("firefox")) return Drivertype.FIREFOX;
		else if(bname.equals("iexplorer")) return Drivertype.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not match");
		
	}
	public Environment getEnvironment() {
		String env = properties.getProperty("environment");
		if(env.equalsIgnoreCase("Local")) return Environment.LOCAL;
		else if(env.equals("Remote")) return Environment.REMOTE;
		else throw new RuntimeException("Environment not found");
	}
	
	public long getimplicitwait() {
		String time = properties.getProperty("implicitlywait");
		
		if(time != null) return Long.parseLong(time);
		else throw new RuntimeException("Configuration file time value is null or not specified");
		
	}
	public String geturl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("Configuration file url value is null or not specified");
	}
	
	public String getJsonPath()
	{
		String path = properties.getProperty("testresourcespath");
		
		if(path != null)
			{System.err.println(path);
			return path;
			}
		else throw new RuntimeException("Json File Path is not present");
	}
	
	public String getextentreports() {
		String extentreport = properties.getProperty("reportConfigPath");
		if(extentreport != null) return extentreport;
		else throw new RuntimeException("File not Found");
	}
	
	
}