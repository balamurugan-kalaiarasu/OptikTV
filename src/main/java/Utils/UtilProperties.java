package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilProperties {
	
	private Properties prop;
	
	public UtilProperties() {
		try {
            prop = new Properties();
            // load a properties file
            prop.load(new FileInputStream("src/main/java/Resources/config.properties"));
		} catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	/**
	 * 
	 * @param key
	 * @return value
	 */
	public String getPropery(String key) {
		return prop.getProperty(key);
	}
}
