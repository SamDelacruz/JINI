/**
 * 
 */
package com.samdlc.jini;

/**
 * @author Sam Delacruz
 * @version 101
 */
public interface ISection {
	/**
	 * @param name
	 * @param value
	 */
	public void addProperty(String name, String value);
	
	/**
	 * @param name
	 */
	public String getPropertyValue(String name);
	
	/**
	 * @param name
	 * @param value
	 */
	public void updateProperty(String name, String value);
	
	/**
	 * @param name
	 */
	public void deleteProperty(String name);
	
	/**
	 * @return the name of the section
	 */
	public String getName();
	
	/**
	 * @param name the new section name
	 */
	public void setName(String name);
	
	/**
	 * @return the number of properties associated with the section
	 */
	public Integer getLength();
	
	/**
	 * @return a string array of all property names
	 */
	public String[] getAllPropertyNames();
	
	/**
	 * @return a string array of all property values
	 */
	public String[] getAllPropertyValues();
	
	/**
	 * @param index
	 * @return
	 */
	public String getPropertyName(Integer index);
	
	/**
	 * @param index
	 * @return
	 */
	public String getPropertyValue(Integer index);
}
