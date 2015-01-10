package com.samdlc.jini;

/**
 * @author Sam Delacruz
 * @version 101
 */
public interface IProperty {

	/**
	 * @return the current name of the parameter
	 */
	public abstract String getName();

	/**
	 * @return the current property value
	 */
	public abstract String getValue();

}