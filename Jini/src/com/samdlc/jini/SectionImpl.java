package com.samdlc.jini;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdelacruz
 * @version 101
 */
public class SectionImpl implements ISection {
	
	private String name;
	private List<IProperty> properties;

	/**
	 * Private default constructor to prevent use
	 */
	private SectionImpl() {
		
	}
	
	public SectionImpl(String name) throws IllegalArgumentException{
		if(null != name && !"".equals(name.trim())) {
			this.name = name.trim().toLowerCase();
			properties = new ArrayList<IProperty>();
		} else {
			throw new IllegalArgumentException("Section must have a name");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#addProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void addProperty(String name, String value) throws IllegalArgumentException {
		IProperty newProp = new PropertyImpl(name, value);
		if(!properties.contains(newProp)) {
			properties.add(newProp);
		} else {
			throw new IllegalArgumentException("Property with same name already exists");
		}
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getProperty(java.lang.String)
	 */
	@Override
	public String getPropertyValue(String name) {
		for(IProperty prop:properties) {
			if(prop.getName().equals(name.trim().toLowerCase())) {
				return prop.getValue();
			}
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#updateProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateProperty(String name, String value) throws IllegalArgumentException{
		IProperty newProp = new PropertyImpl(name, value);
		for(IProperty prop:properties) {
			if(prop.equals(newProp)) {
				int index = properties.indexOf(prop);
				properties.remove(prop);
				properties.add(index, newProp);
				return;
			}
		} 
		properties.add(newProp);
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#deleteProperty(java.lang.String)
	 */
	@Override
	public void deleteProperty(String name) {
		for(IProperty prop:properties) {
			if(prop.getName().equals(name)) {
				properties.remove(prop);
				return;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		if(null != name && !"".equals(name)) {
			this.name = name;
		}
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getLength()
	 */
	@Override
	public Integer getLength() {
		return properties.size();
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getAllPropertyNames()
	 */
	@Override
	public String[] getAllPropertyNames() {
		List<String> names = new ArrayList<String>();
		for(IProperty prop: properties) {
			names.add(prop.getName());
		}
		return names.toArray(new String[0]);
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getAllPropertyValues()
	 */
	@Override
	public String[] getAllPropertyValues() {
		List<String> values = new ArrayList<String>();
		for(IProperty prop:properties) {
			values.add(prop.getValue());
		}
		return values.toArray(new String[0]);
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getPropertyName(java.lang.Integer)
	 */
	@Override
	public String getPropertyName(Integer index) {
		return properties.get(index).getName();
	}

	/* (non-Javadoc)
	 * @see com.samdlc.jini.ISection#getPropertyValue(java.lang.Integer)
	 */
	@Override
	public String getPropertyValue(Integer index) {
		return properties.get(index).getValue();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("["+this.getName()+"]\n");
		for(IProperty prop:properties) {
			sb.append(prop.toString()+"\n");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof ISection) {
			if((this.getName().equals(((ISection)other).getName())))
					return true;
		}
		return false;
	}
	
}
