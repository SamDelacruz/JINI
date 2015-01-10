package com.samdlc.jini;



/**
 * <p>This class represents an individual property entry in an .ini file.
 * It is comprised of a property name, and value.
 * Use appropriate methods for getting and setting values.</p>
 * 
 * <p><strong>Name</strong> does not accept null or empty values.</p>
 * <p><strong>Value</strong> may accept null or empty values, which are represented by empty strings.</p>
 * @author Sam Delacruz
 * @version 101
 */
public class Property {
	private String name;
	private String value;
	
	/**
	 * Prevents use of the default constructor
	 */
	private Property() {
		
	}
	
	/**
	 * @param name the name of the property
	 * @param value the value of the property
	 * @throws IllegalArgumentException when passed a null or empty name
	 */
	public Property(String name, String value) throws IllegalArgumentException{
		if(null != name && !name.trim().isEmpty()) {
			this.setName(name);
			this.setValue(value);
		} else {
			throw new IllegalArgumentException("Cannot set property name with null or empty string");
		}
	}

	/**
	 * @return the current name of the parameter
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the new name of the property. Cannot be empty or null
	 * @throws IllegalArgumentException when name is empty or null
	 */
	private void setName(String name) throws IllegalArgumentException{
		if(null != name && !name.trim().isEmpty()) {
			this.name = name.trim().toLowerCase();
		} else {
			throw new IllegalArgumentException("Cannot set property name with null or empty string");
		}
	}

	/**
	 * @return the current property value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the new value to be set. If null, value is set to an empty string
	 */
	private void setValue(String value) {
		if(null != value) {
			this.value = value.trim().toLowerCase();
		} else {
			this.value = "";
		}
	}
	
	
}
