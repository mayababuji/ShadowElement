package utilities;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
public class ConfigReader {
	//Define the config propery path
	//private static String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/Config/config.properties";
	private static String propertyFilePath = "src/test/resources/Config/config.properties";
	 // Properties object to store the configuration
	private static Properties properties;
	static {
		// assigning a new Properties object to the existing variable named properties.
		properties = new Properties();//“Without initializing properties, it stays null, and any attempt to use it throws a NullPointerException at runtime.”
		//Properties = new Properties();Properties (with capital P) is a class name, not a variable.
		try {
			File file = new File(propertyFilePath);
        	System.out.println("Config file exists: " + file.exists());
        	System.out.println("Absolute path: " + file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(propertyFilePath);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
 	}
	public  static String getValue(String key) {
		String value = properties.getProperty(key);
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("The value"+value+" is not specifies in the config.properties");
		}
		
	}
	
	public static void main(String[] args) {
		ConfigReader read = new ConfigReader();
		String url = read.getValue("url");
		System.out.println(url);
		
	}

}
