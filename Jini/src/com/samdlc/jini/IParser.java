package com.samdlc.jini;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IParser {

	public abstract List<ISection> stringToSections(String rawString,
			ISection starting, Class<? extends ISection> sectionClass)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException;

	public abstract List<ISection> fileToSections(File input,
			ISection starting, Class<? extends ISection> sectionClass)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException;

}