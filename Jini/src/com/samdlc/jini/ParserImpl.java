package com.samdlc.jini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.samdlc.jini.prototype.ProtoIniReader;

/**
 * @author Sam Delacruz
 * @version 101
 */
public class ParserImpl implements IParser {
	/* (non-Javadoc)
	 * @see com.samdlc.jini.IParser#stringToSections(java.lang.String, com.samdlc.jini.ISection, java.lang.Class)
	 */
	@Override
	public List<ISection> stringToSections(String rawString, ISection starting, Class<? extends ISection> sectionClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<ISection> sectionList = new ArrayList<ISection>();
		String[] lines = splitToLines(rawString);
		ISection current = starting;
		for(String line:lines) {
			
			String[] parsedLine = null;
			parsedLine = parseLine(line);

			if(null != parsedLine) {
				if(parsedLine.length == 1) {
					//section - create new section and move on
					sectionList.add(current);
					current = sectionClass.getDeclaredConstructor(String.class).newInstance(parsedLine[0]);
				}
				if(parsedLine.length == 2) {
					//property - add to current section
					current.addProperty(parsedLine[0], parsedLine[1]);
				}
			}
		}
		sectionList.add(current);
		return sectionList;
	}
	
	/* (non-Javadoc)
	 * @see com.samdlc.jini.IParser#fileToSections(java.io.File, com.samdlc.jini.ISection, java.lang.Class)
	 */
	@Override
	public List<ISection> fileToSections(File input, ISection starting, Class<? extends ISection> sectionClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		BufferedReader reader = null;
		List<ISection> sectionList = new ArrayList<ISection>();
		ISection current = starting;
		
		try {
			String line = null;
			reader = new BufferedReader(new FileReader(input));
			while((line = reader.readLine())!=null) {
				String[] parsedLine = parseLine(line);
				if(null != parsedLine) {
					if(parsedLine.length == 1) {
						//section - create new section and move on
						sectionList.add(current);
						current = sectionClass.getDeclaredConstructor(String.class).newInstance(parsedLine[0]);
					}
					if(parsedLine.length == 2) {
						//property - add to current section
						current.addProperty(parsedLine[0], parsedLine[1]);
					}
				}
			}
			sectionList.add(current);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sectionList;
		
	}
	
	private String[] splitToLines(String rawString) {
		return rawString.split("\n");
	}

	private String[] parseLine(String line) {
		String s = line.replaceAll(" ", "");
		if(s.startsWith("[") && s.endsWith("]") && s.length() > 2) {
			// Parsed as section
			return new String[]{s.substring(1, s.length()-1)};
		}
		if(s.contains("=") && s.length() > 2 && s.indexOf("=") > 0) {
			// Parsed as property
			String name = s.substring(0, s.indexOf("="));
			String value = s.substring(s.indexOf("=")+1);
			return new String[]{name,value};
		}
		// Invalid line, return null
		return null;
	}
	
}
