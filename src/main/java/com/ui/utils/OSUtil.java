package com.utils.ui.utils;

import java.util.Locale;

import com.utils.ui.enums.OSType;


/**
 *  
 *
 */
public class OSUtil {

	private static OSType operatingSystem;

	public static OSType getOperatingSystemType() {
		if (operatingSystem == null) {
			String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
			if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
				operatingSystem = OSType.MacOS;
			} else if (OS.indexOf("win") >= 0) {
				operatingSystem = OSType.Windows;
			} else if (OS.indexOf("nux") >= 0) {
				operatingSystem = OSType.Linux;
			} else {
				operatingSystem = OSType.Other;
			}
		}
		return operatingSystem;
	}

}
