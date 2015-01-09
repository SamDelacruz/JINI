package com.samdlc.jini.prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			List<String> lines = new ArrayList<String>();
			while(null != line) {
				try {
					line = reader.readLine();
					if(null != line)
						lines.add(line);
				} catch (IOException e) {
					log(e.getLocalizedMessage(), ProtoIniReader.class);
					e.printStackTrace();
				}
			}
			
			Map<String,String> variables = new HashMap<String,String>();
			
			if(!lines.isEmpty()) {
				// parse each line
				for(String l:lines) {
					String[] splitLine = l.split("=", 2);
					variables.put(splitLine[0], splitLine[1]);
				}
				
				print(variables.toString());
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
