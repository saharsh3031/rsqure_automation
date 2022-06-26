package com.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandlling {
	
	Properties proprty;
	
	public PropertyHandlling() throws IOException {
		
		
		String filePath = System.getProperty("user.dir")+"\\config.property";
		proprty = new Properties();
		
		FileInputStream input = new FileInputStream(filePath);
		
	
		proprty.load(input);
	}
	
	public String getProperty(String key) {
		
		return proprty.getProperty(key);
		
	}

}
