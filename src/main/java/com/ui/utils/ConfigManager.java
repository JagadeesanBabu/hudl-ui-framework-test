package com.utils.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Singleton to load the properties

 *  
 *
 */
public class ConfigManager {
	
	private static final Logger LOGGER = Logger.getLogger(ConfigManager.class);

	private static Map<String, String> config = new HashMap<String, String>();

	public ConfigManager() {

	}

	private static ConfigManager configurator;

	public static ConfigManager getInstance() {
		if (configurator == null)
			return new ConfigManager();
		return configurator;
	}

	public void loadConfigurations() {

		String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
		LOGGER.info("Configurations path: " + path);
		
		// try with resources
		try (InputStream input = new FileInputStream(path)) {
			Properties prop = new Properties();
			prop.load(input);
			
			Set<Object> keys = prop.keySet();

			for (Object k : keys) {
				String key = (String) k;
				String value = prop.getProperty(key);
				config.put(key, value);
			}
	
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	// To get static map
	public Map<String, String> getConfig() {
		if(config.isEmpty())
			loadConfigurations();
		return config;
	}
}
