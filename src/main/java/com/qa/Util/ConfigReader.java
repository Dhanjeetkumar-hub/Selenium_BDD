package com.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	//This method is used to load the properties from config.properties file
	// it returns Properties prop object
	public static Properties init_prop() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);
			
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	return prop;
	}
}

