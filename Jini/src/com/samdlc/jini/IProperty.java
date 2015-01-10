package com.samdlc.jini;

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