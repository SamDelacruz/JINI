package com.samdlc.jini.prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ProtoIniReader {

	public static void main(String[] args) {
		log("Input filepath: " + args[0], ProtoIniReader.class);
		File iniFile = new File(args[0]);
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(iniFile));
		} catch (FileNotFoundException e) {
			log(e.getLocalizedMessage(), ProtoIniReader.class);
			e.printStackTrace();
		}
		
		if(null != reader) {
			String line = "";
			for(int i = 1; null != line; i++) {
				try {
					line = reader.readLine();
					if(null != line)
						print("line " + i + ": " + line);
				} catch (IOException e) {
					log(e.getLocalizedMessage(), ProtoIniReader.class);
					e.printStackTrace();
				}
			}
		} else {
			log("BufferedReader was null", ProtoIniReader.class);
		}
	}
	
	private static void print(String s) {
		System.out.println(s);
	}
	
	private static void log(String s, Class c) {
		print(c.getCanonicalName() + ": " + s);
	}
	
}
