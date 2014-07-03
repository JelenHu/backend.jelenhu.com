package com.jelenhu.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Utility {
	
	public HashMap<String, String> getConfig(String fileName) throws IOException {
		
//		File f = new File(fileName);
//		System.out.println("###############################"+f.getAbsolutePath());
		
		InputStream inputStream = getClass().getResourceAsStream(fileName);
		if (inputStream == null) {
            throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
        }
		
		Properties prop = new Properties();
		HashMap<String, String> configurationMap = new HashMap<String, String>();
		prop.load(inputStream);
		configurationMap.put("BackgroundTheme", prop.getProperty("BackgroundTheme"));
		configurationMap.put("BgImageHomePath", prop.getProperty("BgImageHomePath"));
		configurationMap.put("VirtualFolder", prop.getProperty("VirtualFolder"));
		configurationMap.put("ThemeName", prop.getProperty("ThemeName"));
		configurationMap.put("ThemeContent", prop.getProperty("ThemeContent"));
		
		return configurationMap;
	}
}
