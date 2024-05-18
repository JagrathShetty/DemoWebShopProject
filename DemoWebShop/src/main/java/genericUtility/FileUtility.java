package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public FileInputStream fis;
	public Properties prop;
	
	public FileUtility() throws IOException {
		fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
		prop=new Properties();
		prop.load(fis);
	}
	
	public String getDataFromProperty(String key) {
		return prop.getProperty(key);
		
	}
	
}
