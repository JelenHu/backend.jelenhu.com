package com.jelenhu.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Utility {
	
	public HashMap<String, String> getConfig(String fileName) throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		if (inputStream == null) {
            throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
        }
		
		Properties prop = new Properties();
		HashMap<String, String> configurationMap = new HashMap<String, String>();
		prop.load(inputStream);
		configurationMap.put("BackgroundTheme", prop.getProperty("BackgroundTheme"));
		configurationMap.put("BgImageHomePath", prop.getProperty("BgImageHomePath"));
		configurationMap.put("VirtualFolder", prop.getProperty("VirtualFolder"));
		
		return configurationMap;
	}
}
