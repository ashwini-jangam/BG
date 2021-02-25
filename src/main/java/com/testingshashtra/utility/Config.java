package com.testingshashtra.utility;

import org.apache.log4j.Logger;

import com.testingsshatra.exceptions.InvalidURLException;
import com.testingsshatra.exceptions.UnabletoGetBrowserException;

public class Config {
	private static final Logger LOG = Logger.getLogger(Config.class);
	public static String getBrowserName() {
		PropertyUtility prop = new PropertyUtility();
		String browser = null ;
		try {
		 browser = prop.getFileProperty("browserName");
		LOG.info("Getting BrowserName : "+ browser);
		}
		catch(Exception e) {
			LOG.error("Unable to get Browser Name");
			throw new UnabletoGetBrowserException();
		}
		return browser;

	}
	public static String  getAppUrl() {
		PropertyUtility prop = new PropertyUtility();
		String url = null ; 
		try {
		 url = prop.getFileProperty("applicatio.url");
		LOG.info("Lunching Browser : "+ url);
		}
		catch (Exception e ) {
			LOG.error("Not Getting Url");
			throw new InvalidURLException();
		}
		return url;
	}

}
