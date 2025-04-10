package com.Automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public static String readDataFromPropertyFile(String path, String key) {
		File file =new File (path);
		FileInputStream fi = null;
		Properties propFile = new Properties();
		String data = null;
		
		try {
			fi=new FileInputStream(file);
			propFile.load(fi);
			data = propFile.getProperty(key);
			fi.close();
		}catch(FileNotFoundException e){
			System.out.println("--------Error in File Path!---------");
			e.printStackTrace();
		}catch(IOException e ) {
			System.out.println("----------Error While loading property file!----------");
			e.printStackTrace();
		}
		return data;
	}
		public static void  writeDataToPropertyFile (String path, String key, String value) {
			Properties propfile = new Properties();
			propfile.setProperty(key,value);
			FileOutputStream fo = null;
			File file = new File (path);
			try {
				fo = new FileOutputStream(file);
				propfile.store(fo, "Adding new property with value");
				fo.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e ) {
				e.printStackTrace();
			}	
		}	
	}
