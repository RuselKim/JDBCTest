package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManger {
	private static PropertiesManger instance;
	private FileInputStream fileInputStream;
	private Properties properties = new Properties();

	public Properties getProperties() {
		return properties;
	}

	private PropertiesManger(){
		loadProperties();
	}
	
	public static PropertiesManger getInstance(){
		if (instance == null) {
			instance = new PropertiesManger();
		}
		return instance;
	}
	
	private void loadProperties() {
		try {
			fileInputStream = new FileInputStream("src/main/java/resources/properties");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			System.out.println("Property file is not found");
			e.printStackTrace();
		}
	}
	
}
