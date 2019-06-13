package com.rest.qa.base;

import java.io.FileInputStream;
import java.util.Properties;


import org.testng.annotations.BeforeTest;


public class TestBase {
	
	public Properties prop;
	String propertyPath = "src/main/java/com/rest/qa/config/config.properties";
	public static int RESPONSE_STATUS_CODE_200 = 200;
	public static int RESPONSE_STATUS_CODE_201 = 201;
	public static int RESPONSE_STATUS_CODE_400 = 400;
	public static int RESPONSE_STATUS_CODE_401 = 401;
	public static int RESPONSE_STATUS_CODE_500 = 500;
	
  	
	@BeforeTest
	public void ConfigFileRead(){
		try{
			FileInputStream fis = new FileInputStream(propertyPath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		}
		catch(Exception e){}
	}

	
	
}
