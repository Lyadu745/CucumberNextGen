package manager;

import dataprovider.ConfigFileReader;
import dataprovider.JsonDataReader;

public class FileReaderManager {
	
	private static  FileReaderManager filereadermanager = new  FileReaderManager();
	private ConfigFileReader config;
	private JsonDataReader jsondata;
	
	private FileReaderManager()
	{
	}
	
		public static FileReaderManager getInstance()
		{
			return filereadermanager;
			
		}
		public ConfigFileReader getConfigreader()
		{
			return (config == null)? config = new ConfigFileReader():config;
		}
		
		public JsonDataReader getjsondatareader() {
			return (jsondata == null) ? jsondata = new JsonDataReader():jsondata;
		}
	
	
	

}
