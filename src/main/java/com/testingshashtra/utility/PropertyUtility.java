package com.testingshashtra.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtility {
	private static final Logger LOG = Logger.getLogger(PropertyUtility.class);
	public String getFileProperty(String key) {
		Properties prop = loadApplicationProperties(); 
		return prop.getProperty(key);
	}
	/*public String getApplicationURL() {
		Properties prop = loadApplicationProperties(); 
		return prop.getProperty("applicatio.url");
		
	}*/

	private Properties loadApplicationProperties() {
		String path = System.getProperty("user.dir");
		FileInputStream fis = null ;
		try {
			 fis = new FileInputStream(path + "/src/main/resources/Application.properties");
		} catch (FileNotFoundException e) {
		 LOG.error("Unable to find Property file");	
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
		 LOG.error("Unable to read property file");
		}
		return prop;
	}

	
}
